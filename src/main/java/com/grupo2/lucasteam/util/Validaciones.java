package com.grupo2.lucasteam.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupo2.lucasteam.dao.EditoresDAOI;
import com.grupo2.lucasteam.dao.GenerosDAOI;
import com.grupo2.lucasteam.dao.JuegosDAOI;
import com.grupo2.lucasteam.dao.PlataformasDAOI;
import com.grupo2.lucasteam.exceptions.NaException;

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

	@Override
	public void isNA(String string) throws NaException {
		if (string.equals("N/A")) {
			throw new NaException();
		}
	}

}
