package com.grupo2.lucasteam.service;

import java.util.List;
import java.util.Optional;

import com.grupo2.lucasteam.model.Editor;
import com.grupo2.lucasteam.model.Genero;
import com.grupo2.lucasteam.model.Juego;
import com.grupo2.lucasteam.model.Plataforma;

public interface JuegosServiceI {

	public void altaJuego(Juego juego);

	public void importarCSV();

	public List<Juego> findAll();

	public void deleteById(int id);

	public Optional<Juego> findById(int id);

}
