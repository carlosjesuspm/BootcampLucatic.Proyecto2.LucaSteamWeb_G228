package com.grupo2.lucasteam.service;

import java.util.List;

import com.grupo2.lucasteam.model.Juego;

public interface JuegosServiceI {

	public void AltaJuego(Juego juego);

	public void importarCSV();
	
	public  List<Juego> findAll();

}
