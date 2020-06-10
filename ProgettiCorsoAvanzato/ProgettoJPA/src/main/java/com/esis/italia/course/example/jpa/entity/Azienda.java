package com.esis.italia.course.example.jpa.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "azienda")
@NamedQuery(name="Azienda.findAll", query="SELECT a FROM Azienda a")
public class Azienda implements GenericEntity<AziendaPK>{
	
	private static final long serialVersionUID = 1L;
	

	private String descrizione;
	
	@EmbeddedId
	private AziendaPK id;
	
	
	public AziendaPK getId() {
		return id;
	}
	
	public void setId(AziendaPK id) {
		this.id = id;
	}


	//bi-directional many-to-one association to Dipartimento
	@OneToMany(mappedBy="azienda")
	private List<Dipartimento> dipartimentos;

	public Azienda() {
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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
	public AziendaPK getID() {
		return this.id;
	}

}