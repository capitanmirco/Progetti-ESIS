package com.esis.italia.course.example.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the mansione database table.
 *
 */
@Entity
@NamedQuery(name="Mansione.findAll", query="SELECT m FROM Mansione m")
@SequenceGenerator(name="seq_mansione", initialValue=1, allocationSize=1)
public class Mansione implements GenericEntity<Integer> {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_mansione")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "seq_mansione")
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


	@Override
	public Integer getPrimaryKey() {
		// TODO Auto-generated method stub
		return this.idMansione;
	}



}