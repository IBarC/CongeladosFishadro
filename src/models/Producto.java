package models;

public class Producto {

	private String nombre;
	private double precio;
	private String descripción;
	private int foto;
	
	public Producto(String nombre, double precio, String descripción, int foto) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descripción = descripción;
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public String getDescripción() {
		return descripción;
	}

	public int getFoto() {
		return foto;
	}
	
}
