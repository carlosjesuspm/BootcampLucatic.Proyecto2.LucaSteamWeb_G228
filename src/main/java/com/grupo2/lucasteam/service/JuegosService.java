package com.grupo2.lucasteam.service;

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
	public void save(Juego juego) {
		juegosDAO.save(juego);
	}

	@Override
	public void importarCSV() {
		// TODO Auto-generated method stub

	}

}
