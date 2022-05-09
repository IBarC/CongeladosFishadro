package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;

import models.Usuario;
import utils.Almacen;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase que contiene la vista del registro y su lógica
 * 
 * @author Irene
 *
 */
public class Register {

	private JFrame frRegister;
	private JFrame parent;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JPasswordField txtCompPassword;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnAtras;
	private JButton btnCrearUsuario;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Constructor de la clase Register
	 * 
	 * @param parent Frame padre indicando de qué vista proviene
	 */
	public Register(JFrame parent) {
		this.parent = parent;
		initialize();
		this.frRegister.setVisible(true);
	}

	/**
	 * Inicializa el contenido de la clase Register
	 */
	private void initialize() {
		frRegister = new JFrame();
		frRegister.getContentPane().setBackground(new Color(114, 114, 126));
		frRegister.setBounds(100, 100, 577, 383);
		frRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frRegister.getContentPane().setLayout(null);

		configureUIComponents();

		configureListeners();
	}

	/**
	 * Configuración de la parte visual de la clase Register
	 */
	private void configureUIComponents() {
		txtUsuario = new JTextField();
		txtUsuario.setBounds(254, 154, 173, 27);
		frRegister.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(254, 217, 173, 27);
		frRegister.getContentPane().add(txtPassword);

		txtCompPassword = new JPasswordField();
		txtCompPassword.setBounds(254, 277, 173, 27);
		frRegister.getContentPane().add(txtCompPassword);

		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblNewLabel.setBounds(140, 159, 79, 23);
		frRegister.getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(140, 223, 79, 20);
		frRegister.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Confirmar contase\u00F1a:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblNewLabel_2.setBounds(74, 283, 145, 20);
		frRegister.getContentPane().add(lblNewLabel_2);

		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(10, 312, 89, 23);
		frRegister.getContentPane().add(btnAtras);

		btnCrearUsuario = new JButton("Crear usuario");
		btnCrearUsuario.setBounds(430, 312, 123, 23);
		frRegister.getContentPane().add(btnCrearUsuario);

		lblNewLabel_3 = new JLabel("Crear usuario");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_3.setBounds(172, 58, 221, 27);
		frRegister.getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("fotoos/nombre-y-sobra2CHIQUITO2xd.png"));
		lblNewLabel_4.setBounds(10, 11, 102, 57);
		frRegister.getContentPane().add(lblNewLabel_4);
	}

	/**
	 * Configuración de los botones la clase de Register
	 */
	private void configureListeners() {
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frRegister.dispose();
				parent.setVisible(true);
			}
		});

		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				boolean usuEncontrado = false;
				int i = 0;
				do {
					if (usuario.equalsIgnoreCase(Almacen.usuarios.get(i).getNombre())) {
						JOptionPane.showMessageDialog(btnCrearUsuario, "Ya existe un usuario con ese nombre");
						usuEncontrado = true;
					}
					i++;
				} while (usuEncontrado && i < Almacen.usuarios.size());

				if (!usuEncontrado) {
					comprobarContr();
				}
			}
		});
	}

	/**
	 * Método que comprueba si las contraseñas introducidas son iguales
	 */
	private void comprobarContr() {
		String usuario = txtUsuario.getText();
		String contr = new String(txtPassword.getPassword());
		String contr2 = new String(txtCompPassword.getPassword());

		if (contr.equals(contr2)) {
			JOptionPane.showMessageDialog(btnCrearUsuario, "Usuario creado");
			Almacen.usuarios.add(new Usuario(usuario, contr));
			frRegister.dispose();
			parent.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(btnCrearUsuario, "Datos erroneos");
		}
	}
}
