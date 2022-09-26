package com.grupo2.lucasteam.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo2.lucasteam.model.Editor;
import com.grupo2.lucasteam.model.Juego;

public interface EditoresDAOI extends JpaRepository<Editor, Integer> {

	Optional<Editor> findByEditor(String nombre);

	ArrayList<Editor> findAllByEditor(String editor);
}
