package com.esis.italia.course.example.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AziendaPK implements Serializable{
	
	private static final long serialVersionUID = -7173595970222971083L;

	private String nome;
	
	@Column(name="partita_iva")
	private String partitaIva;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getpIva() {
		return partitaIva;
	}
	public void setpIva(String pIva) {
		this.partitaIva = pIva;
	}
	
	
}
