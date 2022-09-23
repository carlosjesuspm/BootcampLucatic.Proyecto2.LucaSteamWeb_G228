package com.grupo2.lucasteam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo2.lucasteam.model.Plataforma;

public interface PlataformasDAOI extends JpaRepository<Plataforma, Integer> {

	Optional<Plataforma> findByPlataforma(String nombre);

}
