/**
 *
 */
package com.esis.italia.course.example.enumeration;

/**
 * @author Giampiero Cicala
 *
 */
public enum  HTTPMethod {
	GET("CODICE","DESCRIZIONE"),
	POST("CODICE2","DESCRIZIONE2"),
	PUT("CODICE3","DESCRIZIONE3"),
	DELETE("CODICE4","DESCRIZIONE4");

	private final String codice;
	private final String descrizione;

	private HTTPMethod(String codice,String descrizione) {
		this.codice=codice;
		this.descrizione=descrizione;

	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

}
