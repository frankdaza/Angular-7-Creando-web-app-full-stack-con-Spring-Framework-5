package com.nicesoft.backendapirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nicesoft.backendapirest.entity.Cliente;
import com.nicesoft.backendapirest.entity.Region;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("from Region")
	public List<Region> findAllRegiones();

}
