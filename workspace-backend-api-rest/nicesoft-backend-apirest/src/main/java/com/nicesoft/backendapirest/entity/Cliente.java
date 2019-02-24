package com.nicesoft.backendapirest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 4434335225419324051L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotEmpty
	private String email;
	
	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-02-14
	 */
	public Cliente() {
		super();
	}
	
	/**
	 * Crea la fecha antes de crear un nuevo cliente.
	 * 
	 * @author Frank Edward Daza González
	 * @version 2019-02-24
	 */
	@PrePersist
	public void setCreatedAtPrePersist() {
		this.createAt = new Date();
	}

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-02-14
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-02-14
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-02-14
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-02-14
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-02-14
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-02-14
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-02-14
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-02-14
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-02-14
	 * @return the createAt
	 */
	public Date getCreateAt() {
		return createAt;
	}

	/**
	 * @author Frank Edward Daza González
	 * @version 2019-02-14
	 * @param createAt the createAt to set
	 */
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

}
