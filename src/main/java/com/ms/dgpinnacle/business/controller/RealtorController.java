package com.ms.dgpinnacle.business.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ms.dgpinnacle.business.dto.RealtorDto;
import com.ms.dgpinnacle.business.dto.RealtorOperationDto;
import com.ms.dgpinnacle.security.token.JwtUsuario;
import com.ms.dgpinnacle.security.token.UserPrincipal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * RealtorController
 * 
 * This interface defines the methods for managing realtors.
 * 
 * @author Jesus Garcia
 */
@Api(value = "RealtorController")
public interface RealtorController {

    /**
     * Retrieves a list of realtors.
     * 
     * @param token The user's JWT token.
     * @return A ResponseEntity containing a list of RealtorDto objects.
     */
    @ApiOperation(value = "Get realtor List", notes = "Retorna los datos referente a los realtors")
    public ResponseEntity<List<RealtorOperationDto>> findAllRealtorList(@JwtUsuario UserPrincipal token);
    
    /**
	 * Method to list the realtor of the application
	 * 
	 * @param dto RealtorDto.class 
	 * @return
	 */
	@ApiOperation(value = "Get realtor List", notes = "Retorna los datos referente a los realtors de la aplicacion")
	public ResponseEntity<List<RealtorDto>> getRealtorList()throws Exception;
	
	/**
	 * Method to save realtor of the application
	 * 
	 * @param dto RealtorDto.class 
	 * @return
	 */
	@ApiOperation(value = "Save realtor", notes = "Inserta o actualiza los realtors de la aplicacion")
	public ResponseEntity<?> save(RealtorDto request)throws Exception;
	
	
	/**
	 * Method to delete realtors of the application
	 * 
	 * @param dto RealtorDto.class 
	 * @return boolean
	 */
	@ApiOperation(value = "Delete realtor", notes = "Elimina los realtors de la aplicacion")
	public ResponseEntity<?> delete(RealtorDto request) throws Exception;

}
