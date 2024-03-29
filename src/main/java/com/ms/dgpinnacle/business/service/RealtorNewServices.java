package com.ms.dgpinnacle.business.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_REALTOR_DUPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.ms.dgpinnacle.business.dto.EnCompassRealtorDto;
import com.ms.dgpinnacle.business.dto.LetterConfigDto;
import com.ms.dgpinnacle.business.dto.RealtorDto;
import com.ms.dgpinnacle.business.dto.RealtorOperationDto;
import com.ms.dgpinnacle.business.entity.BrokerCompany;
import com.ms.dgpinnacle.business.entity.Operation;
import com.ms.dgpinnacle.business.entity.Profile;
import com.ms.dgpinnacle.business.entity.Realtor;
import com.ms.dgpinnacle.business.entity.RealtorOperation;
import com.ms.dgpinnacle.business.entity.Users;
import com.ms.dgpinnacle.business.repository.BrokerCompanyRepository;
import com.ms.dgpinnacle.business.repository.RealtorRepository;
import com.ms.dgpinnacle.security.repository.IProfileRepository;
import com.ms.dgpinnacle.security.repository.IUserRepository;
import com.ms.dgpinnacle.security.token.UserPrincipal;
import com.ms.dgpinnacle.utils.Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RealtorNewServices {

	private final RealtorRepository realtorRepository;
	private final BrokerCompanyRepository brokerCompanyRepository;
	private final IProfileRepository profileRepository;
	private final IUserRepository userRepository;

	public List<RealtorOperationDto> findAllRealtorList(UserPrincipal token) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<RealtorOperationDto> result = realtorRepository.findAllRealtorList();
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

	public ArrayList<RealtorOperation> getRealtorOperationList(LetterConfigDto request, Operation operation) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		ArrayList<RealtorOperation> realtors = new ArrayList<>();
		for (RealtorOperationDto item : request.getRealtors()) {
			Realtor r = realtorRepository.findById(item.getId()).orElse(null);
			RealtorOperation ro = new RealtorOperation();
			ro.setOperation(operation);
			ro.setRealtor(r);
			realtors.add(ro);
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return realtors;
	}

	public ArrayList<RealtorOperation> getRealtorOperationList(List<Realtor> realtors, Operation operation) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		ArrayList<RealtorOperation> list = new ArrayList<>();
		for (Realtor item : realtors) {
			RealtorOperation ro = new RealtorOperation();
			ro.setOperation(operation);
			ro.setRealtor(item);
			list.add(ro);
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return list;
	}

	public List<Realtor> getRealtorOrSave(UserPrincipal token, List<EnCompassRealtorDto> realtors) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<Realtor> list = new ArrayList<>();
		Profile profile = profileRepository.findById(4l).orElse(null);
		// verifico que los realtors existan en caso que no creo el objeto
		for (EnCompassRealtorDto item : realtors) {
			Realtor x = realtorRepository.findByEmailOrCellphone(item.getEmail(), item.getCellphone());

			if (Objects.isNull(x)) {
				x = new Realtor();
				x.setFullName(item.getFullName());
				x.setMail(item.getEmail());
				x.setSocialSecurityNumber("-");
				x.setProfile(profile);
				x.setUsername(item.getEmail());
				// buscar forma de cambiar esta passs
				x.setPass("$2a$10$Ood6ka2EnrwXrd4XqF4DUeMZghaFw6va.wnO1noxkIglFCVcyUWJm");
				x.setBusinessPosition("REALTOR");
			}
			// datos del realtor
			x.setCellphone(item.getCellphone());
			x.setEmail(item.getEmail());
			x.setLastName(item.getFullName());
			x.setName(item.getFullName());
			x.setMailingAdd(item.getMailingAdd());
			x.setLicenseNumber(item.getLicenseNumber());
			x.setNotes("Realtor: " + item.getFullName() + " LicenseNumber: " + item.getLicenseNumber());

			list.add(x);
		}
		realtorRepository.saveAll(list);

		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return list;
	}

	// CRUD
	public List<RealtorDto> getRealtorList() {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<RealtorDto> result = realtorRepository.getRealtorList();
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

	public Boolean save(RealtorDto realtor) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		Realtor modelOp = realtorRepository.findByEmailOrCellphone(realtor.getEmail(), realtor.getCellphone());

		if ((Objects.nonNull(modelOp) && Objects.isNull(realtor.getId()))
				|| Objects.nonNull(modelOp) && !realtor.getId().equals(modelOp.getId()))
			throw new Exception(MSG_REALTOR_DUPL);

		Realtor model = new Realtor();

		BrokerCompany broker = Objects.nonNull(realtor.getBrokerCompanyId())
				? Utils.validateOpt(brokerCompanyRepository.findById(realtor.getBrokerCompanyId()))
				: null;
		Profile profile = Utils.validateOpt(profileRepository.findById(4l));

		if (Objects.nonNull(realtor.getId())) {
			Users user = Utils.validateOpt(userRepository.findById(realtor.getId()));

			model.setId(realtor.getId());
			model.setFullName(user.getFullName());
			model.setMail(user.getMail());
			model.setSocialSecurityNumber(user.getSocialSecurityNumber());
			model.setProfile(user.getProfile());
			model.setUsername(user.getUsername());
			model.setPass(user.getPass());
			model.setBusinessPosition(user.getBusinessPosition());
		} else {
			//
			model.setFullName(realtor.getName() + " " + realtor.getLastName());
			model.setMail(realtor.getEmail());
			model.setSocialSecurityNumber("-");
			model.setProfile(profile);
			model.setUsername(realtor.getEmail());
			// buscar forma de cambiar esta passs
			model.setPass("$2a$10$Ood6ka2EnrwXrd4XqF4DUeMZghaFw6va.wnO1noxkIglFCVcyUWJm");
			model.setBusinessPosition("REALTOR");
		}
		model.setBrokerCompany(broker);
		model.setCellphone(realtor.getCellphone());
		model.setEmail(realtor.getEmail());
		model.setLastName(realtor.getLastName());
		model.setLicenseNumber(realtor.getLicenseNumber());
		model.setMailingAdd(realtor.getMailingAdd());
		model.setName(realtor.getName());
		model.setNotes(realtor.getNotes());

		realtorRepository.save(model);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return Boolean.TRUE;
	}

	public boolean delete(RealtorDto dto) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		realtorRepository.deleteById(dto.getId());
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return Boolean.TRUE;
	}
}
