package com.devsuperior.bootcamp.trabcap1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bootcamp.trabcap1.dto.ClientDTO;
import com.devsuperior.bootcamp.trabcap1.entities.Client;
import com.devsuperior.bootcamp.trabcap1.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(cli -> new ClientDTO(cli));
	}
	
}
