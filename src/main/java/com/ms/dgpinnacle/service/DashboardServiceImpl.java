package com.ms.dgpinnacle.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dgpinnacle.dto.DashboardDataDto;
import com.ms.dgpinnacle.repository.IDashboardRepository;

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
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private IDashboardRepository dashboardRepository;
	
	
	@Override
	public DashboardDataDto getDashboardWidgetData() {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		DashboardDataDto result = new DashboardDataDto();
		
		
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

}
