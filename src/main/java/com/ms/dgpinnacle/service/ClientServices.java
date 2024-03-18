package com.ms.dgpinnacle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ms.dgpinnacle.entity.Client;
import com.ms.dgpinnacle.entity.LoanClient;
import com.ms.dgpinnacle.entity.LoanOfficer;
import com.ms.dgpinnacle.repository.LoanClientRepository;

@Service
public class ClientServices {

	
	@Autowired
	private com.ms.dgpinnacle.repository.ClientRepository ClientRepository;
	
	@Autowired
	private LoanClientRepository Loan_ClientRepository;
	
	@ExceptionHandler
	public List<Client> LoadAllClient() throws Exception {
		List<Client> List = new ArrayList<Client>();
		
		//el forEach es una referencia del metodo add a la lista
		//es lo mismo que recorrer la lista entera y agregarla 
		//asi se hace con expresiones LAMBDA
		ClientRepository.findAll().forEach(List::add);
		
		return List;
	}
	
	@ExceptionHandler
	public Client getClient(Long id) throws Exception {
		Optional<Client> optinalEntity =  ClientRepository.findById(id);
		return optinalEntity.get();
	}
	
	@ExceptionHandler
	public Client findClientByEmail(String email) throws Exception {
		Optional<Client> optinalEntity =  ClientRepository.findClientByEmail(email);
		return optinalEntity.get();
	}
	
	
	@ExceptionHandler
	public void AddClient(Client Client) throws Exception {
		ClientRepository.save(Client);
	}
	
	@ExceptionHandler
	public void UpdateClient(Client Client) throws Exception {
		ClientRepository.save(Client);
	}
	
	
	@ExceptionHandler
	public void DeleteClient(Long id) throws Exception {
		ClientRepository.deleteById(id);
	}
	
	@ExceptionHandler
	public List<Client> findClientListByLoan(Long loan_id) throws Exception {
		List<Client> List = new ArrayList<Client>();
		ClientRepository.findClientByLoan(loan_id).forEach(List::add);
		return List;
	}
	
	@ExceptionHandler
	public List<Client> findClientListByRealtor(Long realtor_id) throws Exception {
		List<Client> List = new ArrayList<Client>();
		ClientRepository.findClientByRealtor(realtor_id).forEach(List::add);
		return List;
	}
	
	@Transactional
	@ExceptionHandler
	public void AddClientAndLoanClient(Client client, LoanOfficer off ) throws Exception {
		ClientRepository.save(client);
		LoanClient loan_client = new LoanClient(off,  client);
		Loan_ClientRepository.save(loan_client);
	} 
	
	@Transactional
	@ExceptionHandler
	public Client AddClientAndLoanClientWithReturn(Client client, LoanOfficer off ) throws Exception {
		Client returnClient = new Client();
		if(!ClientRepository.findClientByEmail(client.getEmail()).isPresent()) {		
			returnClient = ClientRepository.save(client);
			LoanClient loan_client = new LoanClient(off,  returnClient);
			Loan_ClientRepository.save(loan_client);
		}
		else {
			// Actualizando el cliente con los posibles nuevos valores de encompass
			returnClient = ClientRepository.findClientByEmail(client.getEmail()).get();
			client.setId(returnClient.getId());
			returnClient = ClientRepository.save(client);  // Updating with encompass values
			
			// El cliente puede existir pero el la relacion LoanClient no. Si Loan_Cliente existe no hago nada pq los Ids remains the same.
			LoanClient loan_client = Loan_ClientRepository.getLoan_ClientByClientAndLoan(off.getId(), returnClient.getId());			
			if(loan_client == null) {
				loan_client = new LoanClient(off,  returnClient);
				Loan_ClientRepository.save(loan_client);
			}
		}
		return returnClient;
	} 
	

	
	
}
