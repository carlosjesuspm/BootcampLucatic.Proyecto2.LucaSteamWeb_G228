package com.grupo2.lucasteam.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FicheroApplicationTests {

	@Autowired
	FicheroI f;

//	@Test
//	void testImportarCSV1() {
//
//		Set<Juego> juegos = f.importarCSV("prueba.csv");
//
//		assertNotNull(juegos.get(0));
//
//	}
//
//	@Test
//	void testImportarCSV2() {
//
//		ArrayList<Juego> juegos = f.importarCSV("prueba.csv");
//
//		for (Juego juego : juegos) {
//			assertNotNull(juego);
//			assertEquals(juego.getNombre(), juego.getNombre());
//		}
//
//	}

}
