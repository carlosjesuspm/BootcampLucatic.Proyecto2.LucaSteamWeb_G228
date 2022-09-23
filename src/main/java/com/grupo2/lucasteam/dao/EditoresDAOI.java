package com.grupo2.lucasteam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo2.lucasteam.model.Editor;

public interface EditoresDAOI extends JpaRepository<Editor, Integer> {

	Optional<Editor> findByNombre(String nombre);

}
