package com.grupo2.lucasteam.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo2.lucasteam.model.Editor;

/**
 * Interfaz EditoresDAOI que se encarga de gestionar las consultas a la tabla
 * Edtior de la BBDD.
 *
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 */
public interface EditoresDAOI extends JpaRepository<Editor, Integer> {

	/**
	 * Consulta a la base de datos para encontrar un editor según el valor del campo
	 * de editor.
	 * 
	 * @param nombre - String con el nombre del editor
	 * @return Optional<Editor>
	 * @author Álvaro Román Gómez
	 * @since 1.0
	 */
	Optional<Editor> findByEditor(String nombre);

	/**
	 * Consulta a la base de datos para encontrar todos los editores según el valor
	 * del campo de editor.
	 * 
	 * @param editor - String con el nombre del editor
	 * @return ArrayList<Editor>
	 * @author Álvaro Román Gómez
	 * @since 1.0
	 */
	ArrayList<Editor> findAllByEditor(String editor);
}
