package com.grupo2.lucasteam.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo2.lucasteam.model.Editor;
import com.grupo2.lucasteam.model.FactoriaJuegosI;
import com.grupo2.lucasteam.model.Juego;
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
	@Autowired
	FactoriaJuegosI fj;

	private static final Logger log = LoggerFactory.getLogger(JuegosController.class);

	/**
	 * Descripción del método: Metodo que permite obtener un listado de todos los
	 * juegos para que terminen viéndose en la interfaz creada para ello
	 * 
	 * @return {@code listaJuegos}
	 * @author Carlos Jesús Pérez Márquez
	 * @since 1.0
	 */

	@GetMapping("/")
	public String listaJuegos(Model m) {
		m.addAttribute("listaJuegos", service.findAll());
		return "listaJuegos";
	}

	/**
	 * Metodo modificarJuego() - permite modificar un juego de la lista Juegos
	 * 
	 * @param Modificar juego
	 * @return /endpoint formularioJuego
	 * @author Lamia
	 * @version 1.0 23/09/22
	 */

	@GetMapping("/modificarJuego")
	public String modificarJuego(@RequestParam("id") int id, Model m) {
		Optional<Juego> j = service.findById(id);
		if (j.isPresent()) {
			m.addAttribute("juego", j.get());
			return "formularioAlta";
		} else {
			return "error";
		}

	}

	/**
	 * Metodo eliminarJuego() - permite eliminar un juego de la lista Juegos
	 * 
	 * @param Eliminar juego
	 * @return /endpoint listaJuegos
	 * @author Lamia
	 * @version 1.0 23/09/22
	 */

	@GetMapping("/eliminarJuego")
	public String eliminarJuego(@RequestParam("id") int id) {
		service.deleteById(id);
		return ("redirect:/");

	}

	/**
	 * Metodo de cargar la lista de juegos desde el csv
	 * 
	 * @param m
	 * @author Grupo 2 - Alonso Gomez
	 * @since 1.0
	 */
	@GetMapping("/cargarCsv")
	public String loadFile(Model m) {
		service.importarCSV();
		return ("redirect:/");
	}

	/**
	 * Metodo para dar de alta un juego
	 * 
	 * @param juego
	 * @param m
	 * @return
	 */
	@GetMapping("/altaJuego")
	public String newJuego(Juego juego, Model m) {
		m.addAttribute("juego", juego);
		return "formularioAlta";
	}

	/**
	 * Metodo para guardar le juego creado
	 * 
	 * @param juego
	 * @return
	 */
	@PostMapping("/save")
	public String save(Juego j) {
		service.altaJuego(j);
		return ("redirect:/");
	}

	/**
	 * Metodo para filtrar juegos por Plataforma y mostrarlos.
	 * 
	 * @param @RequestParam("pltaforma") String platforma
	 * @return "redirect:/"
	 */
	@GetMapping("/editor")
	public String listaJuegosEditor(@RequestParam("editor") String editor, Model m) {
		log.info("Obteniendo juegos de editor " + editor + " en JuegosController.");
		m.addAttribute("listaJuegos", service.findAllByEditor(editor));
		return "listaJuegos";
	}

	/**
	 * Metodo para filtrar juegos por Plataforma y mostrarlos.
	 * 
	 * @param @RequestParam("pltaforma") String platforma
	 * @return "redirect:/"
	 *//*
		 * @GetMapping("/editor") public String
		 * listaJuegosGenero(@RequestParam("editor") String editor, Model m) {
		 * log.info("Obteniendo juegos de plataforma " + editor +
		 * " en JuegosController."); m.addAttribute("listaJuegos",
		 * service.findAllByEditor(editor)); return ("redirect:/"); }
		 */

}
