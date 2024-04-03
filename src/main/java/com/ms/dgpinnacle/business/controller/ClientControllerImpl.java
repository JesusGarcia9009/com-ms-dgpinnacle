package com.ms.dgpinnacle.business.controller;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_CLIENT_DUPL;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dgpinnacle.business.dto.ClientDto;
import com.ms.dgpinnacle.business.service.ClientServices;
import com.ms.dgpinnacle.token.JwtUsuario;
import com.ms.dgpinnacle.token.UserPrincipal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${dgpinnacle.base-uri}/client")
public class ClientControllerImpl implements ClientController {
	
	/**
	 * Global variables
	 */
	private final ClientServices clientServices;

	@Override
	@GetMapping("/list")
	public ResponseEntity<List<ClientDto>> findAllClientList(@JwtUsuario UserPrincipal token) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<ClientDto> response = clientServices.findAllClientList(token);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, response == null || response.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}

	@Override
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody ClientDto request, @JwtUsuario UserPrincipal token) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		boolean response = false;

		try {
			response = clientServices.save(request, token);
		} catch (Exception e) {
			if (e.getMessage() == MSG_CLIENT_DUPL) {
				return new ResponseEntity<String>(MSG_CLIENT_DUPL, HttpStatus.BAD_REQUEST);
			} else {
				throw new Exception(e.getMessage());
			}
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	@PostMapping("/delete")
	public ResponseEntity<?> delete(ClientDto request) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		boolean response = false;

		try {
			response = clientServices.delete(request);
		} catch (Exception e) {
				throw new Exception(e.getMessage());
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
