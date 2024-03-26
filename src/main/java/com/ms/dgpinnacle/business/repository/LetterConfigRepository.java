package com.ms.dgpinnacle.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ms.dgpinnacle.business.dto.LetterConfigDto;
import com.ms.dgpinnacle.business.entity.LetterConfig;

public interface LetterConfigRepository extends CrudRepository<LetterConfig, Long> {

	
	//CODIGO NUEVO
	@Query(" SELECT new com.ms.dgpinnacle.business.dto.LetterConfigDto( "
			+ "lc.id, "
			+ "lc.active, "
			+ "lc.deleted, "
			+ "lc.hoa, "
			+ "lc.insurance, "
			+ "lc.interest, "
			+ "lc.loanAmount, "
			+ "lc.loanTerm, "
			+ "lc.loanType, "
			+ "lc.location, "
			+ "lc.ltv, "
			+ "lc.maxPay, "
			+ "lc.mi, "
			+ "lc.price, "
			+ "lc.taxes, "
			+ "lc.uniqueKey, "
			+ "lfd.id, "
			+ "lfd.conditions, "
			+ "lfd.deleted, "
			+ "lfd.finaltext, "
			+ "lfd.subject, "
			+ "o.id, "
			+ "o.name,"
			+ "lo.id, "
			+ "lo.cellphone, "
			+ "lo.email, "
			+ "lo.lastName, "
			+ "lo.mailingAdd, "
			+ "lo.name, "
			+ "lo.nmls "			
			+ ") "
		+ "    FROM LetterConfig lc "
		+ "         INNER JOIN lc.letterFixdata lfd"
		+ "         INNER JOIN lc.operation o "
		+ "         INNER JOIN o.loanOfficer lo "
		+ "   WHERE lc.active = true")
	List<LetterConfigDto> findAllLetterList();
	
	//CODIGO NUEVO
		@Query(" SELECT new com.ms.dgpinnacle.business.dto.LetterConfigDto( "
				+ "lc.id, "
				+ "lc.active, "
				+ "lc.deleted, "
				+ "lc.hoa, "
				+ "lc.insurance, "
				+ "lc.interest, "
				+ "lc.loanAmount, "
				+ "lc.loanTerm, "
				+ "lc.loanType, "
				+ "lc.location, "
				+ "lc.ltv, "
				+ "lc.maxPay, "
				+ "lc.mi, "
				+ "lc.price, "
				+ "lc.taxes, "
				+ "lc.uniqueKey, "
				+ "lfd.id, "
				+ "lfd.conditions, "
				+ "lfd.deleted, "
				+ "lfd.finaltext, "
				+ "lfd.subject, "
				+ "o.id, "
				+ "o.name,"
				+ "lo.id, "
				+ "lo.cellphone, "
				+ "lo.email, "
				+ "lo.lastName, "
				+ "lo.mailingAdd, "
				+ "lo.name, "
				+ "lo.nmls "			
				+ ") "
			+ "    FROM LetterConfig lc "
			+ "         INNER JOIN lc.letterFixdata lfd"
			+ "         INNER JOIN lc.operation o "
			+ "         INNER JOIN o.loanOfficer lo "
			+ "   WHERE lc.active = true and lc.id = :id")
		LetterConfigDto findLetterDataById(Long id);
	
	
	//CODIGO VIEJO
	@Query(value = "SELECT DISTINCT " +
			 "letter_config.id,  " +
			 "letter_config.deleted,  " +
			 "letter_config.loan_amount,  " +
			 "letter_config.loan_term,  " +
			 "letter_config.loan_type,  " +
			 "letter_config.location,  " +
			 "letter_config.ltv,  " +
			 "letter_config.max_pay,  " +
			 "letter_config.price,  " +
			 "letter_config.hoa,  " +
			 "letter_config.taxes,  " +
			 "letter_config.letter_fix_data_id,  " +
			 "letter_config.operation_id,  " +
			 "letter_config.active  " +
			// "loan_client_operation.loan_client_id,  " +
			// "loan_client.id as client_id  " +
			// "operation.id as operation_id " +
			"FROM  " +
			 "public.letter_config,  " +
			 "public.loan_client,  " +
			 "public.loan_client_operation,  " +
			 "public.loan_officer,  " +
			 "public.client,  " +
			 "public.operation " +
			"WHERE  " +
			  "loan_client.id = loan_client_operation.loan_client_id AND " +
			  "loan_client.loan_id = loan_officer.loan_id AND " +
			  "loan_client_operation.operation_id = operation.id AND " +
			  "client.id = loan_client.client_id AND " +
			  "operation.id = letter_config.operation_id AND " +
			  "letter_config.deleted is not true AND " +
			  "loan_officer.loan_id = :loan_id" , nativeQuery = true )
	List<LetterConfig> findByLoan(@Param("loan_id") Long loan_id);
	
