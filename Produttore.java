package it.corso.java;



public class Produttore implements Runnable {

	private Buffer<Paziente> buffer;
	private int ritardo;

	public Produttore(Buffer<Paziente> buffer, int ritardo) {
		this.buffer = buffer;
		this.ritardo = ritardo;
	}

	

	public void run() {

		int i;

		for (i = 0; true; i++) {
			Paziente p = new Paziente("Nome " + i, "Cognome " + i);

			buffer.aggiungi(p);
			System.out.println("Inserito: " + p);

			try {
				Thread.sleep(ritardo);
			} catch (InterruptedException e) {
			}

			Thread.yield();
		}
	}

}
