package com.ms.dgpinnacle.business.controller;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_LETTER_NOT_EXIST;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_CLIENT_NOT_EXIST;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dgpinnacle.business.dto.security.DashboardDataDto;
import com.ms.dgpinnacle.business.service.DashboardService;
import com.ms.dgpinnacle.business.service.UsersService;
import com.ms.dgpinnacle.token.JwtUsuario;
import com.ms.dgpinnacle.token.UserPrincipal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("${dgpinnacle.base-uri}/dashboard")
public class DashboardControllerImpl implements DashboardController {
	
	/**
	 * Global variables
	 */
	private final DashboardService dashboardService;
	
	/**
     * Class constructor with @autowire annotation
     * 
     * @param UsersService @see {@link UsersService}
     */
    public DashboardControllerImpl(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

	@Override
	@GetMapping("/widget")
	public ResponseEntity<DashboardDataDto> getDashboardWidgetData() {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		DashboardDataDto response = dashboardService.getDashboardWidgetData();
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return ResponseEntity.ok(response);
	}

	@Override
	@GetMapping("/document")
	public ResponseEntity<?> getLetterDocumentByToken(@JwtUsuario UserPrincipal token, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		byte[] result = null;
		try {
			result = dashboardService.getLetterDocumentByToken(token, request, response);
		} catch (Exception e) {
			if (e.getMessage() == MSG_LETTER_NOT_EXIST) {
				return new ResponseEntity<>(MSG_LETTER_NOT_EXIST, HttpStatus.BAD_REQUEST);
			} else if (e.getMessage() == MSG_CLIENT_NOT_EXIST) {
				return new ResponseEntity<>(MSG_CLIENT_NOT_EXIST, HttpStatus.BAD_REQUEST);
			} else {
				throw new Exception(e.getMessage());
			}
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return ResponseEntity.ok(result);
	}


	
	
}
