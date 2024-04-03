package com.ms.dgpinnacle.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.ms.dgpinnacle.dto.LoanOfficerDto;
import com.ms.dgpinnacle.dto.RealtorDto;
import com.ms.dgpinnacle.dto.security.UserDto;
import com.ms.dgpinnacle.token.ProfileDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * UserController
 * 
 * @author Jesus Garcia
 */
@Api(value = "UserController")
public interface UserController {

	/**
	 * Method to list the users of the application
	 * 
	 * @param dto UserAuthRequestDTO.class 
	 * @return
	 */
	@ApiOperation(value = "Get User List", notes = "Retorna los datos referente a los usuarios de la aplicacion")
	public ResponseEntity<List<UserDto>> getUserList()throws Exception;
	
	/**
	 * Method to get realtor of the application
	 * 
	 * @param none
	 * @return response @see {@link RealtorDto.class }
	 */
	@ApiOperation(value = "Get realtor data", notes = "Retorna los datos referente a un realtor")
	public ResponseEntity<RealtorDto> getRealtorById(Long id)throws Exception;
	
	/**
	 * Method to get loan of the application
	 * 
	 * @param id
	 * @return response @see {@link LoanOfficerDto.class }
	 */
	@ApiOperation(value = "Get loan  data", notes = "Retorna los datos referente a un loan Officer")
	public ResponseEntity<LoanOfficerDto> getLoanById(Long id)throws Exception;
	
	/**
	 * Method to list the profiles of the application
	 * 
	 * @param dto {@link ProfileDto} 
	 * @return
	 */
	@ApiOperation(value = "Get profile list", notes = "Retorna los datos referente a los perfiles de la aplicacion")
	public ResponseEntity<List<ProfileDto>> getProfileList()throws Exception;
	
	/**
	 * Method to save user of the application
	 * 
	 * @param dto UserAuthRequestDTO.class 
	 * @return
	 */
	@ApiOperation(value = "Save user", notes = "Inserta o actualiza los usuarios de la aplicacion")
	public ResponseEntity<?> save(UserDto request)throws Exception;
	
	
	/**
	 * Method to delete user of the application
	 * 
	 * @param dto UserAuthRequestDTO.class 
	 * @return
	 */
	@ApiOperation(value = "Delete user", notes = "Elimina los usuarios de la aplicacion")
	public ResponseEntity<?> delete(@RequestBody UserDto request) throws Exception;
	
	
	
}
