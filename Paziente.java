package it.corso.java;

public class Paziente {

	private String nome;
	private String cognome;

	public Paziente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return "Paziente [nome=" + nome + ", cognome=" + cognome + "]";
	}

	

}
