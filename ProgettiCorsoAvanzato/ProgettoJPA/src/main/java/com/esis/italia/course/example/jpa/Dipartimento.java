package com.esis.italia.course.example.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the dipartimento database table.
 *
 */
@Entity
@NamedQuery(name="Dipartimento.findAll", query="SELECT d FROM Dipartimento d")
@SequenceGenerator(name="seq_Dipartimento", initialValue=1, allocationSize=100)
public class Dipartimento implements GenericEntity<Integer>{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_dipartimento")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "seq_Dipartimento")
	private Integer idDipartimento;

	@Column(name="id_mansione")
	private Integer idMansione;
	
	@Column(name="nome", insertable = false, updatable = false)
	private String nome;
	
	@Column(name="nome_dipartimento", updatable = false)
	private String nomeDipartimento;
	
	private String descrizione;
	
	//bi-directional many-to-one association to Azienda
	@ManyToOne
	@JoinColumns({
        @JoinColumn(name="partitaIva", referencedColumnName="partita_iva"),
        @JoinColumn(name="nome", referencedColumnName="nome")
    })
	private Azienda azienda;

	public Dipartimento() {
	}
	
	public String getNomeDipartimento() {
		return nomeDipartimento;
	}



	public void setNomeDipartimento(String nomeDipartimento) {
		this.nomeDipartimento = nomeDipartimento;
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


	@Override
	public Integer getID() {
		return this.idDipartimento;
	}

}