package com.ms.dgpinnacle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.dto.LetterConfigDto;
import com.ms.dgpinnacle.entity.LetterConfig;

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
			+ "			INNER JOIN o.clientOperations co "
			+ "			INNER JOIN co.client c "
			+ "   WHERE lc.active = true AND c.id = :idClient "
			+ "ORDER BY lc.id DESC ")
		LetterConfigDto findLetterDataByIdClient(Long idClient);
	
	
}
