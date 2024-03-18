package com.ms.dgpinnacle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ms.dgpinnacle.entity.LoanClient;

public interface LoanClientRepository extends CrudRepository<LoanClient, Long> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM public.loan_client WHERE public.loan_client.client_id = :client_id" , nativeQuery = true)
	public void DeleteByClient(@Param("client_id") Long client_id);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM public.loan_client WHERE public.loan_client.loan_id = :loan_id AND public.loan_client.client_id = :client_id" , nativeQuery = true)
	public void DeleteByLoanAndClient(@Param("loan_id") Long loan_id, @Param("client_id") Long client_id);
	
	
	@Query(value = "SELECT public.loan_client.* FROM public.loan_client WHERE public.loan_client.loan_id = :loan_id AND public.loan_client.client_id = :client_id" , nativeQuery = true)
	public LoanClient getLoan_ClientByClientAndLoan(@Param("loan_id") Long loan_id, @Param("client_id") Long client_id);
	
	@Query(value = "SELECT public.loan_client.* FROM public.loan_client WHERE public.loan_client.loan_id = :loan_id AND public.loan_client.client_id in (:clientIdList)" , nativeQuery = true)
	public List<LoanClient> getLoan_ClientByClientList(@Param("loan_id") Long loan_id, @Param("clientIdList") java.util.List<Long> clientIdList);
	
}