package com.esis.italia.course.example.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ruoli database table.
 * 
 */
@Entity
@NamedQuery(name="Ruoli.findAll", query="SELECT r FROM Ruoli r")
public class Ruoli implements Serializable {
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

}