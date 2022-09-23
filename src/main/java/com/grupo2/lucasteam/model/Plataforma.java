package com.grupo2.lucasteam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * Clase Plataforma que representa la entidad plataforma reflejada en la
 * base de datos.
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 * 
 */

@Entity
@Table(name="plataforma")
@Data
public class Plataforma {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
}
