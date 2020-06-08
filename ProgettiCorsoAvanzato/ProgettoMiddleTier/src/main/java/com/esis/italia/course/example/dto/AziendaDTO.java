package com.esis.italia.course.example.dto;

public class AziendaDTO extends AbstractDTO {
	
	private static final long serialVersionUID = -3368807584818136195L;
	private String nome;
	private String descrizione;
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}