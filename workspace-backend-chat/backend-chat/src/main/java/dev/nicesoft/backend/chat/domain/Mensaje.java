package dev.nicesoft.backend.chat.domain;

import java.io.Serializable;

public class Mensaje implements Serializable {

	private static final long serialVersionUID = -2205302006936226735L;
	
	private String texto;
	private Long fecha;
	
	public Mensaje() {
		super();
	}
	
	public Mensaje(String texto, Long fecha) {
		this.texto = texto;
		this.fecha = fecha;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getFecha() {
		return fecha;
	}

	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}
	
}
