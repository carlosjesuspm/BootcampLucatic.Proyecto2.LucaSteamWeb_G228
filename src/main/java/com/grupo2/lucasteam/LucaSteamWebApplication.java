package com.grupo2.lucasteam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.grupo2.lucasteam.util.FicheroI;

@SpringBootApplication
public class LucaSteamWebApplication {

	@Autowired
	FicheroI f;

	public static void main(String[] args) {
		SpringApplication.run(LucaSteamWebApplication.class, args);
	}

}
