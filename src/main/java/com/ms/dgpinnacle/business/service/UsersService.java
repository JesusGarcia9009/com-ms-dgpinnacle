package com.ms.dgpinnacle.business.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_MAIL_DUPL;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.ms.dgpinnacle.business.dto.security.UserDto;
import com.ms.dgpinnacle.business.entity.Profile;
import com.ms.dgpinnacle.business.entity.Users;
import com.ms.dgpinnacle.business.repository.ProfileRepository;
import com.ms.dgpinnacle.business.repository.UserRepository;
import com.ms.dgpinnacle.utils.Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * UsersService clase de servicio de usuario
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UsersService {

	private final UserRepository userRepository;
	private final ProfileRepository profileRepository;

	public Users getUserByMailOrUsername(String usernameOrMail) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		Users users = Utils.validateOpt(userRepository.findByUsernameOrEmail(usernameOrMail, usernameOrMail));
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return users;
	}

	public Long countUsersByMailOrUsername(String usernameOrMail) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		Long result = userRepository.countByEmailOrUsername(usernameOrMail, usernameOrMail); 
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

	public List<UserDto> findAllUsers() {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<UserDto> result = userRepository.findAllUsers();
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

	public Boolean save(UserDto user) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		String username = user.getEmail().substring(0, user.getEmail().indexOf("@"));
		Users model = userRepository.findByEmailOrUsername(user.getEmail(), username);

		if ((Objects.nonNull(model) && Objects.isNull(user.getId()))
				|| Objects.nonNull(model) && !user.getId().equals(model.getId()))
			throw new Exception(MSG_MAIL_DUPL);

		Users usuarioModel = new Users();
		Profile profile = profileRepository.findByProfileCode(user.getProfileCode());

		if (Objects.nonNull(user.getId()))
			usuarioModel.setId(user.getId());

		usuarioModel.setName(user.getName());
		usuarioModel.setLastName(user.getLastName());
		usuarioModel.setEmail(user.getEmail());
		usuarioModel.setCellphone(user.getCellphone());
		usuarioModel.setUsername(username);
		usuarioModel.setPass(user.getPassword());
		usuarioModel.setMailingAdd(user.getMailingAdd());
		usuarioModel.setProfile(profile);

		userRepository.save(usuarioModel);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return true;
	}

	public boolean delete(UserDto dto) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		userRepository.deleteById(dto.getId());
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return true;
	}

}
