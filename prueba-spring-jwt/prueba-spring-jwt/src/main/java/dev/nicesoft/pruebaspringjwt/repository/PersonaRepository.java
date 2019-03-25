package dev.nicesoft.pruebaspringjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.nicesoft.pruebaspringjwt.domain.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
