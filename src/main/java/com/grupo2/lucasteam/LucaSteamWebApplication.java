package com.grupo2.lucasteam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grupo2.lucasteam.controller.JuegosController;

@SpringBootApplication
public class LucaSteamWebApplication {

	@Autowired
	JuegosController controller;

	public static void main(String[] args) {
		SpringApplication.run(LucaSteamWebApplication.class, args);

	}

}
