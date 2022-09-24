package com.grupo2.lucasteam.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupo2.lucasteam.model.FactoriaJuegos;
import com.grupo2.lucasteam.model.FactoriaJuegosI;
import com.grupo2.lucasteam.model.Juego;

/**
 * Clase Fichero que se encarga de los métodos para la lectura y escritura de
 * los métodos.
 * 
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 * 
 */

@Component
public class Fichero implements FicheroI {

	private static final Logger log = LoggerFactory.getLogger(FactoriaJuegos.class);

	@Autowired
	FactoriaJuegosI factoria;
	public static boolean CSVcargado = false;

	/**
	 * Método importarCSV que nos permite leer un fichero CSV y conseguir una lista
	 * de objetos de clase Juego.
	 * 
	 * @param rutaArchivo - Rango del juego en el ranking de ventas.
	 * @return ArrayList<Juego> - Devuelve una lista de objetos Juego.
	 * @author Álvaro Román Gómez
	 * @since 1.0
	 */

	@Override
	public ArrayList<Juego> importarCSV(String rutaArchivo) {
		// TODO Auto-generated method stub
		// Comprobamos que el archivo existe
		File file = new File(rutaArchivo);
		if (!file.exists()) {
			log.warn("El archivo " + rutaArchivo + " no existe.");
		}

		ArrayList<Juego> juegos = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			reader.readLine();
			String linea;

			while ((linea = reader.readLine()) != null) {

				String[] palabras = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				juegos.add(factoria.crearJuego(palabras[0], palabras[1], palabras[2], palabras[3], palabras[4],
						palabras[5], palabras[6], palabras[7], palabras[8], palabras[9], palabras[10]));

			}

		} catch (IOException ioe) {
			// TODO: handle exception
			log.warn("No se ha podido abrir: " + rutaArchivo + ioe.getMessage());
		}

		return juegos;
	}

}