	@Query(value = "SELECT DISTINCT " +
			 "letter_config.id,  " +
			 "letter_config.deleted,  " +
			 "letter_config.loan_amount,  " +
			 "letter_config.loan_term,  " +
			 "letter_config.loan_type,  " +
			 "letter_config.location,  " +
			 "letter_config.interest,  " +
			 "letter_config.mi,  " +
			 "letter_config.insurance,  " +
			 "letter_config.ltv,  " +
			 "letter_config.max_pay,  " +
			 "letter_config.price,  " +
			 "letter_config.hoa,  " +
			 "letter_config.taxes,  " +
			 "letter_config.letter_fix_data_id,  " +
			 "letter_config.operation_id,  " +
			 "letter_config.active,  " +
			 "letter_config.unique_key  " + 
			// "loan_client_operation.loan_client_id,  " +
			// "loan_client.id as client_id  " +
			// "operation.id as operation_id " +
			"FROM  " +
			 "public.letter_config,  " +
			 "public.loan_client,  " +
			 "public.loan_client_operation,  " +
			 "public.loan_officer,  " +
			 "public.client,  " +
			 "public.operation " +
			"WHERE  " +
			  "loan_client.id = loan_client_operation.loan_client_id AND " +
			  "loan_client.loan_id = loan_officer.loan_id AND " +
			  "loan_client_operation.operation_id = operation.id AND " +
			  "client.id = loan_client.client_id AND " +
			  "operation.id = letter_config.operation_id AND " +
			  "letter_config.deleted is not true AND " +
			  //"letter_config.active = true AND " +
			  "loan_officer.loan_id = :loan_id" , nativeQuery = true )
	List<LetterConfig> findActiveByLoan(@Param("loan_id") Long loan_id);
	
	@Query(value = "SELECT DISTINCT " + 
			  "letter_config.id,  " + 
			  "letter_config.deleted,  " + 
			  "letter_config.loan_amount,  " + 
			  "letter_config.loan_term,  " + 
			  "letter_config.loan_type,  " + 
			  "letter_config.location,  " + 
			  "letter_config.ltv,  " + 
			  "letter_config.max_pay,  " + 
			  "letter_config.price,  " + 
			  "letter_config.hoa,  " + 
			  "letter_config.letter_fix_data_id,  " + 
			  "letter_config.taxes  " + 
			  //--loan_client_operation.loan_client_id, 
			  //--loan_client.id as client_id--, 
			  //--operation.id as operation_id
			"FROM  " + 
			  "public.letter_config,  " + 
			  "public.company_realtor,  " + 
			  "public.company_realtor_operation,  " + 
			  "public.realtor,  " + 
			  "public.operation " + 
			  //--public.company
			"WHERE  " +
			//--company_realtor.company_id = company.id AND
			"company_realtor.realtor_id = realtor.realtor_id AND  " + 
			"company_realtor_operation.company_realtor_id = company_realtor.id AND  " + 
			"company_realtor_operation.operation_id = operation.id AND  " + 
			"operation.letter_config_id = letter_config.id AND  " + 
			"letter_config.deleted = false AND  " + 
			"realtor.realtor_id = :realtor_id", nativeQuery = true )
			List<LetterConfig> findByRealtor(@Param("realtor_id") Long realtor_id);
			
