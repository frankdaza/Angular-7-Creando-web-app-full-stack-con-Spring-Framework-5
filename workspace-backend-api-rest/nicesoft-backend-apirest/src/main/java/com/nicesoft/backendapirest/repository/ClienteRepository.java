package com.nicesoft.backendapirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicesoft.backendapirest.entity.Cliente;
import com.nicesoft.backendapirest.entity.Region;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	public List<Region> findRegions();

}
