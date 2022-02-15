package mainapp;

import models.Producto;
import models.Usuario;
import utils.Almacen;
import vistas.Login;

public class MainApp {

	public static void main(String[] args) {
		Almacen.usuarios.add(new Usuario("a", "a"));
		Almacen.productos.add(new Producto("Gambas", 3.0, "Ricas ricas", 1));
		Almacen.productos.add(new Producto("Mochis", 2.0, "De arros", 2));


		new Login();
	}
}
