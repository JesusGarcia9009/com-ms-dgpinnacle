package com.ms.dgpinnacle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.dto.BrokerCompanyDto;
import com.ms.dgpinnacle.entity.BrokerCompany;

public interface BrokerCompanyRepository extends CrudRepository<BrokerCompany, Long> {
	
	@Query(" SELECT new com.ms.dgpinnacle.dto.BrokerCompanyDto( "
			+ " bc.id, "
			+ "	bc.name, "
			+ "	bc.phone, "
			+ "	bc.physicalAdd, "
			+ "	bc.webSite ) "
		+ "    FROM BrokerCompany bc ")
	List<BrokerCompanyDto> getAllBrokerCompany();
}
