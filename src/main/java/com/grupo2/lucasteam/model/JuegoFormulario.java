package com.grupo2.lucasteam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase Plataforma que representa la entidad plataforma reflejada en la base de
 * datos.
 * 
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 * 
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuegoFormulario {
	private String id;
	private String rango;
	private String nombre;
	private String id_plataforma;
	private String fecha;
	private String id_genero;
	private String id_editor;
	private String NA_ventas;
	private String EU_ventas;
	private String JP_ventas;
	private String otras_ventas;
	private String ventas_globales;
}
