package com.SelfCare.SelfCare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SelfCare.SelfCare.entity.Client;
import com.SelfCare.SelfCare.repository.ClientRepositoryI;

@Service
public class ClientService {
	
	@Autowired
	ClientRepositoryI clientRepositoryI;
	
	public ClientService(ClientRepositoryI clientRepositoryI) {
		this.clientRepositoryI=clientRepositoryI;
	}
	
	public Client validateCodeClient(String code) throws Exception {
		try {
			Client client= clientRepositoryI.getbyCodeClient(code);		
			return client;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
}
