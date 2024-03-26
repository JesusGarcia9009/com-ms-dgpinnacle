package com.ms.dgpinnacle.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.business.entity.Users;
import com.ms.dgpinnacle.security.dto.UserDto;

/**
 * IUserRepository (operaciones CRUD de la entidad) - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public interface IUserRepository extends CrudRepository<Users, Long> {

	Optional<Users> findByUsernameOrMail(String Username, String mail);
	
    Users findBySocialSecurityNumberOrUsername(String socialSecurityNumber, String username);
	
	Long countBySocialSecurityNumberOrUsername(String socialSecurityNumber, String username);
	
	@Query(   "   SELECT new com.ms.dgpinnacle.security.dto.UserDto (u.id ,u.socialSecurityNumber ,u.fullNames ,u.mail ,u.businessPosition ,u.pass, p.id, p.profileName) " 
			+ "     FROM Users u "
			+ "			 inner join u.profile p ")
	List<UserDto> findAllUsers();
	
	Users findByMailOrSocialSecurityNumberOrUsername(String mail, String socialSecurityNumber, String username);
	
}
