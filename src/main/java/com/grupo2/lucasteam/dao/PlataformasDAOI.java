package com.grupo2.lucasteam.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo2.lucasteam.model.Plataforma;

/**
 * Interfaz PlataformasDAOI que se encarga de gestionar las consultas a la tabla
 * Plataforma de la BBDD.
 *
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 */
public interface PlataformasDAOI extends JpaRepository<Plataforma, Integer> {

	/**
	 * Consulta a la base de datos para encontrar una plataforma según el valor del
	 * campo de plataforma.
	 * 
	 * @param nombre - String con el nombre de la plataforma
	 * @return Optional<Plataforma>
	 * @author Álvaro Román Gómez
	 * @since 1.0
	 */
	Optional<Plataforma> findByPlataforma(String nombre);

	/**
	 * Consulta a la base de datos para encontrar todos las plataformas según el
	 * valor del campo de plataforma.
	 * 
	 * @param plataforma - String con el nombre de la plataforma
	 * @return ArrayList<Juego>
	 * @author Álvaro Román Gómez
	 * @since 1.0
	 */
	ArrayList<Plataforma> findAllByPlataforma(String plataforma);
}
