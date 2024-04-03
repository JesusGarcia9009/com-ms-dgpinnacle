package com.ms.dgpinnacle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.dto.ClientDto;
import com.ms.dgpinnacle.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

	
	Client findByEmailOrCellphone(String email, String cellphone);
	
	@Query(" SELECT new com.ms.dgpinnacle.dto.ClientDto( c.id,  c.cellphone, c.email,  c.lastName,  c.mailingAdd,  c.name  )  FROM Client c ")
	List<ClientDto> findAllClientList();
	
	@Query(" SELECT new com.ms.dgpinnacle.dto.ClientDto(  c.id,  c.cellphone, c.email,  c.lastName,  c.mailingAdd,  c.name  ) "
			+ "    FROM LetterConfig lc "
			+ "         INNER JOIN lc.letterFixdata lfd"
			+ "         INNER JOIN lc.operation o "
			+ "         INNER JOIN o.clientOperations co "
			+ "			INNER JOIN co.client c"
			+ "   WHERE lc.id = :idLetter ")
		List<ClientDto> getClientsByLetter(Long idLetter);
	
}
