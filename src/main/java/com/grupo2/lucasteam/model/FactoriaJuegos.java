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
	PlataformasDAOI plataformasDAO;
	GenerosDAOI generosDAO;

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
		if (!e.isPresent()) {
			e.get().setEditor(editor);
			editoresDAO.save(e.get());
		}

		// Plataforma
		Optional<Plataforma> p = plataformasDAO.findByPlataforma(plataforma);
		if (!p.isPresent()) {
			p.get().setPlataforma(plataforma);
			plataformasDAO.save(p.get());
		}

		// Genero
		Optional<Genero> g = generosDAO.findByGenero(genero);
		if (!g.isPresent()) {
			g.get().setGenero(genero);
			generosDAO.save(g.get());
		}

		// Crear objeto juego
		Juego juego = new Juego();

		try {

			// Set atributos de juego
			juego.setRango(Integer.parseInt(rango));
			juego.setNombre(nombre);
			juego.setId_plataforma(p.get());
			// Esto va a fallar: es un int en BBDD
			juego.setFecha(Year.parse(fecha));
			juego.setId_genero(g.get());
			juego.setId_editor(e.get());
			juego.setNA_ventas(Double.parseDouble(NA_ventas));
			juego.setEU_ventas(Double.parseDouble(EU_ventas));
			juego.setJP_ventas(Double.parseDouble(JP_ventas));
			juego.setOtras_ventas(Double.parseDouble(otras_ventas));
			juego.setVentas_globales(Double.parseDouble(ventas_globales));

		} catch (NumberFormatException nfe) {
			// TODO: handle exception
			log.warn("Error al convertir String a Integer o Double: " + nfe.getMessage());
		} catch (DateTimeException dte) {
			// TODO: handle exception
			log.warn("Error al convertir String a Year: " + dte.getMessage());
		} catch (NullPointerException npe) {
			// TODO: handle exception
			log.warn("String vacía: " + npe.getMessage());
		}
		return juego;

	}

}
