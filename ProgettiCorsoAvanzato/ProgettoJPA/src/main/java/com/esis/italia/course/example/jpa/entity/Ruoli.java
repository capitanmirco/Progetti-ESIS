package com.esis.italia.course.example.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name="Ruoli.findAll", query="SELECT r FROM Ruoli r")
public class Ruoli implements GenericEntity<String>{
	private static final long serialVersionUID = 1L;

	@Id
	private String nome;

	private String descrizione;

	public Ruoli() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String getID() {
		return this.nome;
	}

}