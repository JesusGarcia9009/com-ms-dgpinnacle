package com.ms.dgpinnacle.security.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.ERROR_USER_NOT_FOUND;
import static com.ms.dgpinnacle.utils.ConstantUtil.EXCEPTION;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ms.dgpinnacle.business.entity.Users;
import com.ms.dgpinnacle.security.repository.IProfileRepository;
import com.ms.dgpinnacle.security.token.UserPrincipal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * CustomUserDetailsService servicio de usuario para Sprint Security
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UsersService usersService;
	private final IProfileRepository profileRepository;

	@Override
	public UserPrincipal loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		Users model = null;
		UserPrincipal result = null;
		try {
			if (usersService.countUsersByUsername(usernameOrEmail) > 0) {
				model = usersService.getUserByUsername(usernameOrEmail);
				result = createUserPrincipal(model, usernameOrEmail, model.getPass());
			}else {
				throw new UsernameNotFoundException(ERROR_USER_NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(String.format(EXCEPTION, Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage()));
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

	/**
	 * Genera el Usuario a guardar en el token con toda su informacion y permisos
	 * asociados
	 * 
	 * @param model
	 * @return
	 */
	private UserPrincipal createUserPrincipal(Users model, String user, String password) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		UserPrincipal userPrincipal = new UserPrincipal();

		userPrincipal.setIdUsuario(model.getId());
		userPrincipal.setMail(model.getMail());
		userPrincipal.setFullName(model.getFullNames());
		userPrincipal.setUsername(model.getUsername());
		userPrincipal.setSocialSecurityNumber(model.getSocialSecurityNumber());
		userPrincipal.setBusinessPosition(model.getBusinessPosition());
		userPrincipal.setUsername(user);
		userPrincipal.setPassword(password);

		userPrincipal.setProfile(profileRepository.getProfileByUsername(model.getId()));
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(userPrincipal.getProfile().getName()));

		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return userPrincipal;
	}

}