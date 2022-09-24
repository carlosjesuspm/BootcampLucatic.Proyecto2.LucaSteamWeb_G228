package com.grupo2.lucasteam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.lucasteam.dao.JuegosDAOI;
import com.grupo2.lucasteam.model.FactoriaJuegos;
import com.grupo2.lucasteam.model.FactoriaJuegosI;
import com.grupo2.lucasteam.model.Juego;
import com.grupo2.lucasteam.util.FicheroI;
import com.grupo2.lucasteam.util.ValidacionesI;

/**
 * Clase JuegosService - contiene los métodos para conectar las peticiones de la
 * capa control con la capa de datos.
 * 
 * @author Grupo 2 - Tamara Alvarez
 * @version 1.0: 22/09/2022
 */
@Service
public class JuegosService implements JuegosServiceI {

	private static final Logger log = LoggerFactory.getLogger(FactoriaJuegos.class);

	@Autowired
	JuegosDAOI juegosDAO;
	@Autowired
	FactoriaJuegosI factoria;
	@Autowired
	FicheroI fichero;
	@Autowired
	ValidacionesI validar;
	public static boolean CSVcargado = false;

	/**
	 * Método save() - permite guardar objetos de tipo Juego
	 * 
	 * @param juego
	 * @author Grupo 2 -Tamara Alvarez
	 * @since 1.0
	 */
	@Override
	public void altaJuego(Juego juego) {

		if (!validar.existeJuego(juego)) {
			juegosDAO.save(juego);
		} else {
			log.info("El juego " + juego.getNombre() + " ya está en la BBDD.");
		}

	}

	/**
	 * Método importarCSV que utiliza la lista de juegos devuelta por leerCSV y va
	 * guardando cada juego en la base de datos. *
	 * 
	 * @author Álvaro Román Gómez Método importarCSV() - permite traer un archivo
	 *         CSV para poder trabajar con él
	 * 
	 * @param juego
	 * @author Grupo 2 -
	 * @since 1.0
	 */
	@Override
	public void importarCSV() {

		while (!CSVcargado) {
			// TODO Auto-generated method stub
			ArrayList<Juego> juegos = fichero.importarCSV("vgsales.csv");
			log.info("Importando lista de juegos en BBDD...");
			for (Juego juego : juegos) {
				if (!validar.existeJuego(juego)) {
					juegosDAO.save(juego);
				}

			}
			CSVcargado = true;
		}

	}

	/**
	 * Método save() - permite guardar objetos de tipo Juego
	 *
	 * @author Grupo 2 - Carlos Jesús Pérez Márquez
	 * @since 1.0
	 */
	public List<Juego> findAll() {
		return juegosDAO.findAll();
	}

	@Override
	public void deleteById(int id) {
		juegosDAO.deleteById(id);

	}

	@Override
	public Optional<Juego> findById(int id) {
		return juegosDAO.findById(id);
	}

}
