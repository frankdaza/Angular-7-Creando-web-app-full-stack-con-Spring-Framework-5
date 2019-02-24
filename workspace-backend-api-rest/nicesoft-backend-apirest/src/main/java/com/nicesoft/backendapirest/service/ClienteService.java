package com.nicesoft.backendapirest.service;

import java.util.List;

import com.nicesoft.backendapirest.entity.Cliente;

public interface ClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void deleteCliente(Long id);

}
