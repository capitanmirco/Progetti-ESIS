package com.esis.italia.course.example.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the impiegato database table.
 * 
 */
@Embeddable
public class ImpiegatoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="codice_fiscale")
	private String codiceFiscale;

	private String nome;

	private String cognome;

	public ImpiegatoPK() {
	}
	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return this.cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ImpiegatoPK)) {
			return false;
		}
		ImpiegatoPK castOther = (ImpiegatoPK)other;
		return 
			this.codiceFiscale.equals(castOther.codiceFiscale)
			&& this.nome.equals(castOther.nome)
			&& this.cognome.equals(castOther.cognome);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.codiceFiscale.hashCode();
		hash = hash * prime + this.nome.hashCode();
		hash = hash * prime + this.cognome.hashCode();
		
		return hash;
	}
}