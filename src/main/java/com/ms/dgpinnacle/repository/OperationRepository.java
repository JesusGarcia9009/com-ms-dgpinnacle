package com.ms.dgpinnacle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ms.dgpinnacle.entity.LetterConfig;
import com.ms.dgpinnacle.entity.Operation;

public interface OperationRepository extends CrudRepository<Operation, Long> {
	
	@Query("SELECT o "
			+ " FROM Operation o "
			+ " 	 INNER JOIN o.clientOperations co "
			+ " 	 INNER JOIN co.client c "
			+ " 	 INNER JOIN o.realtorOperations ro "
			+ " 	 INNER JOIN ro.realtor r "
			+ " 	 INNER JOIN o.loanOfficer lo "
			+ " WHERE c.id IN (:clientIds) AND r.id IN (:realtorIds) AND lo.id = :loandId ")
	Operation findOperationByClientsAndRealtorsAndLoan(@Param("realtorIds") List<Long> realtorIds,
			@Param("clientIds") List<Long> clientIds,
			@Param("loandId") Long loandId);
	
	
	@Query("SELECT lc FROM Operation o INNER JOIN o.letterConfigs lc WHERE o.id = :operationId ")
	List<LetterConfig> findlettersByOperationId(@Param("operationId") Long operationId);
	
}
