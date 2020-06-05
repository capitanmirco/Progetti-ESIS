package com.esis.italia.course.example.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dipartimento database table.
 * 
 */
@Entity
@NamedQuery(name="Dipartimento.findAll", query="SELECT d FROM Dipartimento d")
public class Dipartimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_dipartimento")
	private Integer idDipartimento;

	private String descrizione;

	@Column(name="id_mansione")
	private Integer idMansione;

	private String nome;

	//bi-directional many-to-one association to Azienda
	@ManyToOne
	@JoinColumn(name="id_azienda")
	private Azienda azienda;

	public Dipartimento() {
	}

	public Integer getIdDipartimento() {
		return this.idDipartimento;
	}

	public void setIdDipartimento(Integer idDipartimento) {
		this.idDipartimento = idDipartimento;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getIdMansione() {
		return this.idMansione;
	}

	public void setIdMansione(Integer idMansione) {
		this.idMansione = idMansione;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Azienda getAzienda() {
		return this.azienda;
	}

	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}

}