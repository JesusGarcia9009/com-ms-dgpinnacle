package com.ms.dgpinnacle.security.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ms.dgpinnacle.security.repository.IProfileRepository;
import com.ms.dgpinnacle.security.token.ProfileDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ProfileService clase que implementa la interfaz de servicio
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProfileService {
	
	private final IProfileRepository profileRepository;
	
	public List<ProfileDto> findAllProfiles() {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<ProfileDto> result = profileRepository.findProfileList();
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

	
}
