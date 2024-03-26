package com.ms.dgpinnacle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ms.dgpinnacle.entity.BrokerCompany;

@Service
public class BrokerCompanyServices {

	
	@Autowired
	private com.ms.dgpinnacle.repository.BrokerCompanyRepository brokerCompanyRepository;
	
	
	@ExceptionHandler
	public List<BrokerCompany> LoadAllBrokerCompany() throws Exception {
		List<BrokerCompany> List = new ArrayList<BrokerCompany>();
		
		//el forEach es una referencia del metodo add a la lista
		//es lo mismo que recorrer la lista entera y agregarla 
		//asi se hace con expresiones LAMBA
		brokerCompanyRepository.findAll().forEach(List::add);
		
		return List;
	}
	
	@ExceptionHandler
	public Optional<BrokerCompany> getBrokerCompany(Long id) throws Exception {
		return brokerCompanyRepository.findById(id);
	}
	
	@ExceptionHandler
	public void AddBrokerCompany(BrokerCompany BrokerCompany) throws Exception {
		brokerCompanyRepository.save(BrokerCompany);
	}
	
	@ExceptionHandler
	public void UpdateBrokerCompany(BrokerCompany BrokerCompany) throws Exception {
		brokerCompanyRepository.save(BrokerCompany);
	}
	
	@ExceptionHandler
	public void DeleteBrokerCompany(Long id) throws Exception {
		brokerCompanyRepository.deleteById(id);
	}
	
	
}
