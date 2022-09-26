package com.grupo2.lucasteam.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grupo2.lucasteam.model.Editor;
import com.grupo2.lucasteam.model.Genero;
import com.grupo2.lucasteam.model.Juego;
import com.grupo2.lucasteam.model.Plataforma;

@Repository
public interface JuegosDAOI extends JpaRepository<Juego, Integer> {

	Optional<Juego> findByNombre(String nombre);

	ArrayList<Juego> findAllByNombre(String nombre);

	ArrayList<Juego> findAllByPlataforma(Plataforma plataforma);

	ArrayList<Juego> findAllByEditor(Editor editor);

	ArrayList<Juego> findAllByGenero(Genero genero);

	ArrayList<Juego> findAllByFecha(int annio);

	ArrayList<Juego> findAllByFechaBetween(int value1, int value2);

	@Query("FROM Juego WHERE fecha % 2 = 0")
	ArrayList<Juego> findAllFechaPar();

	@Query("FROM Juego WHERE EU_ventas > (SELECT AVG(EU_ventas) FROM Juego)")
	ArrayList<Juego> findAllByMediaVentasEU();

}
