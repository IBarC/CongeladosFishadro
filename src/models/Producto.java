package models;

/**
 * Clase que declara un objeto de tipo Producto
 * 
 * @author alumno
 *
 */
public class Producto {

	private String nombre;
	private double precio;
	private String descripci�n;
	private int foto;
	private int nProductos;

	/**
	 * Constructor de la clase Producto
	 * 
	 * @param nombre      Nombre del producto
	 * @param precio      Precio del producto
	 * @param descripci�n Breve descripcion del producto
	 * @param foto        Imagen del producto
	 */
	public Producto(String nombre, double precio, String descripci�n, int foto) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descripci�n = descripci�n;
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public String getDescripci�n() {
		return descripci�n;
	}

	public int getFoto() {
		return foto;
	}

	public int getnProductos() {
		return nProductos;
	}

	public void setnProductos(int nProductos) {
		this.nProductos = nProductos;
	}

}
