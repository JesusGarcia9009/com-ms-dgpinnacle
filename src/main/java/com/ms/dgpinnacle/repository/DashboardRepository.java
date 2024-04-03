package com.ms.dgpinnacle.repository;

import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.entity.Profile;

/**
 * IDashboardRepository (operaciones CRUD de la entidad) - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public interface DashboardRepository extends CrudRepository<Profile, Long> {


	
    
	
}
