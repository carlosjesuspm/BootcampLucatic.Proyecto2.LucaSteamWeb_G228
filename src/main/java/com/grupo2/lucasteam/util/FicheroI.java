package com.grupo2.lucasteam.util;

import java.util.TreeSet;

import com.grupo2.lucasteam.model.Juego;

/**
 * Interfaz FicheroI que se encarga de los métodos de escribir y leer ficheros.
 * 
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 * 
 */

public interface FicheroI {

	public TreeSet<Juego> importarCSV(String rutaArchivo);

}
