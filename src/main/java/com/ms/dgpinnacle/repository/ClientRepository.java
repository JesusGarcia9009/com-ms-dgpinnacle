package com.ms.dgpinnacle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.dto.ClientDto;
import com.ms.dgpinnacle.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

	
	Client findByEmailOrCellphone(String email, String cellphone);
	
	@Query(" SELECT new com.ms.dgpinnacle.dto.ClientDto( c.id,  c.cellphone, c.email,  c.lastName,  c.mailingAdd,  c.name, u.pass, p.id, p.profileCode, p.profileName  )  "
			+" FROM Client c "
			+ "     INNER JOIN c.users u "
			+ "     INNER JOIN u.profile p ")
	List<ClientDto> findAllClientList();
	
	@Query("  SELECT new com.ms.dgpinnacle.dto.ClientDto( c.id,  c.cellphone, c.email,  c.lastName,  c.mailingAdd,  c.name, u.pass, p.id, p.profileCode, p.profileName  )  "
			+"  FROM Client c "
			+"       INNER JOIN c.users u "
			+"       INNER JOIN u.profile p "
			+" WHERE c.id = :id ")
	ClientDto getClientById(Long id);
	
	@Query(" SELECT new com.ms.dgpinnacle.dto.ClientDto(  c.id,  c.cellphone, c.email,  c.lastName,  c.mailingAdd,  c.name, u.pass, p.id, p.profileCode, p.profileName  ) "
			+ "    FROM LetterConfig lc "
			+ "         INNER JOIN lc.letterFixdata lfd"
			+ "         INNER JOIN lc.operation o "
			+ "         INNER JOIN o.clientOperations co "
			+ "			INNER JOIN co.client c "
			+ "         INNER JOIN c.users u "
			+ "         INNER JOIN u.profile p "
			+ "   WHERE lc.id = :idLetter ")
		List<ClientDto> getClientsByLetter(Long idLetter);
	
}
