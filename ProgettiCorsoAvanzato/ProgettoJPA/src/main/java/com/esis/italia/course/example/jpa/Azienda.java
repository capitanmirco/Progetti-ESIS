package com.esis.italia.course.example.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the azienda database table.
 * 
 */
@Entity
@NamedQuery(name="Azienda.findAll", query="SELECT a FROM Azienda a")
public class Azienda implements GenericEntity<Integer>{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_azienda")
	private Integer idAzienda;

	private String descrizione;

	private String nome;

	//bi-directional many-to-one association to Dipartimento
	@OneToMany(mappedBy="azienda")
	private List<Dipartimento> dipartimentos;

	public Azienda() {
	}

	public Integer getIdAzienda() {
		return this.idAzienda;
	}

	public void setIdAzienda(Integer idAzienda) {
		this.idAzienda = idAzienda;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Dipartimento> getDipartimentos() {
		return this.dipartimentos;
	}

	public void setDipartimentos(List<Dipartimento> dipartimentos) {
		this.dipartimentos = dipartimentos;
	}

	public Dipartimento addDipartimento(Dipartimento dipartimento) {
		getDipartimentos().add(dipartimento);
		dipartimento.setAzienda(this);

		return dipartimento;
	}

	public Dipartimento removeDipartimento(Dipartimento dipartimento) {
		getDipartimentos().remove(dipartimento);
		dipartimento.setAzienda(null);

		return dipartimento;
	}

	@Override
	public Integer getID() {
		return this.idAzienda;
	}

}