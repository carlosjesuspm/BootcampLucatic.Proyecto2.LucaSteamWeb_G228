package com.grupo2.lucasteam.model;

/**
 * Interfaz FactoriaJuegos que se encarga de la instancación de objeto de clase
 * Juego.
 * 
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 * 
 */

public interface FactoriaJuegosI {

	public Juego crearJuego(String rango, String nombre, String id_plataforma, String fecha, String id_genero,
			String id_editor, String NA_ventas, String EU_ventas, String JP_ventas, String otras_ventas,
			String ventas_globales);

}
