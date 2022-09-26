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
 * Clase Plataforma que representa la entidad plataforma reflejada en la base de
 * datos.
 * 
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 * 
 */

@Entity
@Table(name = "plataforma")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plataforma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String plataforma;

	/**
	 * Método equals para comparar plataformas y definir cuándo son iguales. En este
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
		Plataforma other = (Plataforma) obj;
		return Objects.equals(plataforma, other.plataforma);
	}

	@Override
	public int hashCode() {
		return Objects.hash(plataforma);
	}

}
