package com.esis.italia.course.example.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


/**
 * The persistent class for the mansione database table.
 *
 */
@Entity
@NamedQuery(name="Mansione.findAll", query="SELECT m FROM Mansione m")
public class Mansione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_mansione")
	private Integer idMansione;

	@ManyToOne
	@JoinColumns({
        @JoinColumn(name="codice_fiscale", referencedColumnName="codice_fiscale"),
        @JoinColumn(name="nome", referencedColumnName="nome"),
        @JoinColumn(name="cognome", referencedColumnName="cognome")
    })
	private Impiegato impiegato;

	@OneToOne
	@JoinColumn(name="nome_ruolo")
	private Ruoli ruoli;

	public Mansione() {
	}

	public Integer getIdMansione() {
		return this.idMansione;
	}

	public void setIdMansione(Integer idMansione) {
		this.idMansione = idMansione;
	}



	public Ruoli getRuoli() {
		return this.ruoli;
	}

	/**
	 * @param ruoli the ruoli to set
	 */
	public void setRuoli(Ruoli ruoli) {
		this.ruoli = ruoli;
	}
	/**
	 * @return the impiegato
	 */
	public Impiegato getImpiegato() {
		return impiegato;
	}

	/**
	 * @param impiegato the impiegato to set
	 */
	public void setImpiegato(Impiegato impiegato) {
		this.impiegato = impiegato;
	}



}