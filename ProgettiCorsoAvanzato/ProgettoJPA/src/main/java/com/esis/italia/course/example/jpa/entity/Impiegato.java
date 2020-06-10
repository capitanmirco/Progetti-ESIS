package com.esis.italia.course.example.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the impiegato database table.
 *
 */
@Entity
@NamedQuery(name="Impiegato.findAll", query="SELECT i FROM Impiegato i")
public class Impiegato implements  GenericEntity<ImpiegatoPK>{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ImpiegatoPK id;

	private String citta;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nascita")
	private Date dataNascita;

	private String indirizzo;

	@Column(name="titolo_studio")
	private String titoloStudio;

	@OneToMany
	@JoinColumns({
        @JoinColumn(name="codice_fiscale", referencedColumnName="codice_fiscale"),
        @JoinColumn(name="nome", referencedColumnName="nome"),
        @JoinColumn(name="cognome", referencedColumnName="cognome")
    })
	private List<Mansione> mansiones;

	public Impiegato() {
	}
	
	public interface GenericEntity<ID>{
		ID getID();
	}

	public ImpiegatoPK getId() {
		return this.id;
	}

	public void setId(ImpiegatoPK id) {
		this.id = id;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTitoloStudio() {
		return this.titoloStudio;
	}

	public void setTitoloStudio(String titoloStudio) {
		this.titoloStudio = titoloStudio;
	}

	@Override
	public ImpiegatoPK getID() {
		return this.id;
	}

}