package com.ms.dgpinnacle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.ms.dgpinnacle.dto.security.DashboardDataDto;
import com.ms.dgpinnacle.token.JwtUsuario;
import com.ms.dgpinnacle.token.UserPrincipal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * UserController
 * 
 * @author Jesus Garcia
 */
@Api(value = "UserController")
public interface DashboardController {

	/**
	 * Method to get data for dachboard
	 * 
	 * @param none
	 * @return dto @See {@link DashboardDataDto}
	 */
	@ApiOperation(value = "Get dachboard data", notes = "Retorna los datos del tablero de la aplicacion")
	public ResponseEntity<DashboardDataDto> getDashboardWidgetData();
	
	
	/**
	 * Method to get letter document by token
	 * 
	 * @param none
	 * @return byte[]
	 */
	@ApiOperation(value = "Get letter from token", notes = "Obtiene documento de la carta para el cliente logueado")
	public ResponseEntity<?> getLetterDocumentByToken(@JwtUsuario UserPrincipal token, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	
	
}