			@Query(value = "SELECT DISTINCT " + 
					  "letter_config.id,  " +
					  "letter_config.deleted,  " + 
					  "letter_config.loan_amount,  " + 
					  "letter_config.loan_term,  " + 
					  "letter_config.loan_type,  " + 
					  "letter_config.location,  " + 
					  "letter_config.interest,  " +
					  "letter_config.mi,  " +
					  "letter_config.insurance,  " +
					  "letter_config.ltv,  " + 
					  "letter_config.max_pay,  " + 
					  "letter_config.price,  " + 
					  "letter_config.hoa,  " + 
					  "letter_config.letter_fix_data_id,  " + 
					  "letter_config.taxes,  " + 
					  "letter_config.active,  " + 
					  "letter_config.operation_id,  " + 
					  "letter_config.unique_key  " + 
					  //--loan_client_operation.loan_client_id, 
					  //--loan_client.id as client_id--, 
					  //--operation.id as operation_id
					"FROM  " + 
					  "public.letter_config,  " + 
					  "public.company_realtor,  " + 
					  "public.company_realtor_operation,  " + 
					  "public.realtor,  " + 
					  "public.operation " + 
					  //--public.company
					"WHERE  " +
					//--company_realtor.company_id = company.id AND
					"company_realtor.realtor_id = realtor.realtor_id AND  " + 
					"company_realtor_operation.company_realtor_id = company_realtor.id AND  " + 
					"company_realtor_operation.operation_id = operation.id AND  " + 
					"operation.id = letter_config.operation_id AND  " + 
					"letter_config.deleted = false AND  " + 
					//"letter_config.active = true AND  " + 
					"realtor.realtor_id = :realtor_id", nativeQuery = true )
					List<LetterConfig> findActiveByRealtor(@Param("realtor_id") Long realtor_id);
					
					@Query(value = "SELECT  " +
							 "letter_config.id,  " +
							 "letter_config.deleted,  " +
							 "letter_config.loan_amount,  " +
							 "letter_config.loan_term,  " +
							 "letter_config.loan_type,  " +
							 "letter_config.location,  " +
							 "letter_config.interest,  " +
							 "letter_config.mi,  " +
							 "letter_config.insurance,  " +
							 "letter_config.ltv,  " +
							 "letter_config.max_pay,  " +
							 "letter_config.price,  " +
							 "letter_config.hoa,  " +
							 "letter_config.taxes,  " +
							 "letter_config.letter_fix_data_id,  " +
							 "letter_config.operation_id,  " +
							 "letter_config.active,  " +
							 "letter_config.unique_key  " + 
							// "loan_client_operation.loan_client_id,  " +
							// "loan_client.id as client_id  " +
							// "operation.id as operation_id " +
							"FROM  " +
							 "public.letter_config,  " +
							 "public.loan_client,  " +
							 "public.loan_client_operation,  " +
							 "public.loan_officer,  " +
							 "public.client,  " +
							 "public.operation " +
							"WHERE  " +
							  "loan_client.id = loan_client_operation.loan_client_id AND " +
							  "loan_client.loan_id = loan_officer.loan_id AND " +
							  "loan_client_operation.operation_id = operation.id AND " +
							  "client.id = loan_client.client_id AND " +
							  "operation.id = letter_config.operation_id AND " +
							  "letter_config.deleted is not true AND " +
							  "letter_config.active = true AND " +
							  "letter_config.operation_id = :operation_id" , nativeQuery = true )
					List<LetterConfig> findActiveByOperation(@Param("operation_id") Long operation_id);
					
			public LetterConfig findByUniqueKey(String uniqueKey);
			
			
			
			
	
			
			
}
