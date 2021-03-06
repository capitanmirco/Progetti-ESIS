package com.esis.italia.course.example.dto;

public class DipartimentoDTO extends AbstractDTO {
	/**
	 *
	 */
	private static final long serialVersionUID = -3368806039818136195L;
	private String nome;
	private String descrizione;
	private AziendaDTO azienda; 
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public AziendaDTO setAzienda(AziendaDTO a) {
		return a; 
		
	}

}
