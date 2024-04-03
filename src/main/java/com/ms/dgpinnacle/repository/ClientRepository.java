package com.ms.dgpinnacle.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ms.dgpinnacle.dto.ClientDto;
import com.ms.dgpinnacle.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

	
	//CODIGO NUEVO
	@Query(" SELECT new com.ms.dgpinnacle.business.dto.ClientDto( "
			+ " c.id, "
			+ "	c.cellphone, "
			+ "	c.email, "
			+ "	c.lastName, "
			+ "	c.mailingAdd, "
			+ "	c.name "			
			+ ") "
		+ "    FROM LetterConfig lc "
		+ "         INNER JOIN lc.letterFixdata lfd"
		+ "         INNER JOIN lc.operation o "
		+ "         INNER JOIN o.clientOperations co "
		+ "			INNER JOIN co.client c"
		+ "   WHERE lc.id = :idLetter ")
	List<ClientDto> getClientsByLetter(Long idLetter);
	
	@Query(" SELECT new com.ms.dgpinnacle.business.dto.ClientDto( "
			+ " c.id, "
			+ "	c.cellphone, "
			+ "	c.email, "
			+ "	c.lastName, "
			+ "	c.mailingAdd, "
			+ "	c.name "			
			+ ") "
		+ "    FROM Client c ")
	List<ClientDto> findAllClientList();
	
	
	Client findByEmailOrCellphone(String email, String cellphone);
	
	
	
	
	
	//CODIGO viejo
	@Query(value = "SELECT  " + 
			"  client.id,  " + 
			"  client.cellphone,  " + 
			"  client.email,  " + 
			"  client.last_name,  " + 
			"  client.mailing_add,  " + 
			"  client.name  " + 
			"FROM  " + 
			"  public.loan_officer,  " + 
			"  public.loan_client,  " + 
			//"  public.realtor,  " + 
			//"  public.realtor_client,  " + 
			"  public.client " + 
			"WHERE  " + 
			"  loan_officer.loan_id = loan_client.loan_id AND " + 
			"  loan_client.client_id = client.id AND " + 
			//"  realtor.realtor_id = realtor_client.realtor_id AND " + 
			//"  realtor_client.client_id = client.id and " + 
			"  loan_officer.loan_id = :loan_id", nativeQuery = true)
	List<Client> findClientByLoan(@Param("loan_id") Long loan_id);
	
	@Query(value = "SELECT "
			+ " client.id,"
			+ " client.cellphone,"
			+ " client.email,"
			+ " client.last_name,"
			+ " client.mailing_add,"
			+ " client.name " 
	+ "FROM public.realtor,"
	+ " public.company_realtor,"
	+ " public.company_realtor_operation,"
	+ " public.loan_client_operation, loan_client,"
	+ " public.client "
	+ "WHERE realtor.realtor_id = company_realtor.realtor_id"
	+ " AND company_realtor_operation.company_realtor_id = company_realtor.id"
	+ " AND loan_client_operation.operation_id = company_realtor_operation.operation_id"
	+ " AND loan_client_operation.loan_client_id = loan_client.id AND loan_client.client_id = client.id"
	+ " AND realtor.realtor_id = :realtor_id",nativeQuery = true)
	List<Client> findClientByRealtor(@Param("realtor_id") Long realtor_id);

	
	@Query(value = "SELECT "
			+ " client.id,"
			+ " client.cellphone,"
			+ " client.email,"
			+ " client.last_name,"
			+ " client.mailing_add,"
			+ " client.name " 
	+ "FROM"
	+ " public.client "
	+ "WHERE client.email = :email",nativeQuery = true)
	Optional<Client> findClientByEmail(@Param("email") String email);

	
	
	
}
