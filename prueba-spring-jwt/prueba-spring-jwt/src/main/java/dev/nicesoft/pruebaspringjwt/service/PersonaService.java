package dev.nicesoft.pruebaspringjwt.service;

import java.util.List;
import java.util.Optional;

import dev.nicesoft.pruebaspringjwt.domain.Persona;

public interface PersonaService {
	
	public Persona crearActualizar(Persona persona) throws Exception;
	
	public List<Persona> listarPersonas() throws Exception;
	
	public Optional<Persona> listarPersonaPorId(Long id) throws Exception;
	
	public void eliminarPersona(Long id) throws Exception;

}
