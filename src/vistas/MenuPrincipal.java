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

import utils.Almacen;

import java.awt.Font;

public class MenuPrincipal {

	private JFrame frame;
	private JFrame parent;
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
		this.parent = parent;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(238, 245, 219));
		frame.setBounds(100, 100, 577, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		configureUIComponents();
		configureListeners();
	}

	private void configureUIComponents() {
		btnCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnCerrarSesion.setBounds(10, 310, 124, 23);
		frame.getContentPane().add(btnCerrarSesion);

		btnCesta = new JButton("");
		btnCesta.setBackground(new Color(238, 245, 219));
		btnCesta.setIcon(new ImageIcon("fotoos/cestica2.png"));
		btnCesta.setBounds(484, 11, 67, 53);
		frame.getContentPane().add(btnCesta);

		lblIconoPequenio = new JLabel("");
		lblIconoPequenio.setIcon(new ImageIcon("fotoos/nombre-y-sobra2CHIQUITO2xd.png"));
		lblIconoPequenio.setBackground(new Color(255, 255, 255));
		lblIconoPequenio.setBounds(10, 11, 102, 57);
		frame.getContentPane().add(lblIconoPequenio);

		lblNombre = new JLabel(Almacen.productos.get(nProducto).getNombre());
		lblNombre.setFont(new Font("Sylfaen", Font.BOLD, 17));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(183, 163, 182, 23);
		frame.getContentPane().add(lblNombre);

		lblDescripcion = new JLabel(Almacen.productos.get(nProducto).getDescripción());
		lblDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcion.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblDescripcion.setBounds(23, 197, 387, 23);
		frame.getContentPane().add(lblDescripcion);

		lblPrecio = new JLabel("Precio: " + Almacen.productos.get(nProducto).getPrecio() + " \u20AC");
		lblPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecio.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblPrecio.setBounds(23, 231, 387, 23);
		frame.getContentPane().add(lblPrecio);

		btnAniadirACesta = new JButton("A\u00F1adir a la cesta");
		btnAniadirACesta.setBounds(347, 265, 139, 23);
		frame.getContentPane().add(btnAniadirACesta);

		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(10, 145, 89, 23);
		frame.getContentPane().add(btnAtras);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(462, 145, 89, 23);
		frame.getContentPane().add(btnSiguiente);
	}

	private void configureListeners() {
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				parent.setVisible(true);
			}
		});

		btnCesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Cesta(frame, 0);
			}
		});

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nProducto == 0) {
					nProducto = Almacen.productos.size() - 1;
					frame.dispose();
					new MenuPrincipal(frame, nProducto);
				} else {
					nProducto--;
					frame.dispose();
					new MenuPrincipal(frame, nProducto);
				}
			}
		});

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nProducto + 1 == Almacen.productos.size()) {
					nProducto = 0;
					frame.dispose();
					new MenuPrincipal(frame, nProducto);
				} else {
					nProducto++;
					frame.dispose();
					new MenuPrincipal(frame, nProducto);
				}
			}
		});

		btnAniadirACesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean prodEncontrado=false;
				if (Almacen.cesta.size() == 0) {
					Almacen.cesta.add(Almacen.productos.get(nProducto));
					Almacen.productos.get(nProducto).nProductos=1;
					prodEncontrado=true;
				} else {
					int i = 0;
					do {
						if(Almacen.cesta.get(i).equals(Almacen.productos.get(nProducto))) {
							Almacen.cesta.get(i).nProductos++;
							prodEncontrado=true;
						} else {
							Almacen.cesta.add(Almacen.productos.get(nProducto));
							Almacen.productos.get(nProducto).nProductos=1;
							prodEncontrado=true;
						}
						i++;
					} while (prodEncontrado && i < Almacen.cesta.size());
				}
				if (prodEncontrado) {
					JOptionPane.showMessageDialog(btnAniadirACesta, "El producto se ha añadido a la cesta.");
				}
			}
		});
	}
}
