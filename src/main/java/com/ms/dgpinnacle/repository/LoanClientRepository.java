package com.ms.dgpinnacle.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.entity.LoanClient;

public interface LoanClientRepository extends CrudRepository<LoanClient, Long> {

	@Query("   SELECT count(1) "
			+ "  FROM LoanClient lc "
			+ "       INNER JOIN lc.client c "
			+ "       INNER JOIN lc.loanOfficer lo "
			+ " WHERE lo.id = :idLoan AND c.id = :idClient ")
	public int	findByLoanAndClientIds(long idLoan, long idClient);

}
