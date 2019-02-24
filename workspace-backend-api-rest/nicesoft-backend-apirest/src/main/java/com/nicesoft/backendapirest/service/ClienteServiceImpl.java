package com.nicesoft.backendapirest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	
	/**
	 * (non-Javadoc)
	 * @see com.nicesoft.backendapirest.service.ClienteService#findAll()
	 */
	@Override
	public List<Cliente> findAll() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			clientes = (List<Cliente>) this.clienteRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}

	/**
	 * (non-Javadoc)
	 * @see com.nicesoft.backendapirest.service.ClienteService#findById(java.lang.Long)
	 */
	@Override
	public Cliente findById(Long id) {
		try {
			return this.clienteRepository.findById(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * (non-Javadoc)
	 * @see com.nicesoft.backendapirest.service.ClienteService#save(com.nicesoft.backendapirest.entity.Cliente)
	 */
	@Override
	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	/**
	 * (non-Javadoc)
	 * @see com.nicesoft.backendapirest.service.ClienteService#deleteCliente(java.lang.Long)
	 */
	@Override
	public void deleteCliente(Long id) {
		try {
			this.clienteRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * (non-Javadoc)
	 * @see com.nicesoft.backendapirest.service.ClienteService#findAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		return this.clienteRepository.findAll(pageable);
	}

}
