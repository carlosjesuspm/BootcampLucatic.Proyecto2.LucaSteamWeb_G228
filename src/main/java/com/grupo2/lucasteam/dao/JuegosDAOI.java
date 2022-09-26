package com.grupo2.lucasteam.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo2.lucasteam.model.Juego;

@Repository
public interface JuegosDAOI extends JpaRepository<Juego, Integer> {

	Optional<Juego> findByNombre(String nombre);

	ArrayList<Juego> findAllByNombre(String nombre);
	
	ArrayList<Juego> findAllByPlataforma(String plataforma);
	
	ArrayList<Juego> findAllByEditor(String editor);

	ArrayList<Juego> findAllByGenero(String genero);

	ArrayList<Juego> findAllByFecha(int fecha);
	
}
