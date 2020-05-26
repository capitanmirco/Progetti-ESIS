package it.corso.java;

public abstract class Poligono implements FiguraGeometrica{
	protected double base;
	protected double altezza;
	
	public Poligono(double base, double altezza) {
		super();
		this.base = base;
		this.altezza = altezza;
	}
}
