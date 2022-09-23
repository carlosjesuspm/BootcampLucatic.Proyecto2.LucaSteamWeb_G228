package com.grupo2.lucasteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.lucasteam.dao.JuegosDAOI;
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

	@Autowired
	JuegosDAOI juegosDAO;
	FactoriaJuegosI factoria;
	FicheroI fichero;

	/**
	 * Método save() - permite guardar objetos de tipo Juego
	 * 
	 * @param juego
	 * @author Grupo 2 -Tamara Alvarez
	 * @since 1.0
	 */
	@Override
	public void AltaJuego(Juego juego) {
		juegosDAO.save(juego);
	}

	/**
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

}
