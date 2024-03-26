package com.ms.dgpinnacle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ms.dgpinnacle.dto.ShowLetterDto;
import com.ms.dgpinnacle.entity.Client;
import com.ms.dgpinnacle.entity.LetterConfig;
import com.ms.dgpinnacle.entity.LoanClientOperation;
import com.ms.dgpinnacle.entity.Operation;
import com.ms.dgpinnacle.old.dto.ClientDTO;
import com.ms.dgpinnacle.repository.LetterConfigRepository;

@Service
public class LetterConfigServices {

	@Autowired
	private LetterConfigRepository letterConfigRepository;
	
	@Autowired
	private ClientServices ClientServices;
	
	@Autowired
	private LoanClientOperationServices loanClientOperationServices;

	@ExceptionHandler
	public List<LetterConfig> LoadAllLetter_config() throws Exception {
		List<LetterConfig> List = new ArrayList<LetterConfig>();

//		AppUser temp = ((UserLogIn) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAppUser();
//
//		if (temp instanceof LoanOfficer) {
//
//			letterConfigRepository.findByLoan(temp.getUserId()).forEach(List::add);
//		}
//		if (temp instanceof Realtor) {
//			
//		}
		letterConfigRepository.findByRealtor(-1l).forEach(List::add);
		// el forEach es una referencia del metodo add a la lista
		// es lo mismo que recorrer la lista entera y agregarla
		// asi se hace con expresiones LAMBA
		// letterConfigRepository.findAll().forEach(List::add);

		return List;
	}

	@ExceptionHandler
	public Optional<LetterConfig> getLetter_config(Long id) throws Exception {
		return letterConfigRepository.findById(id);
	}

	@ExceptionHandler
	public void AddLetter_config(LetterConfig LetterConfig) throws Exception {
		letterConfigRepository.save(LetterConfig);
	}

	@ExceptionHandler
	public void UpdateLetter_config(LetterConfig LetterConfig) throws Exception {
		letterConfigRepository.save(LetterConfig);
	}

	@ExceptionHandler
	public void DeleteLetter_config(Long id) throws Exception {
		letterConfigRepository.deleteById(id);
	}

	@ExceptionHandler
	public List<LetterConfig> findAllLetterListByLoan(Long loan_id) throws Exception {
		List<LetterConfig> List = new ArrayList<LetterConfig>();
		letterConfigRepository.findByLoan(loan_id).forEach(List::add);
		return List;
	}

	@ExceptionHandler
	public List<LetterConfig> findActiveLetterListByLoan(Long loan_id) throws Exception {
		List<LetterConfig> List = new ArrayList<LetterConfig>();
		letterConfigRepository.findActiveByLoan(loan_id).forEach(List::add);
		return List;
	}

	@ExceptionHandler
	public List<ShowLetterDto> findActiveLetterListByLoanNew(Long loan_id) throws Exception {
		List<LetterConfig> List = new ArrayList<LetterConfig>();
		letterConfigRepository.findActiveByLoan(loan_id).forEach(List::add);

		Client client = new Client();
		List<ShowLetterDto> lovmList = new ArrayList<>();
		for (int i = 0; i < List.size(); i++) {
            
			List<String> clientList = new ArrayList<String>();
			ShowLetterDto lovm = new ShowLetterDto();
			lovm.setLetter(List.get(i));
			Operation op = List.get(i).getOperation();
			List<LoanClientOperation> lcoList = loanClientOperationServices.findLCOByOperation(op);
			for (int y = 0; y < lcoList.size(); y ++) {
				client = lcoList.get(y).getLoanClient().getClient();
				clientList.add(client.getName() + " " + client.getLastName());
			}
			lovm.setClientsName(clientList);
			lovmList.add(lovm);
		}

		return lovmList;
	}

	@ExceptionHandler
	public List<LetterConfig> findAllLetterListByRealtor(Long realtor_id) throws Exception {
		List<LetterConfig> List = new ArrayList<LetterConfig>();
		letterConfigRepository.findByRealtor(realtor_id).forEach(List::add);
		return List;
	}

	@ExceptionHandler
	public List<LetterConfig> findActiveLetterListByRealtor(Long realtor_id) throws Exception {
		List<LetterConfig> List = new ArrayList<LetterConfig>();
		letterConfigRepository.findActiveByRealtor(realtor_id).forEach(List::add);
		return List;
	}

