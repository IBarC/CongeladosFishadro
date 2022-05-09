package models;

/**
 * Clase de ayuda para añadir los productos seleccionados por el cliente
 * Extiende de la clase Producto
 * 
 * @author Irene
 *
 * @see Producto
 */
public class ProdutosSeleccionados extends Producto {

	/**
	 * Constructor de la clase ProductosSeleccionados
	 * 
	 * @param nombre
	 * @param precio
	 * @param descripción
	 * @param foto
	 * 
	 * @see Producto
	 */
	public ProdutosSeleccionados(String nombre, double precio, String descripción, int foto) {
		super(nombre, precio, descripción, foto);

	}
}
