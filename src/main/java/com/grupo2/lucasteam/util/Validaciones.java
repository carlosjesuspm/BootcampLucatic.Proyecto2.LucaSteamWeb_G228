package com.grupo2.lucasteam.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupo2.lucasteam.dao.EditoresDAOI;
import com.grupo2.lucasteam.dao.GenerosDAOI;
import com.grupo2.lucasteam.dao.JuegosDAOI;
import com.grupo2.lucasteam.dao.PlataformasDAOI;
import com.grupo2.lucasteam.exceptions.NaException;

/**
 * Clase Validaciones que contiene todos los métodos de validación de datos que
 * se utilizan en el resto del programa.
 * 
 * @author Álvaro Román Gómez
 * @version 1.0: 24/09/2022
 * 
 */

@Component
public class Validaciones implements ValidacionesI {

	@Autowired
	JuegosDAOI juegosDAO;
	@Autowired
	EditoresDAOI editoresDAO;
	@Autowired
	PlataformasDAOI plataformasDAO;
	@Autowired
	GenerosDAOI generosDAO;

	/**
	 * Métod isNA que dectecta si una String tiene un valor N/A. En caso de que lo
	 * tenga lanza una excepción.
	 * 
	 * @param String string
	 * @throws NaException
	 * @author Álvaro Román Gómez
	 * @since 1.0
	 */
	@Override
	public void isNA(String string) throws NaException {
		if (string.equals("N/A")) {
			throw new NaException();
		}
	}

}
