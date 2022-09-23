package com.grupo2.lucasteam;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grupo2.lucasteam.model.Juego;
import com.grupo2.lucasteam.util.FicheroI;

@SpringBootApplication
public class LucaSteamWebApplication implements CommandLineRunner {

	@Autowired
	FicheroI f;

	public static void main(String[] args) {
		SpringApplication.run(LucaSteamWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		ArrayList<Juego> juegos = f.importarCSV("prueba.csv");

		for (Juego juego : juegos) {
			System.out.println(juego);
		}

	}

}
