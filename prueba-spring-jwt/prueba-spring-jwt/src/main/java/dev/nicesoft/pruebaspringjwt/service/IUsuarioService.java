package dev.nicesoft.pruebaspringjwt.service;

import dev.nicesoft.pruebaspringjwt.domain.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);

}
