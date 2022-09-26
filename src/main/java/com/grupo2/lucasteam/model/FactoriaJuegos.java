package com.grupo2.lucasteam.model;

import java.time.DateTimeException;
import java.time.Year;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grupo2.lucasteam.dao.EditoresDAOI;
import com.grupo2.lucasteam.dao.GenerosDAOI;
import com.grupo2.lucasteam.dao.PlataformasDAOI;
import com.grupo2.lucasteam.exceptions.NaException;
import com.grupo2.lucasteam.util.ValidacionesI;

/**
 * Clase FactoriaJuegos que se encarga de la instanciación de objetos de la
 * clase Juego.
 * 
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 * 
 */

@Component
public class FactoriaJuegos implements FactoriaJuegosI {

	private static final Logger log = LoggerFactory.getLogger(FactoriaJuegos.class);

	@Autowired
	EditoresDAOI editoresDAO;
	@Autowired
	PlataformasDAOI plataformasDAO;
	@Autowired
	GenerosDAOI generosDAO;
	@Autowired
	ValidacionesI validar;

	/**
	 * Método crearJuego que nos permite crear un objeto Juego a partir de ciertos
	 * parámetros.
	 * 
	 * @param rango           - Rango del juego en el ranking de ventas.
	 * @param nombre          - Nombre del juego.
	 * @param plataforma      - Plataforma en la que está disponible el juego.
	 * @param fecha           - Fecha de lanzamiento del juego.
	 * @param genero          - Género en el que se clasifica el juego.
	 * @param editor          - Nombre del editor del juego.
	 * @param NA_ventas       - Ventas en América del Norte.
	 * @param EU_ventas       - Ventas en Europa.
	 * @param JP_ventas       - Ventas en Japón.
	 * @param otras_ventas    - Ventas en el resto de lugares.
	 * @param ventas_globales - Volumen total de ventas.
	 * @return Juego - Devuelve un objeto de la clase Juego.
	 * @author Álvaro Román Gómez
	 * @since 1.0
	 */
	@Override
	public Juego crearJuego(String rango, String nombre, String plataforma, String fecha, String genero, String editor,
			String NA_ventas, String EU_ventas, String JP_ventas, String otras_ventas, String ventas_globales) {

		// Editor
		Optional<Editor> e = editoresDAO.findByEditor(editor);
		Editor edit;
		Plataforma plat;
		Genero gen;
		if (!e.isPresent()) {
//			e.get().setEditor(editor);
			edit = new Editor();
			edit.setEditor(editor);
			edit = editoresDAO.save(edit);

		} else {
			edit = e.get();
		}

		// Plataforma
		Optional<Plataforma> p = plataformasDAO.findByPlataforma(plataforma);
		if (!p.isPresent()) {
//			p.get().setPlataforma(plataforma);
			plat = new Plataforma();
			plat.setPlataforma(plataforma);
			plat = plataformasDAO.save(plat);
		} else {
			plat = p.get();
		}

		// Genero
		Optional<Genero> g = generosDAO.findByGenero(genero);
		if (!g.isPresent()) {
//			g.get().setGenero(genero);
			gen = new Genero();
			gen.setGenero(genero);
			gen = generosDAO.save(gen);
		} else {
			gen = g.get();
		}

		// Crear objeto juego
		Juego juego = new Juego();

		try {

			// Set atributos de juego
			// RANGO
			try {
				juego.setRango(Integer.parseInt(rango));
			} catch (NumberFormatException nfe) {
				log.warn("Error al convertir String a Integer o Double: " + nfe.getMessage());
			}
			// NOMBRE - NOT NULL
			try {
				juego.setNombre(nombre);
			} catch (NullPointerException npe) {
				// TODO: handle exception
				log.warn("Nombre vacío: " + npe.getMessage());
			}
			// PLATAFORMA - NOT NULL
			try {
				juego.setPlataforma(plat);
			} catch (NullPointerException npe) {
				// TODO: handle exception
				log.warn("Plataforma vacía: " + npe.getMessage());
			}
			// FECHA - NA
			try {
				validar.isNA(fecha);
				juego.setFecha(Year.parse(fecha).getValue());
			} catch (NaException nae) {
				// TODO: handle exception
				log.info("Esta fecha es nula: " + nae.getMessage());
			} catch (DateTimeException dte) {
				// TODO: handle exception
				log.warn("Error al convertir String a Year: " + dte.getMessage());
			}
			// GENERO - NOT NULL
			try {
				juego.setGenero(gen);
			} catch (NullPointerException npe) {
				// TODO: handle exception
				log.warn("Genero vacío: " + npe.getMessage());
			}

			// EDITOR - NOT NULL
			try {
				juego.setEditor(edit);
			} catch (NullPointerException npe) {
				// TODO: handle exception
				log.warn("Editor vacío: " + npe.getMessage());
			}

			try {
				juego.setNA_ventas(Double.parseDouble(NA_ventas));
				juego.setEU_ventas(Double.parseDouble(EU_ventas));
				juego.setJP_ventas(Double.parseDouble(JP_ventas));
				juego.setOtras_ventas(Double.parseDouble(otras_ventas));
				juego.setVentas_globales(Double.parseDouble(ventas_globales));
			} catch (NumberFormatException nfe) {
				// TODO: handle exception
				log.warn("Error al convertir String a Integer o Double: " + nfe.getMessage());
			}

		} catch (NumberFormatException nfe) {
			// TODO: handle exception
			log.warn("Error al convertir String a Integer o Double: " + nfe.getMessage());
		} catch (NullPointerException npe) {
			// TODO: handle exception
			log.warn("String vacía: " + npe.getMessage());
		}
		return juego;

	}

}
