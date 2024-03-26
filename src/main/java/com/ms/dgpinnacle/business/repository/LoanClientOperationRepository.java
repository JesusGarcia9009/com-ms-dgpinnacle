package com.ms.dgpinnacle.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ms.dgpinnacle.entity.LoanClientOperation;

public interface LoanClientOperationRepository extends CrudRepository<LoanClientOperation, Long> {
	

	
	@Query(value = "SELECT public.* FROM public.loan_client_operation WHERE public.loan_client_operation.loan_client_id = :loan_clientId" , nativeQuery = true)
	public LoanClientOperation getlocByLoan_Client(@Param("loan_clientId") Long loan_clientId);
	
	@Query(value = "SELECT loan_client_operation.* FROM public.loan_client_operation WHERE public.loan_client_operation.operation_id = :op_id" , nativeQuery = true)
	public List<LoanClientOperation> getLCOByOperation(@Param("op_id") Long op_id);
	
	@Query(value = "SELECT * FROM public.loan_client_operation WHERE public.loan_client_operation.operation_id = :operation_id" , nativeQuery = true)
	public Optional<LoanClientOperation> findByOperationId(@Param("operation_id") Long operation_id);

	}
