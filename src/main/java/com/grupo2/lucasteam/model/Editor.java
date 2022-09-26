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
 * Clase Editor que representa la entidad editor reflejada en la base de datos.
 * 
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 * 
 */

@Entity
@Table(name = "editor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Editor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String editor;

	/**
	 * Método equals para comparar editores y definir cuándo son iguales. En este
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
		Editor other = (Editor) obj;
		return Objects.equals(editor, other.editor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(editor);
	}

}
