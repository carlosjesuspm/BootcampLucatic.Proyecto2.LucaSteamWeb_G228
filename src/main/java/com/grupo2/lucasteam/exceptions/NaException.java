package com.grupo2.lucasteam.exceptions;

/**
 * Clase NaException que recoge las excepciones de tipo NA cuando un dato tiene
 * este valor.
 *
 * @author Álvaro Román Gómez
 * @version 1.0: 23/09/2022
 */
public class NaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -476044225691320586L;

	/**
	 * Método que devuelve el mensaje correspondiente a esta excepción.
	 * 
	 * @return String - Devuelve el mensaje de la excepción.
	 * @author Álvaro Román Gómez
	 * @since 1.0
	 */
	public String getMessage() {

		return "Este valor es NA.";

	}

}
