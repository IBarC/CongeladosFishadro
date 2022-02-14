package mainapp;

import models.Usuario;
import utils.Almacen;
import vistas.Login;

public class MainApp {
	
	public static void main(String[] args) {
		Almacen.usuarios.add(new Usuario("a", "a"));
		
		new Login();
	}
}
