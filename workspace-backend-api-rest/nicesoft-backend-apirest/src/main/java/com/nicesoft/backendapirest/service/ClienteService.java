package com.nicesoft.backendapirest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nicesoft.backendapirest.entity.Cliente;
import com.nicesoft.backendapirest.entity.Region;

public interface ClienteService {
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void deleteCliente(Long id);
	
	public List<Region> findAllRegiones();

}
