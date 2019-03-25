package dev.nicesoft.pruebaspringjwt.service;

import java.util.List;

import dev.nicesoft.pruebaspringjwt.domain.Persona;

public interface PersonaService {
	
	public Persona crearPersona(String nombres, String apellidos) throws Exception;
	
	public List<Persona> listarPersonas() throws Exception;
	
	public Persona listarPersonaPorId(Long id) throws Exception;
	
	public Persona actualizarPersona(Long id, String nombres, String apellidos) throws Exception;
	
	public void eliminarPersona(Long id) throws Exception;

}
