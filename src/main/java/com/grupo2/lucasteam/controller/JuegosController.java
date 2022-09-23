package com.grupo2.lucasteam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class JuegosController {

	@Autowired
	JuegoService service;

	private static final Logger log = LoggerFactory.getLogger(JuegosController.class);
	
	/** Metodo listaJuegos() - mapea la lista de juegos
	* @param Listar juegos
	* @return /endpoint listaJuegos
	* @author Lamia
	* @version 1.0 23/09/22
	*/

	@GetMapping("/")
	public String listaJuegos(Model m) {
		m.addAttribute("listaJuegos", service.findAll());

		return "listaJuegos";

	}
	
	
	/** Metodo eliminarJuego() - permite eliminar un juego de la lista Juegos
	* @param Eliminar juego
	* @return /endpoint listaJuegos
	* @author Lamia
	* @version 1.0 23/09/22
	*/
	
	@GetMapping("/eliminarJuego")
	public String eliminarJuego(@RequestParam("id")int id) {
		service.deleteById(id);
		return ("redirect:/listaJuegos");
		
	}


}
