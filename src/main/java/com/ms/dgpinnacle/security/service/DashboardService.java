package com.ms.dgpinnacle.security.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;

import org.springframework.stereotype.Service;

import com.ms.dgpinnacle.security.dto.DashboardDataDto;
import com.ms.dgpinnacle.security.repository.IDashboardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * DashboardServiceImpl clase que implementa la interfaz de servicio
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DashboardService {

	private final IDashboardRepository dashboardRepository;
	
	
	public DashboardDataDto getDashboardWidgetData() {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		DashboardDataDto result = new DashboardDataDto();
		dashboardRepository.findAll();
		
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

}
