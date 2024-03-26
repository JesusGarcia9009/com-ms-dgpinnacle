package com.ms.dgpinnacle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ms.dgpinnacle.entity.CompanyRealtor;
import com.ms.dgpinnacle.repository.CompanyRealtorRepository;


@Service
public class CompanyRealtorServices {

	
	@Autowired
	private CompanyRealtorRepository Company_RealtorRepository;
	
	@ExceptionHandler
	public CompanyRealtor getCompanyByCompanyAndRealtor(Long idCompany , Long idRealtor) throws Exception { //bateo cuando sea null
		return Company_RealtorRepository.getCompany_RealtorByCompanyAndRealtor(idCompany , idRealtor);
	}
	
	@ExceptionHandler
	public void AddCompany_Realtor(CompanyRealtor CompanyRealtor) throws Exception {
		Company_RealtorRepository.save(CompanyRealtor);
	}
	
	@ExceptionHandler
	public void DeleteCompany_Realtor(long company_id, long realtor_id) throws Exception {
		Company_RealtorRepository.DeleteByCR(company_id, realtor_id);
	}
	
}
