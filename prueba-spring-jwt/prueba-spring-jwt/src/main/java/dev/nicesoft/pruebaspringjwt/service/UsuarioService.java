package dev.nicesoft.pruebaspringjwt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.nicesoft.pruebaspringjwt.domain.Usuario;
import dev.nicesoft.pruebaspringjwt.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Usuario usuario = this.usuarioRepository.findByUsername(username);
			
			if (usuario == null) {
				throw new UsernameNotFoundException("Error en el login: no existe el usuario " + username + " en el sistema!");
			}
			
			List<GrantedAuthority> authorities = 
					usuario.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getNombre()))
					.peek(authority -> log.info("Role: " + authority.getAuthority()))
					.collect(Collectors.toList());
			
			return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
		} catch (Exception e) {
			log.error(e.getMessage(), e);			
		}
		return null;
	}

}
