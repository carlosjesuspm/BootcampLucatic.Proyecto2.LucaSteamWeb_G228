package com.grupo2.lucasteam.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grupo2.lucasteam.model.Juego;

public class FicheroApplicationTests {

	@Autowired
	FicheroI f;

	@Test
	void testImportarCSV1() {

		ArrayList<Juego> juegos = f.importarCSV("prueba.csv");

		for (Juego juego : juegos) {
			assertNotNull(juego);
		}

	}

	@Test
	void testImportarCSV2() {

		ArrayList<Juego> juegos = f.importarCSV("prueba.csv");

		for (Juego juego : juegos) {
			assertNotNull(juego);
			assertEquals(juego.getNombre(), juego.getNombre());
		}

	}

}
