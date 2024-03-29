package com.ms.dgpinnacle.business.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ms.dgpinnacle.business.dto.BrokerCompanyDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * BrokerCompanyController
 * 
 * This interface defines the methods for managing realtors.
 * 
 * @author Jesus Garcia
 */
@Api(value = "BrokerCompanyController")
public interface BrokerCompanyController {

    /**
     * Retrieves a List of Broker Company.
     * 
     * @param none
     * @return A ResponseEntity containing a list of BrokerCompanyDto objects.
     */
    @ApiOperation(value = "Get Broker Company List", notes = "Retorna los datos referente a los Broker Company")
    public ResponseEntity<List<BrokerCompanyDto>> findAllBrokerCompanyList();
    
}
