package com.ms.dgpinnacle.business.repository;

import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.business.entity.LoanOfficer;

public interface LoanOfficerRepository extends CrudRepository<LoanOfficer, Long> {
	
	LoanOfficer findByEmailOrCellphoneIgnoreCase(String email, String cellphone);

}
