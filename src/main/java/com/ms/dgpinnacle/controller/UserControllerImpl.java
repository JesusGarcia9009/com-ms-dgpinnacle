package com.ms.dgpinnacle.controller;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_MAIL_DUPL;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dgpinnacle.dto.LoanOfficerDto;
import com.ms.dgpinnacle.dto.RealtorDto;
import com.ms.dgpinnacle.dto.security.UserDto;
import com.ms.dgpinnacle.service.LoanOfficerServices;
import com.ms.dgpinnacle.service.ProfileService;
import com.ms.dgpinnacle.service.RealtorServices;
import com.ms.dgpinnacle.service.UsersService;
import com.ms.dgpinnacle.token.ProfileDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${dgpinnacle.base-uri}/user")
public class UserControllerImpl implements UserController {
	
	/**
	 * Global variables
	 */
	private final UsersService usersService;
	private final ProfileService profileService;
	private final RealtorServices realtorServices;
	private final LoanOfficerServices loanOfficerServices;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	@GetMapping("/list")
	public ResponseEntity<List<UserDto>> getUserList() throws IOException {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<UserDto> response = usersService.findAllUsers();
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, response == null || response.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/find-realtor/{id}")
	public ResponseEntity<RealtorDto> getRealtorById(@PathVariable Long id) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		RealtorDto response = realtorServices.getRealtorById(id);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@Override
	@GetMapping("/find-loan/{id}")
	public ResponseEntity<LoanOfficerDto> getLoanById(@PathVariable Long id) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		LoanOfficerDto response = loanOfficerServices.getLoanById(id);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


	@Override
	@GetMapping("/list-profile")
	public ResponseEntity<List<ProfileDto>> getProfileList() throws IOException {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<ProfileDto> response = profileService.findAllProfiles();
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, response == null || response.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}


	@Override
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody UserDto request) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		boolean response = false;

		try {
			request.setPassword(passwordEncoder.encode(request.getPassword()));
			response = usersService.save(request);
		} catch (Exception e) {
			if (e.getMessage() == MSG_MAIL_DUPL) {
				return new ResponseEntity<String>(MSG_MAIL_DUPL, HttpStatus.BAD_REQUEST);
			} else {
				throw new Exception(e.getMessage());
			}
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@Override
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody UserDto request) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		boolean response = false;

		try {
			response = usersService.delete(request);
		} catch (Exception e) {
				throw new Exception(e.getMessage());
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	
}
