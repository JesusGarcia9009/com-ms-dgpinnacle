package com.ms.dgpinnacle.business.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_LOAN_NOT_EXIST_DUPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.ms.dgpinnacle.business.dto.EnCompassLoanOfficerDto;
import com.ms.dgpinnacle.business.entity.Client;
import com.ms.dgpinnacle.business.entity.LoanClient;
import com.ms.dgpinnacle.business.entity.LoanOfficer;
import com.ms.dgpinnacle.business.repository.LoanClientRepository;
import com.ms.dgpinnacle.business.repository.LoanOfficerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
public class LoanOfficerNewServices {

	
	private final LoanOfficerRepository loanOfficerRepository;
	private final LoanClientRepository loanClientRepository;
	

	public void associateMyClients(EnCompassLoanOfficerDto loanOfficer, List<Client> clientList) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		LoanOfficer lo = loanOfficerRepository.findByEmailOrCellphoneIgnoreCase(loanOfficer.getEmail(), loanOfficer.getCellphone());
		
		if (Objects.isNull(lo)) {
			throw new Exception(MSG_LOAN_NOT_EXIST_DUPL);
		}else {
			List<LoanClient> lc = new ArrayList<>();
			for (Client client : clientList) {
				//verificar que el cliente ya  no tiene asociado el loan
				if(loanClientRepository.findByLoanAndClientIds(lo.getId(), client.getId()) == 0) {
					LoanClient x = new LoanClient();
					x.setLoanOfficer(lo);
					x.setClient(client);
					lc.add(x);
				}
			}
			loanClientRepository.saveAll(lc);
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
	}
	
}
