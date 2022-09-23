package com.grupo2.lucasteam.util;

import java.util.ArrayList;

import com.grupo2.lucasteam.model.Juego;

public interface FicheroI {

	public ArrayList<Juego> importarCSV(String rutaArchivo);

}
