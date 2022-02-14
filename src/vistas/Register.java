package vistas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Register {

	private JFrame frRegister;
	private JFrame parent;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the application.
	 */
	public Register(JFrame parent) {
		this.parent = parent;
		initialize();
		this.frRegister.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frRegister = new JFrame();
		frRegister.getContentPane().setBackground(new Color(114, 114, 126));
		frRegister.setBounds(100, 100, 577, 383);
		frRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frRegister.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(254, 154, 173, 27);
		frRegister.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(254, 217, 173, 27);
		frRegister.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(254, 277, 173, 27);
		frRegister.getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblNewLabel.setBounds(140, 163, 79, 14);
		frRegister.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(140, 223, 79, 14);
		frRegister.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirmar contase\u00F1a:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblNewLabel_2.setBounds(74, 283, 145, 14);
		frRegister.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Atr\u00E1s");
		btnNewButton.setBounds(10, 312, 89, 23);
		frRegister.getContentPane().add(btnNewButton);
		
		JButton btnCrearUsuario = new JButton("Crear usuario");
		btnCrearUsuario.setBounds(430, 312, 123, 23);
		frRegister.getContentPane().add(btnCrearUsuario);
		
		JLabel lblNewLabel_3 = new JLabel("Crear usuario");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblNewLabel_3.setBounds(172, 58, 221, 27);
		frRegister.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Irene\\Desktop\\CFGS\\1\u00BA\\Programacion\\CongeladosFishadro\\fotoos\\nombre-y-sobra2CHIQUITO2xd.png"));
		lblNewLabel_4.setBounds(10, 11, 102, 57);
		frRegister.getContentPane().add(lblNewLabel_4);
		
		configureUIComponents();
		
		configureListeners();
	}
	
	private void configureUIComponents() {
		
	}
	
	private void configureListeners() {
	}
}
