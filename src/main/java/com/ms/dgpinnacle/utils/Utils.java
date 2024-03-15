/**
 * 
 */
package com.ms.dgpinnacle.utils;

import static com.ms.dgpinnacle.utils.ConstantUtil.EXCEPTION_DEPENDENCY;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Utils {
	
//	@Autowired
//	public PlateRepository plateRepository;
	
	String MES[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	

	private Utils() {
	}

	public <T> T validateOpt(Optional<T> opt) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		if (!opt.isPresent()) {
			throw new Exception(EXCEPTION_DEPENDENCY);
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return opt.get();
	}
	
	public String getStringDate(Date date) {
		LocalDate localDate = date.toInstant().atZone(ZoneId.of("UTC")).toLocalDate();
		return (localDate.getDayOfMonth() + " de "+ MES[localDate.getMonthValue()-1] +" de " + localDate.getYear());
	}
	
	
	
	
	
	
	
	

	

}
