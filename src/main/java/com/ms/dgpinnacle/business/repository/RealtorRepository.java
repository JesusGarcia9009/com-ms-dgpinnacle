package com.ms.dgpinnacle.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ms.dgpinnacle.business.dto.RealtorDto;
import com.ms.dgpinnacle.business.dto.RealtorOperationDto;
import com.ms.dgpinnacle.business.entity.Realtor;

public interface RealtorRepository extends CrudRepository<Realtor, Long> {	
	
	
		//CODIGO NUEVO
		@Query(" SELECT new com.ms.dgpinnacle.business.dto.RealtorOperationDto( "
				+ " r.id, "
				+ "	r.cellphone, "
				+ "	r.email, "
				+ "	r.lastName, "
				+ "	r.licenseNumber, "
				+ "	r.mailingAdd, "
				+ "	r.name, "
				+ "	r.notes "			
				+ ") "
			+ "    FROM LetterConfig lc "
			+ "         INNER JOIN lc.letterFixdata lfd"
			+ "         INNER JOIN lc.operation o "
			+ "         INNER JOIN o.realtorOperations ro "
			+ "			INNER JOIN ro.realtor r"
			+ "   WHERE lc.id = :idLetter ")
		List<RealtorOperationDto> getRealtorsByLetter(Long idLetter);
		
		@Query(" SELECT new com.ms.dgpinnacle.business.dto.RealtorOperationDto( "
				+ " r.id, "
				+ "	r.cellphone, "
				+ "	r.email, "
				+ "	r.lastName, "
				+ "	r.licenseNumber, "
				+ "	r.mailingAdd, "
				+ "	r.name, "
				+ "	r.notes "			
				+ ") "
			+ "    FROM Realtor r ")
		List<RealtorOperationDto> findAllRealtorList();
		
		@Query(" SELECT new com.ms.dgpinnacle.business.dto.RealtorDto ( "
				+ " r.id, "
				+ "	r.cellphone, "
				+ "	r.email, "
				+ "	r.lastName, "
				+ "	r.licenseNumber, "
				+ "	r.mailingAdd, "
				+ "	r.name, "
				+ "	r.notes, "
				+ " bc.id, "
				+ "	bc.name, "
				+ "	bc.phone, "
				+ "	bc.physicalAdd, "
				+ "	bc.webSite"			
				+ ") "
			+ "    FROM Realtor r "
			+ "         LEFT JOIN r.brokerCompany bc ")
		List<RealtorDto> getRealtorList();
		
		Realtor findByEmailOrCellphone(String email, String cellphone);
		
		
		
		
		
		
		//CODIGO viejo

//public List<Realtor> findbyCompanyId(Long company_id);
	
//	@Query(value = "SELECT  " + 
//			"  realtor.*, app_user.* " + 
//			"FROM  " + 
//			"  public.company,  " + 
//			"  public.company_realtor,  " + 
//			"  public.realtor,  " + 
//			"  public.app_user " + 
//			"WHERE  " + 
//			"  company.id= company_realtor.company_id AND " + 
//			"  company_realtor.realtor_id = realtor.realtor_id AND " + 
//			"  realtor.realtor_id = app_user.user_id AND " + 
//			"  company.id = :company_id", nativeQuery = true
//			)
//	List<Realtor> findByCompany(@Param("company_id") Long company_id);

	
	@Query(value = "SELECT  " + 
			"  realtor.realtor_id,  " + 
			"  realtor.name,  " + 
			"  realtor.last_name,  " + 
			"  realtor.cellphone,  " + 
			"  realtor.email,  " + 
			"  realtor.license_number,  " + 
			"  realtor.mailing_add,  " + 
			"  realtor.notes,  " + 
			"  app_user.user_id,  " + 
			"  app_user.enabled,  " + 
			"  app_user.encryted_password,  " + 
			"  app_user.name,  " + 
			"  realtor.broker_company_id " + 
			"FROM  " + 
			"  public.realtor,  " + 
			"  public.company,  " + 
			"  public.company_realtor,  " + 
			"  public.app_user " + 
			"WHERE  " + 
			
			"  realtor.realtor_id = company_realtor.realtor_id AND " + 
			"  company_realtor.company_id = company.id AND " + 
			"  app_user.user_id = realtor.realtor_id and company.id =  :company_id", nativeQuery = true)
		List<Realtor> findByCompanyId(@Param("company_id")Long company_id);
}