	@ExceptionHandler
	public List<ShowLetterDto> findActiveLetterListByRealtorNew(Long realtor_id) throws Exception {
		List<LetterConfig> List = new ArrayList<LetterConfig>();
		letterConfigRepository.findActiveByRealtor(realtor_id).forEach(List::add);

		Client client = new Client();

		List<ShowLetterDto> lovmList = new ArrayList<>();
		for (int i = 0; i < List.size(); i++) {
			List<String> clientList = new ArrayList<String>();
			ShowLetterDto lovm = new ShowLetterDto();
			lovm.setLetter(List.get(i));
			List<LoanClientOperation> lcoList = new ArrayList<>(List.get(i).getOperation().getLoanClientOperations());
			for (int y = 0; y < lcoList.size(); y++) {
				client = lcoList.get(y).getLoanClient().getClient();
				clientList.add(client.getName() + " " + client.getLastName());
			}
			lovm.setClientsName(clientList);
			lovmList.add(lovm);
		}

		return lovmList;
	}

	@ExceptionHandler
	public LetterConfig getLetterByUniqueKey(String uniqueKey) throws Exception {
		LetterConfig Entity = letterConfigRepository.findByUniqueKey(uniqueKey);
		return Entity;
	}

	@ExceptionHandler
	public List<LetterConfig> findActiveLetterListByOperation(Long operation_id) throws Exception {
		List<LetterConfig> List = new ArrayList<LetterConfig>();
		letterConfigRepository.findActiveByOperation(operation_id).forEach(List::add);
		return List;
	}

	@SuppressWarnings("unused")
	@ExceptionHandler
	public double calculateMonthlyPayment(double loanAmount, int termInMonths, double interestRate) {

		// Convert interest rate into a decimal
		// eg. 6.5% = 0.065

		interestRate /= 100.0;

		// Monthly interest rate
		// is the yearly rate divided by 12

		double monthlyRate = interestRate / 12.0;

		// The length of the term in months
		// is the number of years times 12

		// int termInMonths = termInYears * 12;

		// Calculate the monthly payment
		// Typically this formula is provided so
		// we won't go into the details

		// The Math.pow() method is used calculate values raised to a power

		double monthlyPayment1 = -((loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, termInMonths)));
		// double t =Math.pow(1+monthlyRate, termInMonths);
		// double t1 =(Math.pow(monthlyRate, termInMonths));
//		      double monthlyPayment = 
//				         (loanAmount) / 
//				            ((1-Math.pow(1+monthlyRate, -termInMonths))/(monthlyRate*Math.pow(1+monthlyRate, -termInMonths)));

		double monthlyPayment = -((loanAmount) * ((monthlyRate * (Math.pow(1 + monthlyRate, termInMonths)))
				/ (1 - Math.pow(1 + monthlyRate, termInMonths))));

		return monthlyPayment;
	}

	
	///este metodo obtienen todos los clientes de del sistema, seleccionados o no
	public List<ClientDTO> getListAllClient(List<LoanClientOperation> lcoList) {
		List<ClientDTO> result = new ArrayList<ClientDTO>();
		Client client = new Client();
		for (int y = 0; y < lcoList.size(); y++) {
			ClientDTO temp = new ClientDTO();

			client = lcoList.get(y).getLoanClient().getClient();

			temp.setFullName(client.getName() + " " + client.getLastName());
			temp.setIdCliente(client.getId());
			temp.setSelected(true);

			result.add(temp);
		}

//		AppUser temp = ((UserLogIn) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAppUser();

		List<Client> listadototal = null;
//		try {
//			listadototal = ClientServices.findClientListByLoan(temp.getUserId());
//		} catch (Exception e) {
//		}

		for (Client cli : listadototal) {
			ArrayList<ClientDTO> clientDTOList = result.stream().filter(x -> x.getIdCliente() == cli.getId())
					.collect(Collectors.toCollection(() -> new ArrayList<ClientDTO>()));
			if (clientDTOList.size() == 0) {
				ClientDTO temp1 = new ClientDTO();

				temp1.setFullName(client.getName() + " " + client.getLastName());
				temp1.setIdCliente(client.getId());
				temp1.setSelected(false);

				result.add(temp1);
			}
		}

		return result;
	}

	@ExceptionHandler
	public double maxPaid(double primaryPay, double taxes, double insurance, double HOA, double MI) {
		double maxPay = primaryPay + taxes + insurance + HOA + MI;
		return maxPay;
	}

	@ExceptionHandler
	public double insurance(int price) {
		return 0.01 * price / 12;
	}

}
