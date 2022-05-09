package models;

/**
 * Clase que declara un objeto de tipo Usuario
 * 
 * @author Irene
 *
 */
public class Usuario {

	public String nombre;
	public String contr;

	/**
	 * Constructor de la clase Usuario
	 * 
	 * @param nombre Nombre del usuario
	 * @param contr  Contraseña del usuario
	 */
	public Usuario(String nombre, String contr) {
		super();
		this.nombre = nombre;
		this.contr = contr;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContr() {
		return contr;
	}

	public void setContr(String contr) {
		this.contr = contr;
	}
}
