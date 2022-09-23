package com.grupo2.lucasteam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo2.lucasteam.model.Juego;

@Repository
public interface JuegosDAOI extends JpaRepository<Juego, Integer> {

	Optional<Juego> findByNombre(String nombre);

}
