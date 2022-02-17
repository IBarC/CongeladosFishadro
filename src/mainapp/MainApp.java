package mainapp;

import models.Producto;
import models.Usuario;
import utils.Almacen;
import vistas.Login;

public class MainApp {

	public static void main(String[] args) {
		Almacen.usuarios.add(new Usuario("a", "a"));
		Producto p1 = new Producto("Gambas peladas", 5.76,
				"Las gambas peladas de Pescanova son perfectas para cualquier ocasión.", 1);
		Almacen.productos.add(p1);

		Producto p2 = new Producto("Taro Mochi", 2.65, "Paquete de 8 unidades sabor taro", 2);
		Almacen.productos.add(p2);

		Almacen.productos.add(new Producto("Tarta de queso", 1.6, "Tarta de queso sin gluten envase 180 g", 3));

		new Login();
	}
}
