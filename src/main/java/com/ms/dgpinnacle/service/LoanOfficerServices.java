package com.ms.dgpinnacle.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_LOAN_DUPL;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_LOAN_NOT_EXIST_DUPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ms.dgpinnacle.dto.EnCompassLoanOfficerDto;
import com.ms.dgpinnacle.dto.LoanOfficerDto;
import com.ms.dgpinnacle.entity.Client;
import com.ms.dgpinnacle.entity.LoanClient;
import com.ms.dgpinnacle.entity.LoanOfficer;
import com.ms.dgpinnacle.entity.Profile;
import com.ms.dgpinnacle.repository.LoanClientRepository;
import com.ms.dgpinnacle.repository.LoanOfficerRepository;
import com.ms.dgpinnacle.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
public class LoanOfficerServices {

	
	private final LoanOfficerRepository loanOfficerRepository;
	private final LoanClientRepository loanClientRepository;
	private final ProfileRepository profileRepository;
	private final PasswordEncoder passwordEncoder;
	

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
	
	public LoanOfficerDto getLoanById(Long id) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		LoanOfficerDto result = loanOfficerRepository.getLoanById(id);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}
	
	public Boolean save(LoanOfficerDto request) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		LoanOfficer modelOp = loanOfficerRepository.findByEmailOrCellphone(request.getEmail(), request.getCellphone());

		if ((Objects.nonNull(modelOp) && Objects.isNull(request.getId()))
				|| Objects.nonNull(modelOp) && !request.getId().equals(modelOp.getId()))
			throw new Exception(MSG_LOAN_DUPL);

		Profile profile = profileRepository.findByProfileCode(request.getProfileCode());
		
		LoanOfficer model = new LoanOfficer();

		if (Objects.nonNull(request.getId()))
			model.setId(request.getId());
			
		model.setName(request.getName());
		model.setLastName(request.getLastName());
		model.setEmail(request.getEmail());
		model.setCellphone(request.getCellphone());
		model.setUsername(request.getEmail().substring(0, request.getEmail().indexOf("@")));
		model.setPass(passwordEncoder.encode(request.getPassword()));
		model.setMailingAdd(request.getMailingAdd());
		
		model.setNmls(request.getNmls());
		
		model.setProfile(profile);
		
		loanOfficerRepository.save(model);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return Boolean.TRUE;
	}
	
}
