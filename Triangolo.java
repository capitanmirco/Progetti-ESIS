package it.corso.java;

public class Triangolo extends Poligono  {
	
	
	public Triangolo(double base,double altezza) {
		super(base, altezza);
	}
	
	@Override
	public double getArea() {
		return (this.altezza*this.base)/2;
	}
	
	
}
