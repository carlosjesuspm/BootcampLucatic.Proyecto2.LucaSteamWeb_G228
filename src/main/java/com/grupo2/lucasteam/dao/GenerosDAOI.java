package com.grupo2.lucasteam.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo2.lucasteam.model.Genero;

public interface GenerosDAOI extends JpaRepository<Genero, Integer> {

	Optional<Genero> findByGenero(String nombre);

	ArrayList<Genero> findAllByGenero(String genero);
}
