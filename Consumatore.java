package it.corso.java;



public class Consumatore implements Runnable {

	private Buffer<Paziente> buffer;
	private int ritardo;

	public Consumatore(Buffer<Paziente> buffer, int ritardo) {
		this.ritardo = ritardo;
		this.buffer = buffer;
	}

	
	public void run() {

		int i;

		while (true) {
			Paziente p = buffer.preleva();
			System.out.println("Prelevato: " + p + "\n");

			try {
				Thread.sleep(ritardo);
			} catch (InterruptedException e) {
			}

		}

	}

}
