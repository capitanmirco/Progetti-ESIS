package it.corso.java;

public class Rettangolo extends Poligono {

	
	

	
	public Rettangolo(double base, double altezza) {
		super(base, altezza);
		
	}
	@Override
	public double getArea() {
		return this.altezza*this.base;
	}
}
