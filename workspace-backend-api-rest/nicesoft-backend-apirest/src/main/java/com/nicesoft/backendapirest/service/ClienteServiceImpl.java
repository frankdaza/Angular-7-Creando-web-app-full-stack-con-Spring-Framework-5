package com.nicesoft.backendapirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nicesoft.backendapirest.entity.Cliente;
import com.nicesoft.backendapirest.repository.ClienteRepository;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, noRollbackFor = Exception.class )
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) this.clienteRepository.findAll();
	}

	/**
	 * (non-Javadoc)
	 * @see com.nicesoft.backendapirest.service.ClienteService#findById(java.lang.Long)
	 */
	@Override
	public Cliente findById(Long id) {
		return this.clienteRepository.findById(id).orElse(null);
	}

	/**
	 * (non-Javadoc)
	 * @see com.nicesoft.backendapirest.service.ClienteService#save(com.nicesoft.backendapirest.entity.Cliente)
	 */
	@Override
	public Cliente save(Cliente cliente) {
		return this.save(cliente);
	}

	/**
	 * (non-Javadoc)
	 * @see com.nicesoft.backendapirest.service.ClienteService#deleteCliente(java.lang.Long)
	 */
	@Override
	public void deleteCliente(Long id) {
		this.clienteRepository.deleteById(id);
	}

}
