package com.ms.dgpinnacle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ms.dgpinnacle.entity.LoanClientOperation;
import com.ms.dgpinnacle.entity.Operation;
import com.ms.dgpinnacle.repository.LoanClientOperationRepository;
import com.ms.dgpinnacle.repository.OperationRepository;

@Service
public class LoanClientOperationServices {

	
	@Autowired
	private LoanClientOperationRepository loanClientOperationRepository;
	
	@Autowired
	private OperationRepository operationRepository;

	@ExceptionHandler
	public void AddLoan_Client_Operation(LoanClientOperation loan_Client_Operation) throws Exception {
		loanClientOperationRepository.save(loan_Client_Operation);
	}
	
//	@ExceptionHandler
//	public Operation findOperationIdByLoan_Client(Long loan_clientId) throws Exception {
//		Operation operation = new Operation();
//		operation = loanClientOperationRepository.getOperationIdbyLoan_Client(loan_clientId);
//			return operation;		
//	}
//	
	@ExceptionHandler
	public Operation findOperationByLoan_Client_Realtor(Long loan_client_id, Long company_realtor_id) throws Exception {
		Operation operation = new Operation();		
		operation = operationRepository.getOperationIdbyLoan_Client_Realtor(loan_client_id, company_realtor_id);
			return operation;		
	}
	
	@ExceptionHandler
	public List<LoanClientOperation> findLCOByOperation(Operation op) throws Exception {
	    long op_id = op.getId();
		List<LoanClientOperation> lcoList = loanClientOperationRepository.getLCOByOperation(op_id);
			return lcoList;		
	}
	
//	@ExceptionHandler
//	public Operation getcomunOperationId(java.util.List<Long> loan_clientIdList, int length, Long company_realtor_id) throws Exception {
//		Operation operation = new Operation();		
//		operation = operationRepository.getcomunOperationId( loan_clientIdList, length, company_realtor_id);
//			return operation;		
//	}
	
	@ExceptionHandler
	public Long getcomunOperationId(java.util.List<Long> loan_clientIdList, Long company_realtor_id, int clsize) throws Exception {
		Long operation;		
		operation = operationRepository.getcomunOperationId( loan_clientIdList, company_realtor_id, clsize);
			return operation;		
	}
	
	@ExceptionHandler
	public Long getlcOperationByList(java.util.List<Long> loan_clientIdList, Long company_realtor_id) throws Exception {
		Long operation;		
		operation = operationRepository.getlcOperationByList( loan_clientIdList, company_realtor_id);
			return operation;		
	}
	
	@ExceptionHandler
	public LoanClientOperation getLCO(Long id) throws Exception {
		Optional<LoanClientOperation> optinalEntity =  loanClientOperationRepository.findById(id);
		return optinalEntity.get();
	}
	
	@ExceptionHandler
	public LoanClientOperation getLCOByOperation(Long operation_id) throws Exception {
		Optional<LoanClientOperation> optinalEntity =  loanClientOperationRepository.findByOperationId(operation_id);
		return optinalEntity.get();
	}
	
	@ExceptionHandler
	public LoanClientOperation findlocByLoan_Client(Long loan_clientId) throws Exception {
		LoanClientOperation lco = loanClientOperationRepository.getlocByLoan_Client(loan_clientId);
		return lco;
	}
	
	@ExceptionHandler
	public void DeleteLCOperation(Long id) throws Exception {
		loanClientOperationRepository.deleteById(id);
	}		
	
}
