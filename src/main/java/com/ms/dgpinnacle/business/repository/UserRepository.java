package com.ms.dgpinnacle.business.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.business.dto.security.UserDto;
import com.ms.dgpinnacle.business.entity.Users;

/**
 * IUserRepository (operaciones CRUD de la entidad) - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public interface UserRepository extends CrudRepository<Users, Long> {

	Optional<Users> findByUsernameOrEmail(String Username, String email);
	
	@Query(   "   SELECT new com.ms.dgpinnacle.security.dto.UserDto ("
			+ "			 u.id, "
			+ "			 u.name, "
			+ "			 u.lastName, "
			+ "			 u.email, "
			+ "			 u.cellphone, "
			+ "			 u.username, "
			+ "			 u.pass, "
			+ "			 u.mailingAdd, "
			+ "			 p.id, "
			+ "			 p.profileCode, "
			+ "			 p.profileName) " 
			+ "     FROM Users u "
			+ "			 inner join u.profile p ")
	List<UserDto> findAllUsers();
	
	Users findByEmailOrUsername(String email, String username);
	
	Long countByEmailOrUsername(String email, String username);
	
}
