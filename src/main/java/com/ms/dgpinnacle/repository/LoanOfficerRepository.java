package com.ms.dgpinnacle.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.entity.LoanOfficer;

public interface LoanOfficerRepository extends CrudRepository<LoanOfficer, Long> {

	public List<LoanOfficer> findByCompanyId(Long company_id);
}
