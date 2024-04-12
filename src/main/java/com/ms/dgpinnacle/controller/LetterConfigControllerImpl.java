package com.ms.dgpinnacle.controller;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_LOAN_NOT_EXIST_DUPL;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_MAX_PAYMENT_TO_HIGH;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_OPERATION_DUPL;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_ERROR_TOKEN;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_ERROR_LOAN;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dgpinnacle.dto.EnCompassLetterConfigDto;
import com.ms.dgpinnacle.dto.LetterConfigDto;
import com.ms.dgpinnacle.service.LetterConfigServices;
import com.ms.dgpinnacle.token.JwtUsuario;
import com.ms.dgpinnacle.token.UserPrincipal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${dgpinnacle.base-uri}/letter")
public class LetterConfigControllerImpl implements LetterConfigController {

	/**
	 * Global variables
	 */
	private final LetterConfigServices letterConfigServices;

	@Override
	@GetMapping("/list")
	public ResponseEntity<List<LetterConfigDto>> findAllLetterList(@JwtUsuario UserPrincipal token) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<LetterConfigDto> response = letterConfigServices.findAllLetterList(token);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response,
				response == null || response.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
	}

	
	@Override
	@GetMapping("/details/{loanId}")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<EnCompassLetterConfigDto> findDetailsEnCompass(@PathVariable String loanId) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		EnCompassLetterConfigDto response = null;
		try {
			response = letterConfigServices.findDetailsEnCompass(loanId);
		} catch (Exception e) {
			if (e.getMessage().startsWith("ERROR_TOKEN :: Response -> ")) {
				return new ResponseEntity(MSG_ERROR_TOKEN, HttpStatus.BAD_REQUEST);
			} else if (e.getMessage().startsWith("ERROR_LOAN :: Response -> ")) {
				return new ResponseEntity(MSG_ERROR_LOAN, HttpStatus.BAD_REQUEST);
			} else {
				throw new Exception(e.getMessage());
			}
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody LetterConfigDto request, @JwtUsuario UserPrincipal token)
			throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		boolean response = false;

		try {
			response = letterConfigServices.save(token, request);
		} catch (Exception e) {
			if (e.getMessage() == MSG_OPERATION_DUPL) {
				return new ResponseEntity<String>(MSG_OPERATION_DUPL, HttpStatus.BAD_REQUEST);
			} else if (e.getMessage() == MSG_MAX_PAYMENT_TO_HIGH) {
				return new ResponseEntity<String>(MSG_MAX_PAYMENT_TO_HIGH, HttpStatus.BAD_REQUEST);
			} else {
				throw new Exception(e.getMessage());
			}
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	@PostMapping("/save-encompass")
	public ResponseEntity<?> saveEnCompass(@RequestBody EnCompassLetterConfigDto request,
			@JwtUsuario UserPrincipal token) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		boolean response = false;

		try {
			response = letterConfigServices.saveEnCompass(token, request);
		} catch (Exception e) {
			if (e.getMessage() == MSG_LOAN_NOT_EXIST_DUPL) {
				return new ResponseEntity<String>(MSG_LOAN_NOT_EXIST_DUPL, HttpStatus.BAD_REQUEST);
			} else if (e.getMessage() == MSG_MAX_PAYMENT_TO_HIGH) {
				return new ResponseEntity<String>(MSG_MAX_PAYMENT_TO_HIGH, HttpStatus.BAD_REQUEST);
			} else {
				throw new Exception(e.getMessage());
			}
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@Override
	@GetMapping(path = "/export/{id}")
	public ResponseEntity<byte[]> getLetterDocument(@PathVariable Long id,@JwtUsuario UserPrincipal token, HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		byte[] result = letterConfigServices.getLetterDocument(id, token, request, response);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return ResponseEntity.ok(result);
	}
	
	@Override
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		boolean response = false;

		try {
			response = letterConfigServices.delete(id);
		} catch (Exception e) {
				throw new Exception(e.getMessage());
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
