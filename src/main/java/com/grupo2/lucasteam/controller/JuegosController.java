package com.grupo2.lucasteam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo2.lucasteam.service.JuegosServiceI;

/**
 * Descripción de la clase: ======= import com.grupo2.lucasteam.model.Editor;
 * import com.grupo2.lucasteam.model.Genero; import
 * com.grupo2.lucasteam.model.Plataforma; import
 * com.grupo2.lucasteam.service.JuegosService;
 * 
 * /** Descripción de la clase: >>>>>>> developer
 * 
 * Clase JuegoController dedicada a recibir peticiones http relacionadas con la
 * clase Juego y devolver respuestas en base a ella.
 *
 * @author Carlos Jesús Pérez márquez
 * @version 1.0: 22/09/2022
 */

@Controller
@RequestMapping("/")
public class JuegosController {

	@Autowired
	JuegosServiceI service;

	private static final Logger log = LoggerFactory.getLogger(JuegosController.class);

	/**
	 * Descripción del método: Metodo que permite obtener un listado de todos los
	 * juegos para que terminen viéndose en la interfaz creada para ello
	 * 
	 * @return {@code listaJuegos}
	 * @author Carlos Jesús Pérez Márquez
	 * @since 1.0
	 */

//	@GetMapping
//	public String listaJuegos(Model m) {
//		m.addAttribute("listaJuegos", service.findAll());
//
//		return "listaJuegos";
//		m.addAttribute("listaJuegos", service.findAll());
//		return "listaJuegos";
//	}

	/**
	 * Método newJuego() - crea nuevos registros de tipo juego.
	 * 
	 * @param juego
	 * @param m
	 * @return {@code formularioAlta}
	 * @author Grupo 2 - Tamara Alvarez
	 * @since 1.0
	 */
//	@GetMapping("/altaJuego")
//	public String newJuego(Juego juego, Model m) {
//		m.addAttribute("juego", juego);
//		return "formularioAlta";
//	}
//

	/**
	 * Método inmportarCSV que llama método importarCSV de la capa de Servicios.
	 * 
	 * @author Álvaro Román Gómez
	 * @since 1.0
	 */

	public void importarCSV() {
		log.info("Importando CSV en Controller.");
		service.importarCSV();
	}

}
