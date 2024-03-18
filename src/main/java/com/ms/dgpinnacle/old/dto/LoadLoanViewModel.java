package com.ms.dgpinnacle.old.dto;

import java.util.ArrayList;

import com.ms.dgpinnacle.entity.Client;
import com.ms.dgpinnacle.entity.LetterConfig;
import com.ms.dgpinnacle.entity.Realtor;

public class LoadLoanViewModel {
	
	//private java.util.List<Client> clientList = new ArrayList<Client>();
	Client loadedClient;
	Client loadedCoClient;
	
	private java.util.List<Realtor> realtorList = new ArrayList<Realtor>();
	
	//private Long idClient;
	
	//private String clientName;
	
	private Long idRealtor;
	
	private LetterConfig letter;
	
	//private String clientsids = "";
	
	//constructor general
	public LoadLoanViewModel(Client loadClient,java.util.List<Client> clientList, java.util.List<Realtor> realtorList,
		Long idRealtor, LetterConfig letter) {
		super();
		//this.clientList = clientList;
		this.realtorList = realtorList;
		//this.idClient = idClient;
		this.idRealtor = idRealtor;
		this.letter = letter;
		//this.clientName = clientName;
	}
	
	//constructor vacio
	public LoadLoanViewModel() {
	}


	public java.util.List<Realtor> getRealtorList() {
		return realtorList;
	}

	public void setRealtorList(java.util.List<Realtor> realtorList) {
		this.realtorList = realtorList;
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

	public Client getLoadedClient() {
		return loadedClient;
	}

	public void setLoadedClient(Client loadClient) {
		this.loadedClient = loadClient;
	}
/*
	public java.util.List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(java.util.List<Client> clientList) {
		this.clientList = clientList;
	} */

	public Client getLoadedCoClient() {
		return loadedCoClient;
	}

	public void setLoadedCoClient(Client loadedCoClient) {
		this.loadedCoClient = loadedCoClient;
	}
    	
	
}
