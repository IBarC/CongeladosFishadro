package vistas;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Login {

	private JFrame frame;
	private JTextField txtContrasenia;
	private JTextField txtUsuario;
	private JLabel lblImagen;
	private JLabel lblCongelados;

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
		frame.getContentPane().setBackground(new Color(255, 234, 163));
		frame.setBounds(100, 100, 577, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		configureUIComponents();
	}
	
	private void configureUIComponents() {
		JLabel lblIniciarSesion = new JLabel("Iniciar sesi\u00F3n");
		lblIniciarSesion.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesion.setBounds(122, 159, 300, 41);
		frame.getContentPane().add(lblIniciarSesion);
		
		txtContrasenia = new JTextField();
		txtContrasenia.setBounds(186, 295, 173, 27);
		frame.getContentPane().add(txtContrasenia);
		txtContrasenia.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(186, 229, 173, 27);
		frame.getContentPane().add(txtUsuario);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblUsuario.setBounds(242, 211, 54, 18);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasenia.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblContrasenia.setBounds(230, 277, 80, 18);
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
		
	}
}
