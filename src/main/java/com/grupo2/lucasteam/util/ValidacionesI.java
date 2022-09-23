package com.grupo2.lucasteam.util;

import java.util.ArrayList;

import com.grupo2.lucasteam.exceptions.NaException;
import com.grupo2.lucasteam.model.Juego;

public interface ValidacionesI {

	public boolean existeJuego(Juego juego);

	public void isNA(String string) throws NaException;

	boolean existeJuego(Juego juego, ArrayList<Juego> juegos);

}
