package dev.nicesoft.pruebaspringjwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dev.nicesoft.pruebaspringjwt.domain.Persona;
import dev.nicesoft.pruebaspringjwt.repository.PersonaRepository;

@Service
@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public Persona crearActualizar(Persona persona) throws Exception {
		return this.personaRepository.save(persona);
	}

	@Override
	public List<Persona> listarPersonas() throws Exception {
		return this.personaRepository.findAll();
	}

	@Override
	public Optional<Persona> listarPersonaPorId(Long id) throws Exception {
		return this.personaRepository.findById(id);
	}

	@Override
	public void eliminarPersona(Long id) throws Exception {
		this.personaRepository.deleteById(id);
	}

}
