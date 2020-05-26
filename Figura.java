package it.corso.java;

public class Figura {
	public static void main(String[] args) {
		FiguraGeometrica r = new Rettangolo(8,12);
		FiguraGeometrica t = new Triangolo(3,7);
		
		
		System.out.println(r.getArea());
		System.out.println(t.getArea());
		
	}
}
