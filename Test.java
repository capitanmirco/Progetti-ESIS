package it.corso.java;

public class Test {

	public static void main(String[] args) {

		Buffer<Paziente> buffer;
		Produttore prod;
		Consumatore cons;

		buffer = new Buffer<Paziente>(10);
		prod = new Produttore(buffer, 1000);
		cons = new Consumatore(buffer,2000);

		Thread consumatore = new Thread(cons);
		Thread produttore = new Thread(prod);

		produttore.start();
		consumatore.start();

	}
}
