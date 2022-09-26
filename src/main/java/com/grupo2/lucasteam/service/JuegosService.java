package com.grupo2.lucasteam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.lucasteam.dao.EditoresDAOI;
import com.grupo2.lucasteam.dao.GenerosDAOI;
import com.grupo2.lucasteam.dao.JuegosDAOI;
import com.grupo2.lucasteam.dao.PlataformasDAOI;
import com.grupo2.lucasteam.model.Editor;
import com.grupo2.lucasteam.model.FactoriaJuegos;
import com.grupo2.lucasteam.model.FactoriaJuegosI;
import com.grupo2.lucasteam.model.Genero;
import com.grupo2.lucasteam.model.Juego;
import com.grupo2.lucasteam.model.Plataforma;
import com.grupo2.lucasteam.util.FicheroI;
import com.grupo2.lucasteam.util.ValidacionesI;

/**
 * Clase JuegosService - contiene los métodos para conectar las peticiones de la
 * capa control con la capa de datos.
 * 
 * @author Grupo 2 - Tamara Alvarez
 * @version 1.0: 22/09/2022
 */
@Service
public class JuegosService implements JuegosServiceI {

	private static final Logger log = LoggerFactory.getLogger(FactoriaJuegos.class);

	@Autowired
	JuegosDAOI juegosDAO;
	@Autowired
	PlataformasDAOI plataformasDAO;
	@Autowired
	EditoresDAOI editoresDAO;
	@Autowired
	GenerosDAOI generosDAO;
	@Autowired
	FactoriaJuegosI factoria;
	@Autowired
	FicheroI fichero;
	@Autowired
	ValidacionesI validar;
	public static boolean CSVcargado = false;

	/**
	 * Método save() - permite guardar objetos de tipo Juego
	 * 
	 * @param juego
	 * @author Grupo 2 -Tamara Alvarez
	 * @since 1.0
	 */
	@Override
	public void altaJuego(Juego juego) {

		Plataforma p = juego.getPlataforma();
		Genero g = juego.getGenero();
		Editor e = juego.getEditor();

		if (!ValidacionesI.<Plataforma>existe(p, plataformasDAO.findAllByPlataforma(p.getPlataforma()))) {
			p = plataformasDAO.save(p);
			log.info("Guardando plataforma " + p.getPlataforma());
		} else {
			Optional<Plataforma> pOpt = plataformasDAO.findByPlataforma(p.getPlataforma());
			if (pOpt.isPresent()) {
				p = pOpt.get();
			}
			log.info("Recuperando plataforma " + p.getPlataforma());
		}
		juego.setPlataforma(p);

		if (!ValidacionesI.<Genero>existe(g, generosDAO.findAllByGenero(g.getGenero()))) {
			g = generosDAO.save(g);
			log.info("Guardando genero " + g.getGenero());
		} else {
			Optional<Genero> gOpt = generosDAO.findByGenero(g.getGenero());
			if (gOpt.isPresent())
				g = gOpt.get();
			log.info("Recuperando genero " + g.getGenero());
		}
		juego.setGenero(g);

		if (!ValidacionesI.<Editor>existe(e, editoresDAO.findAllByEditor(e.getEditor()))) {
			e = editoresDAO.save(e);
			log.info("Guardado editor " + e.getEditor());
		} else {
			Optional<Editor> eOpt = editoresDAO.findByEditor(e.getEditor());
			if (eOpt.isPresent())
				e = eOpt.get();
			log.info("Recuperando editor " + e.getEditor());
		}
		juego.setEditor(e);

		if (!ValidacionesI.<Juego>existe(juego, juegosDAO.findAllByNombre(juego.getNombre()))) {
			log.info("Guardando juego " + juego.getNombre());
			juegosDAO.save(juego);
		} else {
			log.info("El juego " + juego.getNombre() + " ya está en la BBDD.");
		}

	}

	/**
	 * Método importarCSV que utiliza la lista de juegos devuelta por leerCSV y va
	 * guardando cada juego en la base de datos. *
	 * 
	 * @author Álvaro Román Gómez Método importarCSV() - permite traer un archivo
	 *         CSV para poder trabajar con él
	 * 
	 * @param juego
	 * @author Grupo 2 -
	 * @since 1.0
	 */
	@Override
	public void importarCSV() {

		while (!CSVcargado) {
			ArrayList<Juego> juegos = fichero.importarCSV("prueba.csv");
			log.info("Importando lista de juegos en BBDD...");
			for (Juego juego : juegos) {
				if (!ValidacionesI.<Juego>existe(juego, juegosDAO.findAllByNombre(juego.getNombre()))) {
					juegosDAO.save(juego);
				}

			}
			CSVcargado = true;
		}

	}

	/**
	 * Método save() - permite guardar objetos de tipo Juego
	 *
	 * @author Grupo 2 - Carlos Jesús Pérez Márquez
	 * @since 1.0
	 */
	public List<Juego> findAll() {
		return juegosDAO.findAll();
	}

	@Override
	public void deleteById(int id) {
		juegosDAO.deleteById(id);

	}

	@Override
	public Optional<Juego> findById(int id) {
		return juegosDAO.findById(id);
	}

	@Override
	public ArrayList<Juego> findAllByEditor(String editor) {

		Optional<Editor> e = editoresDAO.findByEditor(editor);
		ArrayList<Juego> juegos;
		if (e.isPresent()) {
			juegos = juegosDAO.findAllByEditor(e.get());
			log.info("Buscando juegos del editor " + e.get().getEditor());
			return juegos;
		}

		log.error("El editor no existe o ha ocurrido otro problema...");
		return new ArrayList<>();

	}

	@Override
	public ArrayList<Juego> findAllByFecha(int fecha) {
		// TODO Auto-generated method stub
		ArrayList<Juego> juegos = juegosDAO.findAllByFecha(fecha);
		if (juegos != null) {
			log.info("Devolviendo lista de juegos del año " + fecha);

		} else {
			log.info("No hay juegos con esa fecha.");

		}
		return juegos;

	}

	@Override
	public ArrayList<Juego> findAllByGenero(String genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Juego> listaJuegosSigloXX() {
		// TODO Auto-generated method stub
		ArrayList<Juego> juegos = juegosDAO.findAllByFechaBetween(1900, 2000);
		if (juegos != null) {
			log.info("Devolviendo lista de juegos del siglo XX");

		} else {
			log.info("No hay juegos del siglo XX.");

		}

		return juegos;

	}

	@Override
	public ArrayList<Juego> listaJuegosAnniosPares() {
		// TODO Auto-generated method stub
		ArrayList<Juego> juegos = juegosDAO.findAllFechaPar();
		if (juegos != null) {
			log.info("Devolviendo lista de juegos del siglo XX");

		} else {
			log.info("No hay juegos del siglo XX.");

		}
		return juegos;

	}

	@Override
	public List<Genero> findAllGenero() {
		return generosDAO.findAll();
	}

	@Override
	public ArrayList<Juego> findAllByGenero(int idGenero) {
		Optional<Genero> gen = generosDAO.findById(idGenero);
		if (gen.isPresent()) {
			return juegosDAO.findAllByGenero(gen.get());
		}
		return new ArrayList<>();
	}

	@Override
	public ArrayList<Juego> listaJuegosVentasEuropa() {
		ArrayList<Juego> juegos = juegosDAO.findAllByMediaVentasEU();
		if (juegos != null) {
			log.info("Devolviendo lista de juegos con ventas por encima de la media de Europa.");
		} else {
			log.info("No hay juegos con ventas por encima de la media de Europa.");
		}
		return juegos;
	}

}
