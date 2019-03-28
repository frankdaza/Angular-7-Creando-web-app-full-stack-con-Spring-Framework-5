package dev.nicesoft.pruebaspringjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.nicesoft.pruebaspringjwt.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Usuario findByUsername(String username);

}
