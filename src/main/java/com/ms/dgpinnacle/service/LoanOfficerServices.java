package com.ms.dgpinnacle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ms.dgpinnacle.entity.LoanOfficer;
import com.ms.dgpinnacle.repository.LoanOfficerRepository;

@Service
public class LoanOfficerServices {

	
	@Autowired
	private LoanOfficerRepository loanOfficerRepository;
	
	@ExceptionHandler
	public List<LoanOfficer> LoadAllLoan_officer() throws Exception {
		List<LoanOfficer> List = new ArrayList<LoanOfficer>();
		
		//el forEach es una referencia del metodo add a la lista
		//es lo mismo que recorrer la lista entera y agregarla 
		//asi se hace con expresiones LAMBA
		loanOfficerRepository.findAll().forEach(List::add);
		
		return List;
	}
	
	@ExceptionHandler
	public List<LoanOfficer> LoadAllLoan_officerByCompany(Long company_id) throws Exception {
		List<LoanOfficer> List = new ArrayList<LoanOfficer>();
		loanOfficerRepository.findByCompanyId(company_id).forEach(List::add);
		
		return List;
	}
	
	@ExceptionHandler
	public LoanOfficer getLoan_officer(Long id) throws Exception {
		Optional<LoanOfficer> optinalEntity =  loanOfficerRepository.findById(id);
		return optinalEntity.get();
	}
	
	@ExceptionHandler
	public void AddLoan_officer(LoanOfficer LoanOfficer) throws Exception {
		loanOfficerRepository.save(LoanOfficer);
	}
	
	@ExceptionHandler
	public void UpdateLoan_officer(LoanOfficer LoanOfficer) throws Exception {
		loanOfficerRepository.save(LoanOfficer);
	}
	
	@ExceptionHandler
	public void DeleteLoan_officer(Long id) throws Exception {
		loanOfficerRepository.deleteById(id);
	}
	
	
}
