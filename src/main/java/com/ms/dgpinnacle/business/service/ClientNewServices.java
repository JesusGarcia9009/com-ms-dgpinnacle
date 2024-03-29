package com.ms.dgpinnacle.business.service;

import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_END;
import static com.ms.dgpinnacle.utils.ConstantUtil.LOG_START;
import static com.ms.dgpinnacle.utils.ConstantUtil.MSG_CLIENT_DUPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.ms.dgpinnacle.business.dto.ClientDto;
import com.ms.dgpinnacle.business.dto.EnCompassClientDto;
import com.ms.dgpinnacle.business.dto.EnCompassLetterConfigDto;
import com.ms.dgpinnacle.business.dto.LetterConfigDto;
import com.ms.dgpinnacle.business.entity.Client;
import com.ms.dgpinnacle.business.entity.ClientOperation;
import com.ms.dgpinnacle.business.entity.Operation;
import com.ms.dgpinnacle.business.repository.ClientRepository;
import com.ms.dgpinnacle.security.token.UserPrincipal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientNewServices {

	private final ClientRepository clientRepository;
	private final LoanOfficerNewServices loanOfficerServices;

	public List<ClientDto> findAllClientList(UserPrincipal token) {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<ClientDto> result = clientRepository.findAllClientList();
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

	public List<Client> getClientOrSave(EnCompassLetterConfigDto request) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		List<Client> clientList = new ArrayList<>();
		// verifico que los clientes existan en caso que no creo
		for (EnCompassClientDto item : request.getClients()) {
			Client x = clientRepository.findByEmailOrCellphone(item.getEmail(), item.getCellphone());

			if (Objects.isNull(x)) {
				x = new Client();
				x.setCellphone(item.getCellphone());
				x.setEmail(item.getEmail());
				x.setLastName(item.getLastName());
				x.setName(item.getName());
				x.setMailingAdd(item.getMailingAdd());
			}
			clientList.add(x);
		}
		clientRepository.saveAll(clientList);
		loanOfficerServices.associateMyClients(request.getLoanOfficer(), clientList);

		log.info(String.format(LOG_END, Thread.currentThread().getStackTrace()[1].getMethodName()));
		return clientList;
	}

	public Boolean save(ClientDto client) throws Exception {
		log.info(String.format(LOG_START, Thread.currentThread().getStackTrace()[1].getMethodName()));
		Client modelOp = clientRepository.findByEmailOrCellphone(client.getEmail(), client.getCellphone());

		if ((Objects.nonNull(modelOp) && Objects.isNull(client.getId()))
				|| Objects.nonNull(modelOp) && !client.getId().equals(modelOp.getId()))
			throw new Exception(MSG_CLIENT_DUPL);

		Client model = new Client();

		if (Objects.nonNull(client.getId()))
			model.setId(client.getId());

		model.setCellphone(client.getCellphone());
		model.setEmail(client.getEmail());
		model.setLastName(client.getLastName());
		model.setMailingAdd(client.getMailingAdd());
		model.setName(client.getName());

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
