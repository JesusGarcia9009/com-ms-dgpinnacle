package com.ms.dgpinnacle.security.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_MAIL_DUPL;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ms.dgpinnacle.business.dto.EnCompassRealtorDto;
import com.ms.dgpinnacle.business.entity.Profile;
import com.ms.dgpinnacle.business.entity.Users;
import com.ms.dgpinnacle.security.dto.UserDto;
import com.ms.dgpinnacle.security.repository.IProfileRepository;
import com.ms.dgpinnacle.security.repository.IUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * UsersServiceImpl clase que implementa la interfaz de servicio
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UsersService {

	private final IUserRepository userRepository;
	private final IProfileRepository profileRepository;

	public Users getUserByUsername(String username) {
		log.info("[getUserByUsername]::start/end of method");
		Optional<Users> opt = userRepository.findByUsernameOrMail(username, username);
		if (opt.isPresent())
			return opt.get();

		return null;
	}

	public Long countUsersByUsername(String username) {
		log.info("[countUserByUsername]::start/end of method");
		return userRepository.countBySocialSecurityNumberOrUsername(username, username);
	}

	public List<UserDto> findAllUsers() {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<UserDto> result = userRepository.findAllUsers();
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

	public Boolean save(UserDto user) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		String username = user.getMail().substring( 0, user.getMail().indexOf("@"));
		Users model = userRepository.findByMailOrSocialSecurityNumberOrUsername(user.getMail(), user.getSocialSecurityNumber(), username);
		
		if ((Objects.nonNull(model) && Objects.isNull(user.getId()))
				|| Objects.nonNull(model) && !user.getId().equals(model.getId()))
			throw new Exception(MSG_MAIL_DUPL);

		Users usuarioModel = new Users();
		Optional<Profile> profile = profileRepository.findById(Long.valueOf(user.getProfileId()));

		if (profile.isPresent()) {

			if(Objects.nonNull(user.getId()))
				usuarioModel.setId(user.getId());
				
			usuarioModel.setFullNames(user.getFullNames());
			usuarioModel.setMail(user.getMail());
			usuarioModel.setSocialSecurityNumber(user.getSocialSecurityNumber());
			usuarioModel.setProfile(profile.get());
			usuarioModel.setUsername(username);
			usuarioModel.setPass(user.getPass());
			usuarioModel.setBusinessPosition(user.getBusinessPosition());
			userRepository.save(usuarioModel);
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return true;
	}

	public boolean delete(UserDto dto) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		userRepository.deleteById(dto.getId());
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return true;
	}

	public Users save(EnCompassRealtorDto item) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		Optional<Profile> profile = profileRepository.findById(4l);
		Users x = new Users();
		//datos de usuario
		x.setFullNames(item.getFullName());
		x.setMail(item.getEmail());
		x.setSocialSecurityNumber("1111");
		x.setProfile(profile.get());
		x.setUsername(item.getEmail());
		x.setPass("$2a$10$Ood6ka2EnrwXrd4XqF4DUeMZghaFw6va.wnO1noxkIglFCVcyUWJm");
		x.setBusinessPosition("REALTOR");
		
		userRepository.save(x);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return x;
	}

}
