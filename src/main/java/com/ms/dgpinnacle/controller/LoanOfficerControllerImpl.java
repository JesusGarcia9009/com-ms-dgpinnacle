package com.ms.dgpinnacle.controller;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_LOAN_DUPL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dgpinnacle.dto.LoanOfficerDto;
import com.ms.dgpinnacle.service.LoanOfficerServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${dgpinnacle.base-uri}/loan-officer")
public class LoanOfficerControllerImpl implements LoanOfficerController {
	
	/**
	 * Global variables
	 */
	private final LoanOfficerServices loanOfficerServices;
	
	@Override
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody LoanOfficerDto request) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		boolean response = false;

		try {
			response = loanOfficerServices.save(request);
		} catch (Exception e) {
			if (e.getMessage() == MSG_LOAN_DUPL) {
				return new ResponseEntity<String>(MSG_LOAN_DUPL, HttpStatus.BAD_REQUEST);
			} else {
				throw new Exception(e.getMessage());
			}
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}



	
	
}
