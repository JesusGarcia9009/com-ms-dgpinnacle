package com.ms.dgpinnacle.business.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ms.dgpinnacle.business.dto.RealtorDto;
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
    public ResponseEntity<List<RealtorDto>> findAllRealtorList(@JwtUsuario UserPrincipal token);

}
