package com.grupo2.lucasteam.controller;


import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo2.lucasteam.model.Editor;
import com.grupo2.lucasteam.model.Genero;
import com.grupo2.lucasteam.model.Plataforma;
import com.grupo2.lucasteam.service.JuegosService;

/** Descripción de la clase:
 * 
* Clase JuegoController dedicada a recibir peticiones http relacionadas
* con la clase Juego y devolver respuestas en base a ella. 
*
* @author Carlos Jesús Pérez márquez
* @version 1.0: 22/09/2022
*/

@Controller
@RequestMapping("/")
public class JuegosController {

	@Autowired
	JuegosService service;
	
	private static final Logger log = LoggerFactory.getLogger(JuegosController.class);
	
	/**
	* Descripción del método:
	* Metodo que permite obtener un listado de todos los juegos 
	* para que terminen viéndose en la interfaz creada para ello

	* @return {@code listaJuegos} 
	* @author Carlos Jesús Pérez Márquez
	* @since 1.0
	*/
	
	@GetMapping
	public String listaJuegos(Model m) {
//		m.addAttribute("listaJuegos", service.findAll());
		return "listaJuegos";
	}
}
