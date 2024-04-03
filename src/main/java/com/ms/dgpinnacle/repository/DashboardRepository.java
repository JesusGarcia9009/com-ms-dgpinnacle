package com.ms.dgpinnacle.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.dgpinnacle.dto.security.DashboardDataDto;
import com.ms.dgpinnacle.entity.Profile;

/**
 * IDashboardRepository (operaciones CRUD de la entidad) - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
public interface DashboardRepository extends CrudRepository<Profile, Long> {
	
	
	
	@Query(   "   SELECT new com.ms.dgpinnacle.dto.security.DashboardDataDto ( "
			+ "			 (SELECT COUNT(lc) FROM LetterConfig lc WHERE FUNC('DATE_TRUNC', 'month', lc.updateDate) = FUNC('DATE_TRUNC', 'month', CURRENT_DATE)) , "
			+ "			 (SELECT COUNT(op) FROM Operation op WHERE FUNC('DATE_TRUNC', 'month', op.updateDate) = FUNC('DATE_TRUNC', 'month', CURRENT_DATE)) , "
			+ "			 'TEST' , "
			+ "			 (SELECT COUNT(cl) FROM Client cl WHERE FUNC('DATE_TRUNC', 'month', cl.updateDate) = FUNC('DATE_TRUNC', 'month', CURRENT_DATE)) , "
			+ "			 (SELECT COUNT(lc) FROM LetterConfig lc WHERE FUNC('DATE_TRUNC', 'month', lc.updateDate) = FUNC('DATE_TRUNC', 'month', CURRENT_DATE) AND lc.deleted = true) ) " 
			+ "     FROM Profile p ")
	DashboardDataDto getStatistics();
	
	@Query(value =  "(SELECT COUNT(*) FROM public.letter_config WHERE DATE_TRUNC('month', update_date) = DATE_TRUNC('month', CURRENT_DATE));", nativeQuery = true)
    Long getLetterConfigCount();
	
	@Query(value =  "(SELECT COUNT(*) FROM public.letter_config WHERE DATE_TRUNC('month', update_date) = DATE_TRUNC('month', CURRENT_DATE) AND active = false);", nativeQuery = true)
    Long getDeletedLetterConfigCount();
	
	@Query(value =  "(SELECT a.update_user FROM ( SELECT update_user, COUNT(*) AS count FROM public.letter_config  WHERE DATE_TRUNC('month', update_date) = DATE_TRUNC('month', CURRENT_DATE) GROUP BY update_user ORDER BY count DESC LIMIT 1 ) as a ); ", nativeQuery = true)
    String getTopUser();
	
	@Query(value =  "(SELECT COUNT(*) FROM public.operation WHERE DATE_TRUNC('month', update_date) = DATE_TRUNC('month', CURRENT_DATE));", nativeQuery = true)
    Long getOperationCount();
	
	@Query(value =  "(SELECT COUNT(*) FROM public.client WHERE DATE_TRUNC('month', update_date) = DATE_TRUNC('month', CURRENT_DATE));", nativeQuery = true)
    Long getClientCount();


	
    
	
}
