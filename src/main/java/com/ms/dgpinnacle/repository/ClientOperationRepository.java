package com.ms.dgpinnacle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.entity.ClientOperation;

public interface ClientOperationRepository extends CrudRepository<ClientOperation, Long> {
	
	@Query("select co from ClientOperation co where co.operation.id = :id ")
	List<ClientOperation> findByOperation(Long id);

}
