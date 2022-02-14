package vistas;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import utils.Almacen;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField txtUsuario;
	private JLabel lblImagen;
	private JLabel lblCongelados;
	private JLabel lblIniciarSesion;
	private JLabel lblUsuario;
	private JLabel lblContrasenia;
	private JButton btnCrearCuenta;
	private JButton btnIniciarS;
	private JPasswordField txtContrasenia;

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(114, 114, 126));
		frame.setBounds(100, 100, 577, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		configureUIComponents();
		configureListeners();
	}

	private void configureUIComponents() {
		lblIniciarSesion = new JLabel("Iniciar sesi\u00F3n");
		lblIniciarSesion.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesion.setBounds(122, 159, 300, 41);
		frame.getContentPane().add(lblIniciarSesion);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(186, 233, 173, 27);
		frame.getContentPane().add(txtUsuario);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblUsuario.setBounds(242, 215, 54, 18);
		frame.getContentPane().add(lblUsuario);

		lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasenia.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblContrasenia.setBounds(230, 269, 80, 18);
		frame.getContentPane().add(lblContrasenia);

		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon("fotoos/nombre-y-sobra2.png"));
		lblImagen.setBounds(115, 29, 313, 227);
		frame.getContentPane().add(lblImagen);

		lblCongelados = new JLabel("Congelados");
		lblCongelados.setForeground(new Color(176, 196, 222));
		lblCongelados.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblCongelados.setHorizontalAlignment(SwingConstants.CENTER);
		lblCongelados.setBounds(199, 21, 160, 28);
		frame.getContentPane().add(lblCongelados);

		btnIniciarS = new JButton("Iniciar sesi\u00F3n");
		btnIniciarS.setBounds(408, 244, 116, 23);
		frame.getContentPane().add(btnIniciarS);

		btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.setBounds(24, 244, 109, 23);
		frame.getContentPane().add(btnCrearCuenta);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(186, 287, 173, 27);
		frame.getContentPane().add(txtContrasenia);

	}

	private void configureListeners() {
		btnIniciarS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				String contrasenia = new String (txtContrasenia.getPassword());
				comprobarLogin(usuario, contrasenia);
			}
		});

		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register(frame);
				frame.setVisible(false);
			}
		});
	}
	
	private void comprobarLogin(String username, String password) {

		int i = 0;
		boolean usuCorrecto = false;
		do {
			if (Almacen.usuarios.get(i).nombre.equals(username) && Almacen.usuarios.get(i).contr.equals(password)) {
				new MenuPrincipal();
				frame.setVisible(false); // Se oculta la visibilidad
				usuCorrecto = true;
			} else {
				i++;
			}
		} while (i < Almacen.usuarios.size() && !usuCorrecto);

		if (!usuCorrecto) {
			JOptionPane.showMessageDialog(btnIniciarS, "Login incorrecto");
		}
	}
}
