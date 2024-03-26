package com.ms.dgpinnacle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ms.dgpinnacle.entity.LetterFixData;
import com.ms.dgpinnacle.repository.LetterFixDataRepository;

@Service
public class LetterFixDataServices {

	
	@Autowired
	private LetterFixDataRepository letterFixDataRepository;
	
	
	@ExceptionHandler
	public List<LetterFixData> LoadAllLetter_fixData() throws Exception {
		List<LetterFixData> List = new ArrayList<LetterFixData>();
		
		//el forEach es una referencia del metodo add a la lista
		//es lo mismo que recorrer la lista entera y agregarla 
		//asi se hace con expresiones LAMBA
		letterFixDataRepository.findAll().forEach(List::add);
		
		return List;
	}
	
	@ExceptionHandler
	public Optional<LetterFixData> getLetter_FixData(Long id) throws Exception {
		return letterFixDataRepository.findById(id);
	}
	
	@ExceptionHandler
	public void AddLetter_FixData(LetterFixData fixData) throws Exception {
		letterFixDataRepository.save(fixData);
	}
	
	@ExceptionHandler
	public void UpdateLetter_FixData(LetterFixData fixData) throws Exception {
		letterFixDataRepository.save(fixData);
	}
	
	@ExceptionHandler
	public void DeleteLetter_FixData(Long id) throws Exception {
		letterFixDataRepository.deleteById(id);
	}	

	
}
