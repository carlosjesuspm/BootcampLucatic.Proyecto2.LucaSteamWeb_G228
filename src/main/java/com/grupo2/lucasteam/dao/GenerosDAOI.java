package com.grupo2.lucasteam.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo2.lucasteam.model.Genero;

/**
 * Interfaz GenerosDAOI que se encarga de gestionar las consultas a la tabla
 * Genero de la BBDD.
 *
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 */
public interface GenerosDAOI extends JpaRepository<Genero, Integer> {

	/**
	 * Consulta a la base de datos para encontrar un genero según el valor del campo
	 * de genero.
	 * 
	 * @param nombre - String con el nombre del genero
	 * @return Optional<Genero>
	 * @author Álvaro Román Gómez
	 * @since 1.0
	 */
	Optional<Genero> findByGenero(String nombre);

	/**
	 * Consulta a la base de datos para encontrar todos los generos según el valor
	 * del campo de genero.
	 * 
	 * @param genero - String con el nombre del genero
	 * @return ArrayList<Genero>
	 * @author Álvaro Román Gómez
	 * @since 1.0
	 */
	ArrayList<Genero> findAllByGenero(String genero);

}
