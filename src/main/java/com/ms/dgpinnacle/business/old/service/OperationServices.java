package com.ms.dgpinnacle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ms.dgpinnacle.entity.Operation;
import com.ms.dgpinnacle.repository.OperationRepository;

@Service
public class OperationServices {

	
	@Autowired
	private OperationRepository operationRepository;
	
	
	@ExceptionHandler
	public List<Operation> LoadAllOperation() throws Exception {
		List<Operation> List = new ArrayList<Operation>();
		
		//el forEach es una referencia del metodo add a la lista
		//es lo mismo que recorrer la lista entera y agregarla 
		//asi se hace con expresiones LAMBA
		operationRepository.findAll().forEach(List::add);
		
		return List;
	}
	
	@ExceptionHandler
	public Optional<Operation> getOperation(Long id) throws Exception {
		return operationRepository.findById(id);
	}
	
	@ExceptionHandler
	public void AddOperation(Operation Operation) throws Exception {
		operationRepository.save(Operation);
	}
	
	@ExceptionHandler
	public void UpdateOperation(Operation Operation) throws Exception {
		operationRepository.save(Operation);
	}
	
	@ExceptionHandler
	public void DeleteOperation(Long id) throws Exception {
		operationRepository.deleteById(id);
	}	

	
}
