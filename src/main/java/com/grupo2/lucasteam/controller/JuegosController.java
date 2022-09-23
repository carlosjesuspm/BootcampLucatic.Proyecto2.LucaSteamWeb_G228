package com.grupo2.lucasteam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class JuegosController {
	
	@Autowired
	JuegosServiceI service;
	
	private static final Logger log = LoggerFactory.getLogger(JuegosController.class);
	
	
	/**
	* Método newJuego() - crea nuevos registros de tipo juego.
	* @param juego
	* @param m
	* @return {@code formularioAlta} 
	* @author Grupo 2 - Tamara Alvarez
	* @since 1.0
	*/
	@GetMapping("/altaJuego")
	public String newJuego(Juego juego, Model m) {
		m.addAttribute("juego", juego);
		return "formularioAlta";
	}
	
	
}
