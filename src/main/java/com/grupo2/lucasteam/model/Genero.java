package com.grupo2.lucasteam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase Género que representa la entidad género reflejada en la base de datos.
 * 
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 * 
 */

@Entity
@Table(name = "genero")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String genero;

}
