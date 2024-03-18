package com.ms.dgpinnacle.security.service;

import java.util.List;

import com.ms.dgpinnacle.token.ProfileDto;


/**
 * ProfileService servicio de perfiles
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
public interface ProfileService {

	
	/**
	 * get user list
	 * 
	 * @param string username
	 * @return list @see UserResponseDTO
	 */
	public List<ProfileDto> findAllProfiles();
	
}
