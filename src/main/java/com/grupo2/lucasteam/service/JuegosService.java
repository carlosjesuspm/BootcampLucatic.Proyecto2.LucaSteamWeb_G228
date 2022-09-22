package com.grupo2.lucasteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupo2.lucasteam.repository.JuegosDAOI;

/**
* Clase JuegosService:
* 
* 
* @author Grupo 2 - Tamara Alvarez
* @version 1.0: 22/09/2022
*/

@Service
public class JuegosService implements JuegosServiceI{
	
	@Autowired
	JuegosDAOI juegosDAO;
	
	@Override
	public void save(Juego juego) {
		juegosDAO.save(juego);
	}
	
}
