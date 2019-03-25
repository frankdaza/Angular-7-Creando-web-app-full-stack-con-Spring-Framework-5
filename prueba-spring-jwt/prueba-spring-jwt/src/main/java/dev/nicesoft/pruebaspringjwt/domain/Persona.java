package dev.nicesoft.pruebaspringjwt.domain;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="personas")
public class Persona implements Serializable {

	private static final long serialVersionUID = 284796237982514963L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nombres;
	
	@NotEmpty
	private String apellidos;
	
	public Persona() {
		super();
	}

	public Persona(Long id, @NotEmpty String nombres, @NotEmpty String apellidos) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
}
