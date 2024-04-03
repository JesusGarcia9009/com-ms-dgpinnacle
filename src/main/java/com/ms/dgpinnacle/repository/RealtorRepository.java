package com.ms.dgpinnacle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.dto.RealtorDto;
import com.ms.dgpinnacle.dto.RealtorOperationDto;
import com.ms.dgpinnacle.entity.Realtor;

public interface RealtorRepository extends CrudRepository<Realtor, Long> {	
	
	
		@Query(" SELECT new com.ms.dgpinnacle.dto.RealtorOperationDto( r.id, r.cellphone, r.email, r.lastName, r.licenseNumber, r.mailingAdd, r.name, r.notes ) "
			+ "    FROM LetterConfig lc "
			+ "         INNER JOIN lc.letterFixdata lfd"
			+ "         INNER JOIN lc.operation o "
			+ "         INNER JOIN o.realtorOperations ro "
			+ "			INNER JOIN ro.realtor r"
			+ "   WHERE lc.id = :idLetter ")
		List<RealtorOperationDto> getRealtorsByLetter(Long idLetter);
		
		@Query(" SELECT new com.ms.dgpinnacle.dto.RealtorOperationDto( r.id, r.cellphone, r.email, r.lastName, r.licenseNumber, r.mailingAdd, r.name, r.notes ) "
			+ "    FROM Realtor r ")
		List<RealtorOperationDto> findAllRealtorList();
		
		@Query(" SELECT new com.ms.dgpinnacle.dto.RealtorDto ( r.id, r.cellphone, r.email, r.lastName, r.licenseNumber, r.mailingAdd, r.name, r.notes, bc.id, bc.name, bc.phone, bc.physicalAdd, bc.webSite, u.pass, p.id, p.profileCode, p.profileName ) "
				+ "    FROM Realtor r "
				+ "         LEFT JOIN r.brokerCompany bc "
				+ "         INNER JOIN r.users u "
				+ "         INNER JOIN u.profile p ")
		List<RealtorDto> getRealtorList();
		
		@Query(" SELECT new com.ms.dgpinnacle.dto.RealtorDto ( r.id, r.cellphone, r.email, r.lastName, r.licenseNumber, r.mailingAdd, r.name, r.notes, bc.id, bc.name, bc.phone, bc.physicalAdd, bc.webSite, u.pass, p.id, p.profileCode, p.profileName ) "
			+ "    FROM Realtor r "
			+ "         LEFT JOIN r.brokerCompany bc "
			+ "         INNER JOIN r.users u "
			+ "         INNER JOIN u.profile p "
			+ "   WHERE r.id = :id ")
		RealtorDto getRealtorById(Long id);
		
		Realtor findByEmailOrCellphone(String email, String cellphone);
		
		
}
