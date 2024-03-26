package com.ms.dgpinnacle.old.dto;

import java.util.ArrayList;

import com.ms.dgpinnacle.entity.Client;
import com.ms.dgpinnacle.entity.LetterConfig;
import com.ms.dgpinnacle.entity.Realtor;

public class LetterOperationViewModel {
	
	private java.util.List<Client> clientList = new ArrayList<Client>();
	
	private java.util.List<Realtor> realtorList = new ArrayList<Realtor>();
	
	private Long idClient;
	
	private String clientName;
	
	private Long idRealtor;
	
	private LetterConfig letter;
	
	private String clientsids = "";
	
	//constructor general
	public LetterOperationViewModel(java.util.List<Client> clientList, java.util.List<Realtor> realtorList,
			Long idClient, Long idRealtor, LetterConfig letter, String clientName) {
		super();
		this.clientList = clientList;
		this.realtorList = realtorList;
		this.idClient = idClient;
		this.idRealtor = idRealtor;
		this.letter = letter;
		this.clientName = clientName;
	}
	
	//constructor vacio
	public LetterOperationViewModel() {
	}
	
	

	public java.util.List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(java.util.List<Client> clientList) {
		this.clientList = clientList;
	}

	public java.util.List<Realtor> getRealtorList() {
		return realtorList;
	}

	public void setRealtorList(java.util.List<Realtor> realtorList) {
		this.realtorList = realtorList;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public Long getIdRealtor() {
		return idRealtor;
	}

	public void setIdRealtor(Long idRealtor) {
		this.idRealtor = idRealtor;
	}

	public LetterConfig getLetter() {
		return letter;
	}

	public void setLetter(LetterConfig letter) {
		this.letter = letter;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientsids() {
		return clientsids;
	}

	public void setClientsids(String clientsids) {
		this.clientsids = clientsids;
	}
	
	
	
}
