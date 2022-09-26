package com.grupo2.lucasteam.model;

import java.time.Year;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "juegos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Juego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int rango;
	private String nombre;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_plataforma", referencedColumnName = "id")
	private Plataforma plataforma;
	private int fecha = Year.now().getValue();
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_genero", referencedColumnName = "id")
	private Genero genero;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_editor", referencedColumnName = "id")
	private Editor editor;
	private double NA_ventas;
	private double EU_ventas;
	private double JP_ventas;
	private double otras_ventas;
	private double ventas_globales;

	/**
	 * Método equals para comparar juegos y definir cuándo son iguales. En este caso
	 * serán iguales si coinciden: nombre, fecha, editor, plataforma y genero.
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
		if (!(obj instanceof Juego))
			return false;
		Juego other = (Juego) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(editor, other.editor)
				&& Objects.equals(genero, other.genero) && Objects.equals(plataforma, other.plataforma)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(EU_ventas, JP_ventas, NA_ventas, fecha, id, editor, genero, plataforma, nombre,
				otras_ventas, rango, ventas_globales);
	}

}
