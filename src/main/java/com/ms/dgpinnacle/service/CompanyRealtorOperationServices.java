package com.ms.dgpinnacle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ms.dgpinnacle.entity.CompanyRealtorOperation;
import com.ms.dgpinnacle.repository.CompanyRealtorOperationRepository;


@Service
public class CompanyRealtorOperationServices {

	
	@Autowired
	private CompanyRealtorOperationRepository Company_Realtor_OperationRepository;
	
	@ExceptionHandler
	public CompanyRealtorOperation getCompanyRealtorOperationByCompanyAndRealtor(Long company_realtor_id , Long operation_id) throws Exception {
		CompanyRealtorOperation cro = new CompanyRealtorOperation();
		if(Company_Realtor_OperationRepository.getCompany_RealtorByCompanyAndRealtor(company_realtor_id , operation_id) != null)			
		return Company_Realtor_OperationRepository.getCompany_RealtorByCompanyAndRealtor(company_realtor_id , operation_id);
		else
			return cro;
	}
	
	@ExceptionHandler
	public void AddCompany_Realtor_Operation(CompanyRealtorOperation CompanyRealtorOperation) throws Exception {
		Company_Realtor_OperationRepository.save(CompanyRealtorOperation);
	}
	
	@ExceptionHandler
	public void DeleteCompany_Realtor_Operation(long CRO_Id) throws Exception {
		Company_Realtor_OperationRepository.DeleteByCR_Id(CRO_Id);
	}
	
	
}
