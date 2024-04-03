package com.ms.dgpinnacle.business.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_REALTOR_DUPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.ms.dgpinnacle.business.repository.BrokerCompanyRepository;
import com.ms.dgpinnacle.business.repository.ProfileRepository;
import com.ms.dgpinnacle.business.repository.RealtorRepository;
import com.ms.dgpinnacle.token.UserPrincipal;
import com.ms.dgpinnacle.utils.Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RealtorServices {

	private final RealtorRepository realtorRepository;
	private final BrokerCompanyRepository brokerCompanyRepository;
	private final ProfileRepository profileRepository;
	private final PasswordEncoder passwordEncoder;

	// CRUD
	public RealtorDto getRealtorById(Long id) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		RealtorDto result = realtorRepository.getRealtorById(id);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

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

		BrokerCompany broker = Objects.nonNull(realtor.getBrokerCompanyId())
				? Utils.validateOpt(brokerCompanyRepository.findById(realtor.getBrokerCompanyId()))
				: null;
		Profile profile = profileRepository.findByProfileCode(realtor.getProfileCode());

		Realtor model = new Realtor();

		if (Objects.nonNull(realtor.getId()))
			model.setId(realtor.getId());

		model.setName(realtor.getName());
		model.setLastName(realtor.getLastName());
		model.setEmail(realtor.getEmail());
		model.setCellphone(realtor.getCellphone());
		model.setUsername(realtor.getEmail().substring(0, realtor.getEmail().indexOf("@")));
		model.setPass(passwordEncoder.encode(realtor.getPassword()));
		model.setMailingAdd(realtor.getMailingAdd());

		model.setLicenseNumber(realtor.getLicenseNumber());
		model.setNotes(realtor.getNotes());

		model.setProfile(profile);
		model.setBrokerCompany(broker);
		
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

	// aditional methods
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
		Profile profile = profileRepository.findByProfileCode("REALTOR");
		// verifico que los realtors existan en caso que no creo el objeto
		for (EnCompassRealtorDto item : realtors) {
			Realtor model = new Realtor();
			Realtor realtor = realtorRepository.findByEmailOrCellphone(item.getEmail(), item.getCellphone());

			if (Objects.nonNull(realtor))
				model.setId(realtor.getId());

			model.setName(item.getFullName().substring(0, item.getFullName().indexOf(" ")));
			model.setLastName(item.getFullName().substring(item.getFullName().indexOf(" "), item.getFullName().length()));
			model.setEmail(item.getEmail());
			model.setCellphone(item.getCellphone());
			model.setUsername(item.getEmail().substring(0, item.getEmail().indexOf("@")));
			model.setPass(passwordEncoder.encode(item.getFullName()));
			model.setMailingAdd(item.getMailingAdd());

			model.setLicenseNumber(item.getLicenseNumber());
			model.setNotes("Realtor: " + item.getFullName() + " LicenseNumber: " + item.getLicenseNumber());

			model.setProfile(profile);
			model.setBrokerCompany(null);

			list.add(model);

		}
		realtorRepository.saveAll(list);

		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return list;
	}
}
