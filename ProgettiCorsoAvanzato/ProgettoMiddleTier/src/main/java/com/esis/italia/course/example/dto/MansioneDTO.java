package com.esis.italia.course.example.dto;

public class MansioneDTO extends AbstractDTO {

	private int IdMansione;
	private RuoliDTO ruoli;
	private ImpiegatoDTO impiegato;

	public ImpiegatoDTO getImpiegato() {
		return impiegato;
	}

	public void setImpiegato(ImpiegatoDTO impiegato) {
		this.impiegato = impiegato;
	}

	public int getIdMansione() {
		return IdMansione;
	}

	public void setIdMansione(int idMansione) {
		IdMansione = idMansione;
	}

	public RuoliDTO getRuoli() {
		return ruoli;
	}

	public void setRuoli(RuoliDTO ruoli) {
		this.ruoli = ruoli;
	}

}
