package utils;

import java.util.ArrayList;

import models.Producto;
import models.Usuario;

/**
 * Clase para almacenar datos de usuarios, productos y productos seleccionados
 * 
 * @author Irene
 * 
 * @see Usuario
 * @see Producto
 *
 */
public class Almacen {

	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public static ArrayList<Producto> productos = new ArrayList<Producto>();
	public static ArrayList<Producto> cesta = new ArrayList<Producto>();
}
