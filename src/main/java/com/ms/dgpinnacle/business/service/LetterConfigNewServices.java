package com.ms.dgpinnacle.business.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_OPERATION_DUPL;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.ms.dgpinnacle.business.clients.EncompassClient;
import com.ms.dgpinnacle.business.clients.dto.EncompassResponseDto;
import com.ms.dgpinnacle.business.clients.dto.EncompassTokenResponseDto;
import com.ms.dgpinnacle.business.dto.ClientDto;
import com.ms.dgpinnacle.business.dto.EnCompassLetterConfigDto;
import com.ms.dgpinnacle.business.dto.LetterConfigDto;
import com.ms.dgpinnacle.business.dto.RealtorOperationDto;
import com.ms.dgpinnacle.business.entity.Client;
import com.ms.dgpinnacle.business.entity.ClientOperation;
import com.ms.dgpinnacle.business.entity.LetterConfig;
import com.ms.dgpinnacle.business.entity.Operation;
import com.ms.dgpinnacle.business.entity.Realtor;
import com.ms.dgpinnacle.business.entity.RealtorOperation;
import com.ms.dgpinnacle.business.repository.ClientOperationRepository;
import com.ms.dgpinnacle.business.repository.ClientRepository;
import com.ms.dgpinnacle.business.repository.LetterConfigRepository;
import com.ms.dgpinnacle.business.repository.LetterFixDataRepository;
import com.ms.dgpinnacle.business.repository.LoanOfficerRepository;
import com.ms.dgpinnacle.business.repository.OperationRepository;
import com.ms.dgpinnacle.business.repository.RealtorOperationRepository;
import com.ms.dgpinnacle.business.repository.RealtorRepository;
import com.ms.dgpinnacle.security.token.UserPrincipal;
import com.ms.dgpinnacle.utils.Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class LetterConfigNewServices {

	private final LetterConfigRepository letterConfigRepository;
	private final ClientRepository clientRepository;
	private final ClientNewServices clientServices;
	private final RealtorRepository realtorRepository;
	private final RealtorNewServices realtorServices;
	private final EncompassClient encompassClient;
	private final LetterFixDataRepository letterFixDataRepository;
	private final OperationRepository operationRepository;
	private final ClientOperationRepository clientOperationRepository;
	private final RealtorOperationRepository realtorOperationRepository;
	private final LoanOfficerRepository loanOfficerRepository;
    private final ServletContext servletContext;
	private final TemplateEngine templateEngine;

	public List<LetterConfigDto> findAllLetterList(UserPrincipal token) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<LetterConfigDto> result = letterConfigRepository.findAllLetterList();

		for (LetterConfigDto item : result) {
			item.setRealtors(realtorRepository.getRealtorsByLetter(item.getId()));
			item.setClients(clientRepository.getClientsByLetter(item.getId()));
		}

		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

	public Boolean save(UserPrincipal token, LetterConfigDto request) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));

		// Check if there is an existing operation with the given data
		Operation operation = operationRepository.findOperationByClientsAndRealtorsAndLoan(
				request.getRealtors().stream().map(RealtorOperationDto::getId).collect(Collectors.toList()),
				request.getClients().stream().map(ClientDto::getId).collect(Collectors.toList()), token.getIdUsuario());

		// If there is an existing operation and no operationId is provided, throw an
		// exception
		if (Objects.nonNull(operation) && Objects.isNull(request.getOperationId())) {
			throw new Exception(MSG_OPERATION_DUPL);
		}

		// Map and validate the letter configuration
		LetterConfig letter = Utils.mapperEntitySet(request, letterFixDataRepository.findById(1L).orElse(null));

		// Disable the previous letter if all validations pass
		disableLetter(request);

		// If we are editing and the id is not null
		if (Objects.isNull(request.getId())) {
			// Create a new operation if it does not exist
			operation = new Operation("LETTER");
			operation.setLoanOfficer(loanOfficerRepository.findById(token.getIdUsuario()).orElse(null));
			operationRepository.save(operation);

			// Get and save realtors and clients for the operation
			ArrayList<RealtorOperation> realtors = realtorServices.getRealtorOperationList(request, operation);
			ArrayList<ClientOperation> clients = clientServices.getClientOperationList(request, operation);
			clientOperationRepository.saveAll(clients);
			realtorOperationRepository.saveAll(realtors);
		} else {
			// Otherwise, retrieve the existing operation
			operation = operationRepository.findById(request.getOperationId()).orElse(null);
		}

		// Set the operation for the letter and save the letter configuration
		letter.setOperation(operation);
		letterConfigRepository.save(letter);

		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return Boolean.TRUE;
	}

	public void disableLetter(LetterConfigDto request) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		if (Objects.nonNull(request.getId())) {
			LetterConfig letter = letterConfigRepository.findById(request.getId()).orElseThrow();
			letter.setActive(false);
			letterConfigRepository.save(letter);
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
	}
	
	
	
	public EnCompassLetterConfigDto findDetailsEnCompass(String loanId) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		EnCompassLetterConfigDto result = new EnCompassLetterConfigDto();

		EncompassTokenResponseDto eToken = encompassClient.getToken();
		EncompassResponseDto response = encompassClient.getLoan(eToken.getAccess_token(), loanId);
		
		result.setLoanServicesId(loanId);

		//get Clients and realtors
		result.setClients(Utils.getClientsEnCompassDto(response.getApplications()));
		result.setRealtors(Utils.getRealtorsEnCompassDto(response.getContacts()));
		
		//get loan
		result.setLoanOfficer(Utils.getLoanOfficerEnCompassDto(response));
		
		//letter data
		result.setHoa(0.0);
		result.setPrice(response.getClosingCost().getDisclosedSalesPrice().intValue());
		result.setTaxes(Double.valueOf(response.getProposedRealEstateTaxesAmount()));
		result.setLocation(response.getProperty().getCity() + ", " + response.getProperty().getState());
		result.setLoanType(response.getMortgageType());
		result.setInterest(response.getRequestedInterestRatePercent());
		// result.setMaxPay(responseJson.get("principalAndInterestMonthlyPaymentAmount").asDouble());
		result.setLtv(response.getLtv());
		result.setInsurance(Double.valueOf(response.getProposedHazardInsuranceAmount()));
		result.setMi(result.getLoanType().equalsIgnoreCase("Conventional") ? 0.0
				/* response.get("mortgageInsurancePremiumUpfrontFactorPercent").asDouble() */ : 0.0);
		result.setLoanAmount(0.0);
		
		
		
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}
	
	public Boolean saveEnCompass(UserPrincipal token, EnCompassLetterConfigDto request) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		
		List<Client> clients = clientServices.getClientOrSave(request);
		List<Realtor> realtors = realtorServices.getRealtorOrSave(token, request.getRealtors());
		

		// Check if there is an existing operation with the given data
		Operation operation = operationRepository.findOperationByClientsAndRealtorsAndLoan(
				clients.stream().map(Client::getId).collect(Collectors.toList()),
				realtors.stream().map(Realtor::getId).collect(Collectors.toList()), token.getIdUsuario());

		// Map and validate the letter configuration
		LetterConfig letter = Utils.mapperEntitySet(request, letterFixDataRepository.findById(1L).orElse(null));

		// Disable the previous letter if all validations pass
		if (Objects.nonNull(operation)) {
			disableLastLetterOfOperation(operation);
		}else {
			// Create a new operation if it does not exist
			operation = new Operation("LETTER");
			operation.setLoanOfficer(loanOfficerRepository.findById(token.getIdUsuario()).orElse(null));
			operationRepository.save(operation);
			
			// Get and save realtors and clients for the operation
			ArrayList<RealtorOperation> realtorsOp = realtorServices.getRealtorOperationList(realtors, operation);
			ArrayList<ClientOperation> clientsOp = clientServices.getClientOperationList(clients, operation);
			clientOperationRepository.saveAll(clientsOp);
			realtorOperationRepository.saveAll(realtorsOp);
		}
			
		// Set the operation for the letter and save the letter configuration
		letter.setOperation(operation);
		letterConfigRepository.save(letter);

		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return Boolean.TRUE;
	}
	
	
	public void disableLastLetterOfOperation(Operation operation) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<LetterConfig> list = operationRepository.findlettersByOperationId(operation.getId());
		for (LetterConfig letter : list) {
			letter.setActive(false);
		}
		letterConfigRepository.saveAll(list);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
	}
	
	@SuppressWarnings("deprecation")
	public byte[] getLetterDocument(Long id, UserPrincipal token, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		//cargo los datos de la letter
		LetterConfigDto letter = letterConfigRepository.findLetterDataById(id);
		letter.setRealtors(realtorRepository.getRealtorsByLetter(id));
		letter.setClients(clientRepository.getClientsByLetter(id));
		
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("to", Utils.obtenerNombresSeparadosPorComa(letter.getClients()));
        context.setVariable("letter", letter);
        context.setVariable("now", (new Date()).toLocaleString());
        
        String orderHtml = templateEngine.process("letter.html", context);

        ByteArrayOutputStream target = new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        HtmlConverter.convertToPdf(orderHtml, target, converterProperties);

        byte[] bytes = target.toByteArray();
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return bytes;
	}

	public boolean delete(Long id) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		LetterConfig letter = letterConfigRepository.findById(id).orElse(null);
		List<LetterConfig> letterList = operationRepository.findlettersByOperationId(letter.getOperation().getId());
		for (LetterConfig item : letterList) {
			item.setDeleted(true);
			item.setActive(false);
		}
		letterConfigRepository.saveAll(letterList);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return Boolean.TRUE;
	}

}
