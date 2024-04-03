package com.ms.dgpinnacle.business.controller;

import org.springframework.http.ResponseEntity;

import com.ms.dgpinnacle.business.dto.LoanOfficerDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * LoanOfficerController
 * 
 * This interface defines the methods for managing loans officers.
 * 
 * @author Jesus Garcia
 */
@Api(value = "LoanOfficerController")
public interface LoanOfficerController {

	/**
	 * Method to save realtor of the application
	 * 
	 * @param dto LoanOfficerDto.class 
	 * @return boolean
	 */
	@ApiOperation(value = "Save loans officer", notes = "Inserta o actualiza los loans de la aplicacion")
	public ResponseEntity<?> save(LoanOfficerDto request)throws Exception;
	
	
}
