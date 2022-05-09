package models;

/**
 * Clase de ayuda para a�adir los productos seleccionados por el cliente
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
	 * @param descripci�n
	 * @param foto
	 * 
	 * @see Producto
	 */
	public ProdutosSeleccionados(String nombre, double precio, String descripci�n, int foto) {
		super(nombre, precio, descripci�n, foto);

	}
}
