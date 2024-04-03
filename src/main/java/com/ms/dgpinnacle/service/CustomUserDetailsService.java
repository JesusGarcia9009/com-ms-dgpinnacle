package com.ms.dgpinnacle.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.ERROR_USER_NOT_FOUND;
import static com.ms.dgpinnacle.utils.ConstantUtil.EXCEPTION;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ms.dgpinnacle.entity.Users;
import com.ms.dgpinnacle.repository.ProfileRepository;
import com.ms.dgpinnacle.token.ProfileDto;
import com.ms.dgpinnacle.token.UserPrincipal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * CustomUserDetailsService servicio de usuario para Sprint Security
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UsersService usersService;
	private final ProfileRepository profileRepository;

	@Override
	public UserPrincipal loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		Users model = null;
		UserPrincipal result = null;
		try {
			if (usersService.countUsersByMailOrUsername(usernameOrEmail) > 0) {
				model = usersService.getUserByMailOrUsername(usernameOrEmail);
				result = createUserPrincipal(model, usernameOrEmail, model.getPass());
			}else {
				throw new UsernameNotFoundException(ERROR_USER_NOT_FOUND);
			}
		} catch (Exception e) {
			log.error(String.format(EXCEPTION, Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage()));
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

	private UserPrincipal createUserPrincipal(Users model, String user, String password) {
	    log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));

	    UserPrincipal userPrincipal = new UserPrincipal();
	    userPrincipal.setIdUser(model.getId());
	    userPrincipal.setEmail(model.getEmail());
	    userPrincipal.setFullName(model.getName() + " " + model.getLastName());
	    userPrincipal.setUsername(user);
	    userPrincipal.setPassword(password);
	    
	    ProfileDto profile = profileRepository.getProfileByUserId(model.getId());
	    userPrincipal.setProfile(profile);

	    List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(profile.getCode()));
	    userPrincipal.setAuthorities(authorities);

	    log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
	    return userPrincipal;
	}


}