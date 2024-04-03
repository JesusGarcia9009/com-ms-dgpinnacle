package com.ms.dgpinnacle.business.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.business.dto.LoanOfficerDto;
import com.ms.dgpinnacle.business.entity.LoanOfficer;

public interface LoanOfficerRepository extends CrudRepository<LoanOfficer, Long> {
	
	LoanOfficer findByEmailOrCellphoneIgnoreCase(String email, String cellphone);
	
	LoanOfficer findByEmailOrCellphone(String email, String cellphone);
	
	@Query(" SELECT new com.ms.dgpinnacle.business.dto.LoanOfficerDto ( "
			+ " l.id, "
			+ "	l.cellphone, "
			+ "	l.email, "
			+ "	l.lastName, "
			+ "	l.mailingAdd, "
			+ "	l.name, "
			+ "	l.nmls, "
			+ " l.pass, "
			+ " p.id, "
			+ " p.profileCode, "
			+ " p.profileName "			
			+ ") "
		+ "    FROM LoanOfficer l "
		+ "         INNER JOIN l.users u "
		+ "         INNER JOIN u.profile p "
		+ "   WHERE l.id = :id ")
	LoanOfficerDto getLoanById(Long id);

}
