package com.ms.dgpinnacle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.entity.RealtorOperation;

public interface RealtorOperationRepository extends CrudRepository<RealtorOperation, Long> {

	@Query("select ro from RealtorOperation ro where ro.operation.id = :id ")
	List<RealtorOperation> findByOperation(Long id);
}
