package com.ms.dgpinnacle.business.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.ms.dgpinnacle.business.dto.EnCompassLetterConfigDto;
import com.ms.dgpinnacle.business.dto.LetterConfigDto;
import com.ms.dgpinnacle.security.token.JwtUsuario;
import com.ms.dgpinnacle.security.token.UserPrincipal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * LetterConfigController
 * 
 * This interface defines the methods for managing letter configurations.
 * 
 * @author Jesus Garcia
 */
@Api(value = "LetterConfigController")
public interface LetterConfigController {

    /**
     * Retrieves a list of letters based on the user's role.
     * 
     * @param token The user's JWT token.
     * @return A ResponseEntity containing a list of LetterConfigDto objects.
     */
    @ApiOperation(value = "Get letter List", notes = "Retorna los datos referente a las cartas creadas dependiendo del rol")
    public ResponseEntity<List<LetterConfigDto>> findAllLetterList(@JwtUsuario UserPrincipal token);
    
    /**
     * Retrieves a detail of letter encompass
     * 
     * @param loan id @See {@link UUID}
     * @return A ResponseEntity containing a EnCompassLetterConfigDto objects from ecompass.
     */
    @ApiOperation(value = "Get letter EnCompass", notes = "Retorna los datos referente a la carta de EnCompass")
    public ResponseEntity<EnCompassLetterConfigDto> findDetailsEnCompass(String loanId);
    
    /**
	 * Method to save letter of the application
	 * 
	 * @param dto LetterConfigDto.class 
	 * @return
	 */
	@ApiOperation(value = "Save product", notes = "Inserta o actualiza las cartas de la aplicacion")
	public ResponseEntity<?> save(LetterConfigDto request, UserPrincipal token)throws Exception;
	
	/**
	 * Method to save letter from EnCompass services
	 * 
	 * @param dto EnCompassLetterConfigDto.class 
	 * @return boolean
	 */
	@ApiOperation(value = "Save product", notes = "Inserta carta cargada del servicio EnCompass")
	public ResponseEntity<?> saveEnCompass(EnCompassLetterConfigDto request, UserPrincipal token)throws Exception;
	
	/**
	 * Method to get letter document by id
	 * 
	 * @param long id
	 * @return byte[]
	 */
	@ApiOperation(value = "Get letter company", notes = "Obtiene documento de la carta")
	public ResponseEntity<byte[]> getLetterDocument(@PathVariable Long id,@JwtUsuario UserPrincipal token, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
