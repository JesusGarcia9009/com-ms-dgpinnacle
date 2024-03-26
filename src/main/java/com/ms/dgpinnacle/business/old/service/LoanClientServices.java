package com.ms.dgpinnacle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ms.dgpinnacle.entity.Client;
import com.ms.dgpinnacle.entity.LoanClient;
import com.ms.dgpinnacle.entity.LoanOfficer;
import com.ms.dgpinnacle.repository.LoanClientRepository;

@Service
public class LoanClientServices {

	
	@Autowired
	private LoanClientRepository loanClientRepository;
	
	@ExceptionHandler
	public List<LoanClient> LoadAllLoan_Client() throws Exception {
		List<LoanClient> List = new ArrayList<LoanClient>();
		
		//el forEach es una referencia del metodo add a la lista
		//es lo mismo que recorrer la lista entera y agregarla 
		//asi se hace con expresiones LAMBA
		loanClientRepository.findAll().forEach(List::add);
		
		return List;
	}
	
	@ExceptionHandler
	public Optional<LoanClient> getLoan_Client(Long id) throws Exception {
		return loanClientRepository.findById(id);
	}
	
	@ExceptionHandler
	public void AddLoan_Client(Client client, LoanOfficer off ) throws Exception {
		LoanClient loan_client = new LoanClient(off,  client);
		loanClientRepository.save(loan_client);
	}
	
	@ExceptionHandler
	public void UpdateLoan_Client(LoanClient LoanClient) throws Exception {
		loanClientRepository.save(LoanClient);
	}
	
	@ExceptionHandler
	public void DeleteLoan_Client(Long id) throws Exception {
		loanClientRepository.deleteById(id);
	}
	
	@ExceptionHandler
	public void DeleteLoan_ClientByIdClient(Long client_id) throws Exception {
		loanClientRepository.DeleteByClient(client_id);
	}
	
	@ExceptionHandler
	public void DeleteLoan_ClientByLoanAndClient(Long loan_id, Long client_id) throws Exception {
		loanClientRepository.DeleteByLoanAndClient(loan_id, client_id);;
	}
	
	@ExceptionHandler
	public LoanClient getLoan_ClientByClientAndLoan(Long idLoan, Long idClient) throws Exception {
		return loanClientRepository.getLoan_ClientByClientAndLoan(idLoan, idClient);
	}
	
	@ExceptionHandler
	public List<LoanClient> getLoan_ClientByClienList(Long loan_id, List<Long> clientIdList) throws Exception {
		return loanClientRepository.getLoan_ClientByClientList(loan_id, clientIdList);
	}
	
	
	
	
}
