package com.ms.dgpinnacle.controller;

import org.springframework.http.ResponseEntity;

import com.ms.dgpinnacle.dto.DashboardDataDto;

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
	
	
	
	
}
