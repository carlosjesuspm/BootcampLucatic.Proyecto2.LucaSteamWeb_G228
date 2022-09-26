package com.grupo2.lucasteam.service;

import java.util.List;
import java.util.Optional;

import com.grupo2.lucasteam.model.Juego;

/**
 * Interfaz JuegosServiceI que se encarga de gestionar las peticiones que vienen
 * de controller relacionadas con la clase Juego.
 * 
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 * 
 */

public interface JuegosServiceI {

	public void altaJuego(Juego juego);

	public void importarCSV();

	public List<Juego> findAll();

	public void deleteById(int id);

	public Optional<Juego> findById(int id);

}
