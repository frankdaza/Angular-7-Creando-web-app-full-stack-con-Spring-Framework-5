package com.nicesoft.backendapirest.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regiones")
public class Region implements Serializable {

	private static final long serialVersionUID = -7421853828647112139L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-03-17
	 */
	public Region() {		
	}
	
	/**
	 * @author Frank Edward Daza González
	 * @version 2019-03-17
	 * @param id
	 * @param nombre
	 */
	public Region(Long id, String nombre) {		
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-03-17
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-03-17
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-03-17
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-03-17
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
