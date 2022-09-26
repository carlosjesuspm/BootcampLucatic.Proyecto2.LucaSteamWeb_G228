package com.grupo2.lucasteam.util;

import java.util.ArrayList;

import com.grupo2.lucasteam.exceptions.NaException;
import com.grupo2.lucasteam.model.Editor;
import com.grupo2.lucasteam.model.Genero;
import com.grupo2.lucasteam.model.Juego;
import com.grupo2.lucasteam.model.Plataforma;

public interface ValidacionesI {

	public void isNA(String string) throws NaException;

	/**
	 * Metodo generico para comprobar que un elemento existe en una lista
	 * 
	 * @param <E> Tipo de dato con el que va a trabajar el metodo
	 * @param e   Elemento a buscar
	 * @param es  Lista de elementos donde se va a buscar
	 * @return {@code true} si el elemento existe
	 * @version 1.0 25/09
	 * @author Grupo 2 - Alonso Gomez
	 */
	public static <E> boolean existe(E e, ArrayList<E> es) {
		if (e != null)
			for (E i : es)
				if (i.equals(e))
					return true;

		return false;
	}

}
