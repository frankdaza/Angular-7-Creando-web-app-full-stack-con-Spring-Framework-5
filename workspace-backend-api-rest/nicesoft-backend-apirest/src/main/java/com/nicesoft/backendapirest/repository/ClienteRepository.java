package com.nicesoft.backendapirest.repository;

import org.springframework.data.repository.CrudRepository;

import com.nicesoft.backendapirest.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
