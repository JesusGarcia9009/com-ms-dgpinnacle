package com.ms.dgpinnacle.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_CLIENT_DUPL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ms.dgpinnacle.dto.ClientDto;
import com.ms.dgpinnacle.dto.EnCompassClientDto;
import com.ms.dgpinnacle.dto.EnCompassLetterConfigDto;
import com.ms.dgpinnacle.dto.LetterConfigDto;
import com.ms.dgpinnacle.entity.Client;
import com.ms.dgpinnacle.entity.ClientOperation;
import com.ms.dgpinnacle.entity.Operation;
import com.ms.dgpinnacle.entity.Profile;
import com.ms.dgpinnacle.repository.ClientRepository;
import com.ms.dgpinnacle.repository.ProfileRepository;
import com.ms.dgpinnacle.token.UserPrincipal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientServices {

	private final PasswordEncoder passwordEncoder;
	private final ClientRepository clientRepository;
	private final LoanOfficerServices loanOfficerServices;
	private final ProfileRepository profileRepository;

	public List<ClientDto> findAllClientList(UserPrincipal token) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<ClientDto> result = clientRepository.findAllClientList();
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}
	
	public ClientDto getClientById(Long id) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		ClientDto result = clientRepository.getClientById(id);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return result;
	}

	public ArrayList<ClientOperation> getClientOperationList(LetterConfigDto request, Operation operation) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		ArrayList<ClientOperation> clients = new ArrayList<>();
		for (ClientDto item : request.getClients()) {
			Client c = clientRepository.findById(item.getId()).orElse(null);
			ClientOperation co = new ClientOperation();
			co.setOperation(operation);
			co.setClient(c);
			clients.add(co);
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return clients;
	}

	public ArrayList<ClientOperation> getClientOperationList(List<Client> clients, Operation operation) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		ArrayList<ClientOperation> list = new ArrayList<>();
		for (Client item : clients) {
			ClientOperation co = new ClientOperation();
			co.setOperation(operation);
			co.setClient(item);
			list.add(co);
		}
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return list;
	}

	public List<Client> getClientOrSave(EnCompassLetterConfigDto request, UserPrincipal token) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<Client> clientList = new ArrayList<>();
		Profile profile = profileRepository.findByProfileCode("CLIENT");
		// verifico que los clientes existan en caso que no creo
		for (EnCompassClientDto item : request.getClients()) {
			Client x = clientRepository.findByEmailOrCellphone(item.getEmail(), item.getCellphone());

			if (Objects.isNull(x)) {
				x = new Client();
				x.setName(item.getName());
				x.setLastName(item.getLastName());
				x.setEmail(item.getEmail());
				x.setCellphone(item.getCellphone());
				x.setUsername(item.getEmail().substring(0, item.getEmail().indexOf("@")));
				x.setPass(passwordEncoder.encode(item.getName().toLowerCase()));
				x.setMailingAdd(item.getMailingAdd());
				
				x.setUpdateDate(new Date());
				x.setUpdateUser(token.getEmail());
				
				x.setProfile(profile);
			}
			clientList.add(x);
		}
		clientRepository.saveAll(clientList);
		loanOfficerServices.associateMyClients(request.getLoanOfficer(), clientList);

		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return clientList;
	}

	public Boolean save(ClientDto client, UserPrincipal token) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		Client modelOp = clientRepository.findByEmailOrCellphone(client.getEmail(), client.getCellphone());

		if ((Objects.nonNull(modelOp) && Objects.isNull(client.getId()))
				|| Objects.nonNull(modelOp) && !client.getId().equals(modelOp.getId()))
			throw new Exception(MSG_CLIENT_DUPL);
		
		Profile profile = profileRepository.findByProfileCode(client.getProfileCode());

		Client model = new Client();

		if (Objects.nonNull(client.getId()))
			model.setId(client.getId());

		model.setName(client.getName());
		model.setLastName(client.getLastName());
		model.setEmail(client.getEmail());
		model.setCellphone(client.getCellphone());
		model.setUsername(client.getEmail().substring(0, client.getEmail().indexOf("@")));
		model.setPass(passwordEncoder.encode(client.getPassword()));
		model.setMailingAdd(client.getMailingAdd());
		model.setUpdateDate(new Date());
		model.setUpdateUser(token.getEmail());
		
		model.setProfile(profile);

		clientRepository.save(model);
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return true;
	}

	public boolean delete(ClientDto dto) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		clientRepository.deleteById(dto.getId());
		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return true;
	}

}
