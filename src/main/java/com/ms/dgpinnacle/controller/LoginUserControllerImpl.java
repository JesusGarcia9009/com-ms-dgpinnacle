package com.ms.dgpinnacle.controller;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_CLIENT_NOT_EXIST;

import java.io.IOException;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dgpinnacle.JwtTokenProvider;
import com.ms.dgpinnacle.dto.security.RegisterRequestDTO;
import com.ms.dgpinnacle.dto.security.UserAuthRequestDTO;
import com.ms.dgpinnacle.dto.security.UserAuthResponseDTO;
import com.ms.dgpinnacle.dto.security.UserDto;
import com.ms.dgpinnacle.entity.Client;
import com.ms.dgpinnacle.repository.ClientRepository;
import com.ms.dgpinnacle.service.UsersService;
import com.ms.dgpinnacle.token.UserPrincipal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${dgpinnacle.base-uri}/login")
public class LoginUserControllerImpl implements LoginUserController {

	public final AuthenticationManager authenticationManager;
	private final UsersService usersService;
	private final PasswordEncoder passwordEncoder;
	public final JwtTokenProvider tokenProvider;
	private final ClientRepository clientRepository;

	@PostMapping("/auth")
	public ResponseEntity<UserAuthResponseDTO> autenticacionUsuario(@Valid @RequestBody UserAuthRequestDTO dto) throws IOException {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		log.info("PASSWORD");
		log.info(passwordEncoder.encode(dto.getPassword()));

		log.info("[ SIGNIN :: " + dto.getUsername() + ".] ");
		
		Authentication sigin = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(sigin);
		
		UserAuthResponseDTO response = new UserAuthResponseDTO();
		UserPrincipal userPrincipal = (UserPrincipal) sigin.getPrincipal();
		response.setToken(tokenProvider.generateToken(sigin));

		response.setUsername(userPrincipal.getUsername());
		response.setFullName(userPrincipal.getFullName());
		response.setId(userPrincipal.getIdUser());
		response.setProfile(userPrincipal.getProfile().getCode());

		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterRequestDTO request) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		Client client = clientRepository.findByEmailOrCellphone(request.getEmail(), request.getCellphone());
		if(Objects.isNull(client))
			return new ResponseEntity<String>(MSG_CLIENT_NOT_EXIST, HttpStatus.BAD_REQUEST);
		
		String username = request.getEmail().substring(0, request.getEmail().indexOf("@"));
		UserDto dto = new UserDto(null, request.getName(), request.getLastName(), request.getEmail(), request.getCellphone(), username, passwordEncoder.encode(request.getPassword()), request.getMailingAdd(), null, "VIEWER", "VIEWER");
		boolean response = usersService.save(dto);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
