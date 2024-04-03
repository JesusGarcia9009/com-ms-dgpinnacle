/**
 * 
 */
package com.ms.dgpinnacle.utils;

import static com.ms.dgpinnacle.utils.ConstantUtil.EXCEPTION_DEPENDENCY;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_MAX_PAYMENT_TO_HIGH;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.ms.dgpinnacle.business.clients.dto.Application;
import com.ms.dgpinnacle.business.clients.dto.Contact;
import com.ms.dgpinnacle.business.clients.dto.EncompassResponseDto;
import com.ms.dgpinnacle.business.clients.dto.Milestone;
import com.ms.dgpinnacle.business.dto.ClientDto;
import com.ms.dgpinnacle.business.dto.EnCompassClientDto;
import com.ms.dgpinnacle.business.dto.EnCompassLetterConfigDto;
import com.ms.dgpinnacle.business.dto.EnCompassLoanOfficerDto;
import com.ms.dgpinnacle.business.dto.EnCompassRealtorDto;
import com.ms.dgpinnacle.business.dto.LetterConfigDto;
import com.ms.dgpinnacle.business.entity.LetterConfig;
import com.ms.dgpinnacle.business.entity.LetterFixData;
import com.ms.dgpinnacle.token.UserPrincipal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Utils {

//	@Autowired
//	public PlateRepository plateRepository;

	String MES[] = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre",
			"Noviembre", "Diciembre" };

	private Utils() {
	}

	public static <T> T validateOpt(Optional<T> opt) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		if (!opt.isPresent()) {
			throw new Exception(EXCEPTION_DEPENDENCY);
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return opt.get();
	}

	public String getStringDate(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.of("UTC")).toLocalDate();
		return (localDate.getDayOfMonth() + " de " + MES[localDate.getMonthValue() - 1] + " de " + localDate.getYear());
	}

	public static String printCurlEquivalent(String url, HttpMethod method, HttpEntity<?> requestEntity) {
		StringBuilder curlCommand = new StringBuilder("curl");

		// Agregar la URL
		curlCommand.append(" --location '").append(url).append("' \\").append(System.lineSeparator());

		// Agregar el método HTTP
		curlCommand.append(" --request ").append(method.toString()).append(" \\").append(System.lineSeparator());

		// Agregar las cabeceras
		HttpHeaders headers = requestEntity.getHeaders();
		for (String key : headers.keySet()) {
			curlCommand.append(" --header '").append(key).append(": ").append(headers.getFirst(key)).append("' \\")
					.append(System.lineSeparator());
		}

		// Agregar los parámetros de datos codificados de formulario
		@SuppressWarnings("unchecked")
		MultiValueMap<String, String> requestBody = (MultiValueMap<String, String>) requestEntity.getBody();
		if (requestBody != null) {
			for (String key : requestBody.keySet()) {
				for (String value : requestBody.get(key)) {
					curlCommand.append(" --data-urlencode '").append(key).append("=").append(value).append("' \\")
							.append(System.lineSeparator());
				}
			}
		}

		return curlCommand.toString();
	}

	public static String generateString() {
		char[] elementos = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
				'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		char[] conjunto = new char[8];

		for (int i = 0; i < 8; i++) {
			int el = (int) (Math.random() * 37);
			conjunto[i] = (char) elementos[el];
		}
		String pass = new String(conjunto);
		return pass;
	}

	public static LetterConfig mapperEntitySet(LetterConfigDto request, LetterFixData fixData, UserPrincipal token) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		LetterConfig letter = new LetterConfig();
		double loanAmount = 0, MI = 0;
		if (request.getLoanType().equalsIgnoreCase("FHA")) {
			loanAmount = request.getPrice() * ((request.getLtv() / 100) + 0.0175);
			MI = ((request.getPrice() * ((request.getLtv() / 100))) * (request.getMi() / 100)) / 12;
		}

		if (request.getLoanType().equalsIgnoreCase("Conventional")) {
			loanAmount = request.getPrice() * ((request.getLtv() / 100));
		}

		request.setLoanAmount(Math.ceil(loanAmount));

		double primaryPay = calculateMonthlyPayment(request.getLoanAmount(), request.getLoanTerm(),
				request.getInterest());

		double maxPay = maxPaid(primaryPay, request.getTaxes(), request.getInsurance(), request.getHoa(), MI);
		maxPay = Math.ceil(maxPay);

		System.out.println("max pay " + maxPay);
		if (maxPay <= request.getMaxPay()) {
			// si no hay problemas seteo no mas
			letter.setId(null);
			letter.setActive(true);
			letter.setDeleted(false);
			letter.setHoa(request.getHoa());
			letter.setInsurance(request.getInsurance());
			letter.setInterest(request.getInterest());
			letter.setLoanAmount(request.getLoanAmount());
			letter.setLoanTerm(request.getLoanTerm());
			letter.setLoanType(request.getLoanType());
			letter.setLocation(request.getLocation());
			letter.setLtv(request.getLtv());
			letter.setMaxPay(request.getMaxPay());
			letter.setMi(request.getMi());
			letter.setPrice(request.getPrice());
			letter.setTaxes(request.getTaxes());
			letter.setUniqueKey(Utils.generateString());
			letter.setLetterFixdata(fixData);
			letter.setUpdateDate(new Date());
			letter.setUpdateUser(token.getEmail());

		} else {
			throw new Exception(MSG_MAX_PAYMENT_TO_HIGH);
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return letter;
	}

	public static LetterConfig mapperEntitySet(EnCompassLetterConfigDto request, LetterFixData fixData)
			throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		LetterConfig letter = new LetterConfig();
		double loanAmount = 0, MI = 0;
		if (request.getLoanType().equalsIgnoreCase("FHA")) {
			loanAmount = request.getPrice() * ((request.getLtv() / 100) + 0.0175);
			MI = ((request.getPrice() * ((request.getLtv() / 100))) * (request.getMi() / 100)) / 12;
		}

		if (request.getLoanType().equalsIgnoreCase("Conventional")) {
			loanAmount = request.getPrice() * ((request.getLtv() / 100));
		}

		request.setLoanAmount(Math.ceil(loanAmount));

		double primaryPay = calculateMonthlyPayment(request.getLoanAmount(), request.getLoanTerm(),
				request.getInterest());

		double maxPay = maxPaid(primaryPay, request.getTaxes(), request.getInsurance(), request.getHoa(), MI);
		maxPay = Math.ceil(maxPay);

		System.out.println("max pay " + maxPay);
		if (maxPay <= request.getMaxPay()) {
			// si no hay problemas seteo no mas
			letter.setId(null);
			letter.setActive(true);
			letter.setDeleted(false);
			letter.setHoa(request.getHoa());
			letter.setInsurance(request.getInsurance());
			letter.setInterest(request.getInterest());
			letter.setLoanAmount(request.getLoanAmount());
			letter.setLoanTerm(request.getLoanTerm());
			letter.setLoanType(request.getLoanType());
			letter.setLocation(request.getLocation());
			letter.setLtv(request.getLtv());
			letter.setMaxPay(request.getMaxPay());
			letter.setMi(request.getMi());
			letter.setPrice(request.getPrice());
			letter.setTaxes(request.getTaxes());
			letter.setUniqueKey(Utils.generateString());
			letter.setLetterFixdata(fixData);

		} else {
			throw new Exception(MSG_MAX_PAYMENT_TO_HIGH);
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return letter;
	}

	public static double calculateMonthlyPayment(double loanAmount, int termInMonths, double interestRate) {
		// Convert interest rate into a decimal
		interestRate /= 100.0;

		// Monthly interest rate
		double monthlyRate = interestRate / 12.0;

		// Calculate the monthly payment using the formula
		double monthlyPayment = -((loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths)));

		return monthlyPayment;
	}

	public static double maxPaid(double primaryPay, double taxes, double insurance, double HOA, double MI) {
		double maxPay = primaryPay + taxes + insurance + HOA + MI;
		return maxPay;
	}

	public static ArrayList<EnCompassClientDto> getClientsEnCompassDto(ArrayList<Application> applications) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		ArrayList<EnCompassClientDto> result = new ArrayList<>();
		applications.forEach(x -> {
			EnCompassClientDto borrower = new EnCompassClientDto();
			borrower.setName(x.getBorrower().getFirstName());
			borrower.setLastName(x.getBorrower().getLastName());
			borrower.setEmail(x.getBorrower().getEmailAddressText());
			borrower.setCellphone(x.getBorrower().getMobilePhone());
			borrower.setType("borrower");
			result.add(borrower);

			EnCompassClientDto coborrower = new EnCompassClientDto();
			coborrower.setName(x.getCoborrower().getFirstName());
			coborrower.setLastName(x.getCoborrower().getLastName());
			coborrower.setEmail(x.getCoborrower().getEmailAddressText());
			coborrower.setCellphone(x.getCoborrower().getMobilePhone());
			coborrower.setType("coborrower");
			result.add(coborrower);
		});
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

	public static ArrayList<EnCompassRealtorDto> getRealtorsEnCompassDto(ArrayList<Contact> applications) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		ArrayList<EnCompassRealtorDto> result = new ArrayList<>();
		applications.forEach(x -> {
			if (x.getContactType().contains("BUYERS_AGENT")) {
				EnCompassRealtorDto realtor = new EnCompassRealtorDto();
				realtor.setFullName(x.getContactName());
				realtor.setEmail(x.getEmail());
				realtor.setCellphone(x.getCell());
				realtor.setLicenseNumber(x.getPersonalLicenseNumber());
				result.add(realtor);
			}
		});
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

	public static EnCompassLoanOfficerDto getLoanOfficerEnCompassDto(EncompassResponseDto response) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		EnCompassLoanOfficerDto loan = new EnCompassLoanOfficerDto();

		List<Milestone> milestones = response.getMilestones().stream()
				.filter(x -> Objects.nonNull(x.getLoanAssociate().getRole()) && 
						Objects.nonNull(x.getLoanAssociate().getRole().getEntityName()) && 
						x.getLoanAssociate().getRole().getEntityName().equalsIgnoreCase("Loan Officer"))
				.collect(Collectors.toList());
		if(milestones.size() > 0 ) {
			loan.setFullName(milestones.get(0).getLoanAssociate().getUser().getEntityName());
			loan.setEmail(milestones.get(0).getLoanAssociate().getEmail());
			loan.setCellphone(milestones.get(0).getLoanAssociate().getPhone());
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return loan;
	}
	
	public static String obtenerNombresSeparadosPorComa(List<ClientDto> clients) {
        StringBuilder sb = new StringBuilder();
        for (ClientDto client : clients) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(client.getName());
            sb.append(" ");
            sb.append(client.getLastName());
        }
        return sb.toString();
    }

}
