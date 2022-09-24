package com.grupo2.lucasteam.util;

import java.util.ArrayList;

import com.grupo2.lucasteam.model.Juego;

/**
 * Interfaz FicheroI que se encarga de los métodos de escribir y leer ficheros.
 * 
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 * 
 */

public interface FicheroI {

	public ArrayList<Juego> importarCSV(String rutaArchivo);

}
