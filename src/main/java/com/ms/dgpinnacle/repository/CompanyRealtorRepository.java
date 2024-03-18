package com.ms.dgpinnacle.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ms.dgpinnacle.entity.CompanyRealtor;

public interface CompanyRealtorRepository extends CrudRepository<CompanyRealtor, Long> {

	@Query(value = "SELECT public.company_realtor.* FROM public.company_realtor WHERE public.company_realtor.company_id = :company_id AND public.company_realtor.realtor_id = :realtor_id" , nativeQuery = true)
	public CompanyRealtor getCompany_RealtorByCompanyAndRealtor(@Param("company_id") Long company_id, @Param("realtor_id") Long realtor_id);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM public.company_realtor WHERE public.company_realtor.company_id= :company_id AND public.company_realtor.realtor_id= :realtor_id", nativeQuery = true)
	public void DeleteByCR(@Param("company_id") Long company_id, @Param("realtor_id") Long realtor_id);
	
}
