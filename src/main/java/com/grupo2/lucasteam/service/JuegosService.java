package com.grupo2.lucasteam.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.lucasteam.dao.JuegosDAOI;
import com.grupo2.lucasteam.model.FactoriaJuegos;
import com.grupo2.lucasteam.model.FactoriaJuegosI;
import com.grupo2.lucasteam.model.Juego;
import com.grupo2.lucasteam.util.FicheroI;

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

	/**
	 * Método save() - permite guardar objetos de tipo Juego
	 * 
	 * @param juego
	 * @author Grupo 2 -Tamara Alvarez
	 * @since 1.0
	 */
	@Override
	public void altaJuego(Juego juego) {
		System.out.println("holla");
		System.out.println(juego.toString());
		juegosDAO.save(juego);
	}

	/**
	 * Método importarCSV que utiliza la lista de juegos devuelta por leerCSV y va
	 * guardando cada juego en la base de datos. *
	 * 
	 * @author Álvaro Román Gómez
	 * Método importarCSV() - permite traer un archivo CSV
	 * para poder trabajar con él
	 * 
	 * @param juego
	 * @author Grupo 2 -
	 * @since 1.0
	 */
	@Override
	public void importarCSV() {
		// TODO Auto-generated method stub
		System.out.println("--------------------Hola estoy aqui------------------");
		ArrayList<Juego> juegos = fichero.importarCSV("prueba.csv");
		log.info("Importando lista de juegos en BBDD...");
		for (Juego juego : juegos) {
			Optional<Juego> j = juegosDAO.findByNombre(juego.getNombre());
			if (!j.isPresent() || !j.get().equals(juego)) {
				juegosDAO.save(juego);
			}
		}

	}
	
	
	/**
	 * Método save() - permite guardar objetos de tipo Juego
	 *
	 * @author Grupo 2 - Carlos Jesús Pérez Márquez
	 * @since 1.0
	 */
	public List<Juego> findAll(){
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
