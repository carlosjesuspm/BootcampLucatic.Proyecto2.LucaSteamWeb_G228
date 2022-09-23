package com.grupo2.lucasteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.lucasteam.model.FactoriaJuegosI;
import com.grupo2.lucasteam.util.FicheroI;

@Service
public class JuegosService implements JuegosServiceI {

	@Autowired
	FactoriaJuegosI factoria;
	FicheroI fichero;

	@Override
	public void importarCSV() {
		// TODO Auto-generated method stub
		juegos = fichero.importarCSV(null);
	}

}
