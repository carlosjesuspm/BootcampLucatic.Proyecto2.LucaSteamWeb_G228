package com.grupo2.lucasteam.util;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupo2.lucasteam.dao.JuegosDAOI;
import com.grupo2.lucasteam.exceptions.NaException;
import com.grupo2.lucasteam.model.Juego;

@Component
public class Validaciones implements ValidacionesI {

	@Autowired
	JuegosDAOI juegosDAO;

	@Override
	public boolean existeJuego(Juego juego) {
		// TODO Auto-generated method stub

		ArrayList<Juego> juegos = juegosDAO.findAllByNombre(juego.getNombre());

		if (juegos != null) {

			for (Juego j : juegos) {

				if (j.equals(juego)) {

					return true;

				}

			}

		}

		return false;

	}

	@Override
	public boolean existeJuego(Juego juego, ArrayList<Juego> juegos) {
		// TODO Auto-generated method stub

		if (juegos != null) {

			for (Juego j : juegos) {

				if (j.equals(juego)) {

					return true;

				}

			}

		}

		return false;

	}

	@Override
	public void isNA(String string) throws NaException {
		if (string.equals("N/A")) {
			throw new NaException();
		}
	}

}
