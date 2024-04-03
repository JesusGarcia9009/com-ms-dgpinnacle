package com.ms.dgpinnacle.business.controller;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_REALTOR_DUPL;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dgpinnacle.business.dto.RealtorDto;
import com.ms.dgpinnacle.business.dto.RealtorOperationDto;
import com.ms.dgpinnacle.business.service.RealtorServices;
import com.ms.dgpinnacle.token.UserPrincipal;

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
	private final RealtorServices realtorServices;
	
	@Override
	@GetMapping("/list-operation")
	public ResponseEntity<List<RealtorOperationDto>> findAllRealtorList(UserPrincipal token) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<RealtorOperationDto> response = realtorServices.findAllRealtorList(token);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, response == null || response.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}

	@Override
	@GetMapping("/list")
	public ResponseEntity<List<RealtorDto>> getRealtorList() throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<RealtorDto> response = realtorServices.getRealtorList();
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, response == null || response.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}

	@Override
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody RealtorDto request) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		boolean response = false;

		try {
			response = realtorServices.save(request);
		} catch (Exception e) {
			if (e.getMessage() == MSG_REALTOR_DUPL) {
				return new ResponseEntity<String>(MSG_REALTOR_DUPL, HttpStatus.BAD_REQUEST);
			} else {
				throw new Exception(e.getMessage());
			}
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody RealtorDto request) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		boolean response = false;

		try {
			response = realtorServices.delete(request);
		} catch (Exception e) {
				throw new Exception(e.getMessage());
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
