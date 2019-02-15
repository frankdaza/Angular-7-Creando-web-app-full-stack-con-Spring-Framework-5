package com.nicesoft.backendapirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicesoft.backendapirest.entity.Cliente;
import com.nicesoft.backendapirest.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) this.clienteRepository.findAll();
	}

}
