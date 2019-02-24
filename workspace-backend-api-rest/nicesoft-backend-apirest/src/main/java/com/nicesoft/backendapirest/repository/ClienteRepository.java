package com.nicesoft.backendapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicesoft.backendapirest.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
