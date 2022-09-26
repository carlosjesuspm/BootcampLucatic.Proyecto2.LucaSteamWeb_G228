package com.grupo2.lucasteam.model;

import java.util.Objects;

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

	/**
	 * Método equals para comparar generos y definir cuándo son iguales. En este
	 * caso serán iguales si coinciden todos sus atributos.
	 * 
	 * @param obj - objeto instanciado.
	 * @return boolean
	 * @author Álvaro Román Gómez
	 * @since 1.0
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genero other = (Genero) obj;
		return Objects.equals(genero, other.genero);
	}

	@Override
	public int hashCode() {
		return Objects.hash(genero);
	}

}
