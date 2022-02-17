package vistas;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import models.Producto;
import utils.Almacen;

import java.awt.Font;

public class MenuPrincipal {

	private JFrame frMenuPrincipal;
	public static JFrame parent;
	private JButton btnCerrarSesion;
	private JButton btnCesta;
	private JLabel lblIconoPequenio;
	private JLabel lblNombre;
	private int nProducto;
	private JLabel lblDescripcion;
	private JLabel lblPrecio;
	private JButton btnAniadirACesta;
	private JButton btnAtras;
	private JButton btnSiguiente;

	/**
	 * Create the application.
	 */
	public MenuPrincipal(JFrame parent, int nProducto) {
		this.nProducto = nProducto;
		MenuPrincipal.parent = parent;
		initialize();
		this.frMenuPrincipal.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frMenuPrincipal = new JFrame();
		frMenuPrincipal.getContentPane().setBackground(new Color(238, 245, 219));
		frMenuPrincipal.setBounds(100, 100, 577, 383);
		frMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frMenuPrincipal.getContentPane().setLayout(null);

		configureUIComponents();
		configureListeners();
	}

	private void configureUIComponents() {
		btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setBounds(10, 310, 124, 23);
		frMenuPrincipal.getContentPane().add(btnCerrarSesion);

		btnCesta = new JButton("");
		btnCesta.setBackground(new Color(238, 245, 219));
		btnCesta.setIcon(new ImageIcon("fotoos/cestica2.png"));
		btnCesta.setBounds(484, 11, 67, 53);
		frMenuPrincipal.getContentPane().add(btnCesta);

		lblIconoPequenio = new JLabel("");
		lblIconoPequenio.setIcon(new ImageIcon("fotoos/nombre-y-sobra2CHIQUITO2xd.png"));
		lblIconoPequenio.setBackground(new Color(255, 255, 255));
		lblIconoPequenio.setBounds(10, 11, 102, 57);
		frMenuPrincipal.getContentPane().add(lblIconoPequenio);

		lblNombre = new JLabel(Almacen.productos.get(nProducto).getNombre());
		lblNombre.setFont(new Font("Sylfaen", Font.BOLD, 17));
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setBounds(146, 209, 182, 23);
		frMenuPrincipal.getContentPane().add(lblNombre);

		lblDescripcion = new JLabel(Almacen.productos.get(nProducto).getDescripción());
		lblDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcion.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblDescripcion.setBounds(23, 256, 482, 23);
		frMenuPrincipal.getContentPane().add(lblDescripcion);

		lblPrecio = new JLabel("Precio: " + Almacen.productos.get(nProducto).getPrecio() + " \u20AC");
		lblPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecio.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblPrecio.setBounds(350, 208, 170, 27);
		frMenuPrincipal.getContentPane().add(lblPrecio);

		btnAniadirACesta = new JButton("A\u00F1adir a la cesta");
		btnAniadirACesta.setBounds(381, 290, 139, 23);
		frMenuPrincipal.getContentPane().add(btnAniadirACesta);

		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(10, 145, 89, 23);
		frMenuPrincipal.getContentPane().add(btnAtras);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(462, 145, 89, 23);
		frMenuPrincipal.getContentPane().add(btnSiguiente);
		
		JLabel lblFoto = new JLabel("");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setIcon(new ImageIcon("fotoos/"+Almacen.productos.get(nProducto).getFoto()+".jpg"));
		lblFoto.setBounds(146, 11, 259, 186);
		frMenuPrincipal.getContentPane().add(lblFoto);
	}

	private void configureListeners() {
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				frMenuPrincipal.dispose();
			}
		});

		btnCesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Almacen.cesta.isEmpty()) {
					JOptionPane.showMessageDialog(btnCesta, "La cesta está vacía");
				} else {
					frMenuPrincipal.setVisible(false);
					new Cesta(frMenuPrincipal, 0);
				}
				
			}
		});

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nProducto == 0) {
					nProducto = Almacen.productos.size() - 1;
					frMenuPrincipal.dispose();
					new MenuPrincipal(frMenuPrincipal, nProducto);
				} else {
					nProducto--;
					frMenuPrincipal.dispose();
					new MenuPrincipal(frMenuPrincipal, nProducto);
				}
			}
		});

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nProducto + 1 == Almacen.productos.size()) {
					nProducto = 0;
					frMenuPrincipal.dispose();
					new MenuPrincipal(frMenuPrincipal, nProducto);
				} else {
					nProducto++;
					frMenuPrincipal.dispose();
					new MenuPrincipal(frMenuPrincipal, nProducto);
				}
			}
		});

		btnAniadirACesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto p = Almacen.productos.get(nProducto);
				boolean prodEncontrado=false;
				
				if (Almacen.cesta.isEmpty()) {
					p.setnProductos(1);
					Almacen.cesta.add(p);
				} else {
					int i = 0;
					do {
						if(Almacen.cesta.get(i).equals(p)) {
							prodEncontrado=true;
						}
						i++;
					} while (!prodEncontrado && i < Almacen.cesta.size());
					
					if (prodEncontrado) {
						p.setnProductos(p.getnProductos()+1);
					} else {
						p.setnProductos(1);
						Almacen.cesta.add(p);
					}
				}
				
				JOptionPane.showMessageDialog(btnAniadirACesta, "El producto se ha añadido a la cesta.");
			}
		});
	}
}
