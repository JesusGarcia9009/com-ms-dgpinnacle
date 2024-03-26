package com.ms.dgpinnacle.business.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.ms.dgpinnacle.business.dto.EnCompassRealtorDto;
import com.ms.dgpinnacle.business.dto.LetterConfigDto;
import com.ms.dgpinnacle.business.dto.RealtorDto;
import com.ms.dgpinnacle.business.entity.Operation;
import com.ms.dgpinnacle.business.entity.Profile;
import com.ms.dgpinnacle.business.entity.Realtor;
import com.ms.dgpinnacle.business.entity.RealtorOperation;
import com.ms.dgpinnacle.business.entity.Users;
import com.ms.dgpinnacle.business.repository.RealtorRepository;
import com.ms.dgpinnacle.security.repository.IProfileRepository;
import com.ms.dgpinnacle.security.service.UsersService;
import com.ms.dgpinnacle.security.token.UserPrincipal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
public class RealtorNewServices {

	
	private final RealtorRepository realtorRepository;
	private final IProfileRepository profileRepository;
	private final UsersService usersService; 
	

	public List<RealtorDto> findAllRealtorList(UserPrincipal token) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<RealtorDto> result = realtorRepository.findAllRealtorList();
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}
	
	public ArrayList<RealtorOperation> getRealtorOperationList(LetterConfigDto request, Operation operation) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		ArrayList<RealtorOperation> realtors = new ArrayList<>();
		for (RealtorDto item : request.getRealtors()) {
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
		//verifico que los realtors existan en caso que no creo el objeto
		for (EnCompassRealtorDto item : realtors) {
			Realtor x = realtorRepository.findByEmailOrCellphone(item.getEmail(), item.getCellphone());
			
			if(Objects.isNull(x)) {
				//para crear un Realtor hay que crear un usuario
				Users user = usersService.save(item);
				x = new Realtor();

				//datos de usuario
				x.setId(user.getId());
				x.setProfile(profile);
				x.setSocialSecurityNumber("");
				x.setFullNames(item.getFullName());
				x.setLastName(item.getFullName());
				x.setMail(item.getEmail());
				x.setBusinessPosition("REALTOR");
				x.setUsername(item.getEmail());
				x.setPass("12345");
		
				//datos del realtor
				x.setCellphone(item.getCellphone());
				x.setEmail(item.getEmail());
				x.setLastName(item.getFullName());
				x.setName(item.getFullName());
				x.setMailingAdd(item.getMailingAdd());
				x.setLicenseNumber(item.getLicenseNumber());
				x.setNotes("Realtor: " + item.getFullName() + " LicenseNumber: " + item.getLicenseNumber());
			}
			list.add(x);
		}
		realtorRepository.saveAll(list);

		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return list;
	}
}
