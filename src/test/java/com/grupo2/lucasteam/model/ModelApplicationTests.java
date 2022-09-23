package com.grupo2.lucasteam.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

//@SpringBootTest
public class ModelApplicationTests {

	@Test
	void testEditor() {
		// TODO Auto-generated method stub

		// Given:
		Editor editor = new Editor();

		editor.setId(0);
		editor.setEditor("Alvaro");

		// Then:
		assertNotNull(editor);
		assertEquals("Alvaro", editor.getEditor());
		assertEquals(0, editor.getId());

	}

	@Test
	void testGenero() {
		// TODO Auto-generated method stub

		// Given:
		Genero genero = new Genero();

		genero.setId(0);
		genero.setGenero("Action");

		// Then:
		assertNotNull(genero);
		assertEquals("Action", genero.getGenero());
		assertEquals(0, genero.getId());

	}

	@Test
	void testPlataforma() {
		// TODO Auto-generated method stub

		// Given:
		Plataforma plataforma = new Plataforma();

		plataforma.setId(0);
		plataforma.setPlataforma("Alvaro");

		// Then:
		assertNotNull(plataforma);
		assertEquals("Alvaro", plataforma.getPlataforma());
		assertEquals(0, plataforma.getId());

	}

	@Test
	void testJuego() {
		// TODO Auto-generated method stub

		// Given:
		Juego juego = new Juego();

		juego.setId(0);
		juego.setRango(1);
		juego.setNombre("Alvaro");

		// Then:
		assertNotNull(juego);
		assertEquals("Alvaro", juego.getNombre());
		assertEquals(0, juego.getId());
		assertEquals(1, juego.getRango());

	}

}
