package com.ms.dgpinnacle.business.controller;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dgpinnacle.business.dto.RealtorDto;
import com.ms.dgpinnacle.business.service.RealtorNewServices;
import com.ms.dgpinnacle.security.token.UserPrincipal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${dgpinnacle.base-uri}/realtor")
public class RealtorControllerImpl implements RealtorController {
	
	/**
	 * Global variables
	 */
	private final RealtorNewServices realtorServices;
	
	@Override
	@GetMapping("/list")
	public ResponseEntity<List<RealtorDto>> findAllRealtorList(UserPrincipal token) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<RealtorDto> response = realtorServices.findAllRealtorList(token);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, response == null || response.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}
	
}
