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
		m.addAttribute("listaGeneros", service.findAllGenero());
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
	 * Metodo para crear un juego
	 * 
	 * @param juego
	 * @param m
	 * @return {@code formularioAlta}
	 * @author Grupo 2 - Tamara Alvarez
	 * @since 1.0
	 */
	@GetMapping("/altaJuego")
	public String newJuego(Juego juego, Model m) {
		m.addAttribute("juego", juego);
		m.addAttribute("listaGeneros", service.findAllGenero());
		return "formularioAlta";
	}

	/**
	 * Metodo para guardar el juego creado
	 * 
	 * @param j
	 * @return {@code redirect:/}
	 * @author Grupo 2 - Tamara Alvarez
	 * @since 1.0
	 */
	@PostMapping("/save")
	public String save(Juego j) {
		service.altaJuego(j);
		return ("redirect:/");
	}

	/**
	 * Metodo para filtrar juegos por Editores y mostrarlos.
	 * 
	 * @param @RequestParam("editor") String editor
	 * @return "listaJuegos"
	 */
	@GetMapping("/editor")
	public String listaJuegosEditor(@RequestParam("editor") String editor, Model m) {
		log.info("Obteniendo juegos de editor " + editor + " en JuegosController.");
		m.addAttribute("listaJuegos", service.findAllByEditor(editor));
		return "listaJuegos";
	}

	/**
	 * Metodo para filtrar juegos por Plataforma y mostrarlos. Metodo para filtrar
	 * juegos por Genero y mostrarlos.
	 * 
	 * @param @RequestParam("pltaforma") String platforma
	 * @param @RequestParam("genero")    String genero
	 * @return "listaJuegos"
	 */
	@GetMapping("/genero")
	public String listaJuegosGenero(@RequestParam("id") int idGenero, Model m) {
		m.addAttribute("listaJuegos", service.findAllByGenero(idGenero));
		m.addAttribute("listaGeneros", service.findAllGenero());
		return "listaJuegos";
	}

	/**
	 * Metodo para filtrar juegos por Año y mostrarlos.
	 * 
	 * @param @RequestParam("fecha") int genero
	 * @return "listaJuegos"
	 */
	@GetMapping("/fecha")
	public String listaJuegosFecha(@RequestParam("fecha") int fecha, Model m) {
		log.info("Obteniendo juegos del año " + fecha + " en JuegosController...");
		m.addAttribute("listaJuegos", service.findAllByFecha(fecha));
		m.addAttribute("listaGeneros", service.findAllGenero());
		return "listaJuegos";
	}

	/**
	 * Metodo para filtrar los juegos del siglo XX y mostrarlos.
	 * 
	 * @return "listaJuegos"
	 */
	@GetMapping("/sigloxx")
	public String listaJuegosSigloXX(Model m) {
		log.info("Obteniendo juegos del siglo XX en JuegosController...");
		m.addAttribute("listaJuegos", service.listaJuegosSigloXX());
		m.addAttribute("listaGeneros", service.findAllGenero());
		return "listaJuegos";
	}

	/**
	 * Metodo para filtrar los juegos de años pares y mostrarlos.
	 * 
	 * @return "listaJuegos"
	 */
	@GetMapping("/anniospares")
	public String listaJuegosAnniosPares(Model m) {
		log.info("Obteniendo juegos de años pares en JuegosController...");
		m.addAttribute("listaJuegos", service.listaJuegosAnniosPares());
		m.addAttribute("listaGeneros", service.findAllGenero());
		return "listaJuegos";
	}

	/**
	 * Metodo para filtrar los juegos con ventas por encima de la media europea.
	 * 
	 * @return "listaJuegos"
	 */
	@GetMapping("/ventaseuropa")
	public String listaJuegosVentasEuropa(Model m) {
		log.info("Obteniendo juegos con ventas mayores que la media europea en JuegosController...");
		m.addAttribute("listaJuegos", service.listaJuegosVentasEuropa());
		m.addAttribute("listaGeneros", service.findAllGenero());
		return "listaJuegos";
	}

}
