package com.grupo2.lucasteam.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo2.lucasteam.model.Juego;

/**
 * Interfaz JuegosDAOI que se encarga de gestionar las consultas a la tabla
 * Juegos de la BBDD.
 *
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 */
@Repository
public interface JuegosDAOI extends JpaRepository<Juego, Integer> {

	/**
	 * Consulta a la base de datos para encontrar un juego según el valor del campo
	 * de nombre.
	 * 
	 * @param nombre - String con el nombre del juego
	 * @return Optional<Juego>
	 * @author Álvaro Román Gómez
	 * @since 1.0
	 */
	Optional<Juego> findByNombre(String nombre);

	/**
	 * Consulta a la base de datos para encontrar todos los juegos según el valor
	 * del campo de nombre.
	 * 
	 * @param nombre - String con el nombre del juego
	 * @return ArrayList<Juego>
	 * @author Álvaro Román Gómez
	 * @since 1.0
	 */
	ArrayList<Juego> findAllByNombre(String nombre);

}
