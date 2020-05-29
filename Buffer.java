package it.corso.java;

import java.util.LinkedList;

public class Buffer<E> {

	private LinkedList<E> coda;
	private  int capacità = 10;

	public Buffer(int capacità) {
		this.capacità = capacità;
		coda = new LinkedList<E>();
	}

	public synchronized boolean isEmpty() {
		return (coda.size() == 0);
	}

	public synchronized boolean isFull() {
		return (coda.size() >= capacità);
	}

	public synchronized void aggiungi(E elem) {
		while (isFull()) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}

		coda.addLast(elem);

		notifyAll();
	}

	public synchronized E preleva() {
		while (isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}

		notifyAll();

		return (coda.removeFirst());

	}

}
