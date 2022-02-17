package vistas;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import models.Producto;
import utils.Almacen;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Cesta {

	private JFrame frame;
	private JFrame parent;
	private JButton btnComprar;
	private JLabel lblTotal;
	private JLabel lblNombre;
	private JLabel lblColPrecio;
	private JLabel lblColCant;
	private JLabel lblColTotalProd;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JLabel lblTotalProd;
	private JLabel lblIconoPequenio;
	private int nProducto;
	private JButton btnAtras;
	private JButton btnProdAnterior;
	private JButton btnSiguiente;
	private double total;

	/**
	 * Create the application.
	 */
	public Cesta(JFrame parent, int nProducto) {
		this.parent = parent;
		this.nProducto = nProducto;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(238, 245, 219));
		frame.setBounds(100, 100, 554, 285);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		configureUIComponents();

		configureListeners();
	}

	private void configureUIComponents() {

		Producto p1 = Almacen.cesta.get(nProducto);

		btnComprar = new JButton("Comprar");
		btnComprar.setBackground(new Color(152, 147, 218));
		btnComprar.setFont(new Font("Sylfaen", Font.BOLD, 18));
		btnComprar.setBounds(401, 194, 127, 41);
		frame.getContentPane().add(btnComprar);

		total = 0;

		for (int i = 0; i < Almacen.cesta.size(); i++) {
			Producto p = Almacen.cesta.get(i);
			total += p.getPrecio() * p.getnProductos();
		}

		lblTotal = new JLabel("Total = " + total + " \u20AC");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblTotal.setBounds(190, 199, 177, 31);
		frame.getContentPane().add(lblTotal);

		lblNombre = new JLabel(p1.getNombre());
		lblNombre.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNombre.setBounds(140, 31, 210, 31);
		frame.getContentPane().add(lblNombre);

		lblColPrecio = new JLabel("Precio");
		lblColPrecio.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblColPrecio.setBounds(127, 73, 54, 18);
		frame.getContentPane().add(lblColPrecio);

		lblColCant = new JLabel("Cantidad");
		lblColCant.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblColCant.setBounds(217, 73, 54, 18);
		frame.getContentPane().add(lblColCant);

		lblColTotalProd = new JLabel("Total producto");
		lblColTotalProd.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblColTotalProd.setBounds(345, 73, 113, 18);
		frame.getContentPane().add(lblColTotalProd);

		lblPrecio = new JLabel(p1.getPrecio() + "");
		lblPrecio.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblPrecio.setBounds(127, 102, 75, 21);
		frame.getContentPane().add(lblPrecio);

		int NumeroProductos = p1.getnProductos();

		lblCantidad = new JLabel(NumeroProductos + "");
		lblCantidad.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblCantidad.setBounds(217, 102, 75, 21);
		frame.getContentPane().add(lblCantidad);

		//Para que salgan poquitos decimales lo convierto a float
		float totalProducto = (float)(p1.getPrecio()) * p1.getnProductos();

		lblTotalProd = new JLabel(totalProducto + "");
		lblTotalProd.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblTotalProd.setBounds(345, 102, 75, 21);
		frame.getContentPane().add(lblTotalProd);

		lblIconoPequenio = new JLabel("");
		lblIconoPequenio.setIcon(new ImageIcon("fotoos/nombre-y-sobra2CHIQUITO2xd.png"));
		lblIconoPequenio.setBackground(Color.WHITE);
		lblIconoPequenio.setBounds(10, 5, 102, 57);
		frame.getContentPane().add(lblIconoPequenio);

		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		btnAtras.setBounds(10, 214, 65, 21);
		frame.getContentPane().add(btnAtras);

		btnProdAnterior = new JButton("Anterior");
		btnProdAnterior.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		btnProdAnterior.setBounds(10, 142, 92, 23);
		frame.getContentPane().add(btnProdAnterior);

		if (nProducto == 0) {
			btnProdAnterior.setVisible(false);
		}

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		btnSiguiente.setBounds(420, 142, 108, 23);
		frame.getContentPane().add(btnSiguiente);

		if (nProducto + 1 == Almacen.cesta.size()) {
			btnSiguiente.setVisible(false);
		}
	}

	private void configureListeners() {
		btnProdAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nProducto--;
				frame.dispose();
				new Cesta(frame, nProducto);
			}
		});

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nProducto++;
				frame.dispose();
				new Cesta(frame, nProducto);
			}
		});

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuPrincipal(MenuPrincipal.parent, 0);
				frame.dispose();
			}
		});

		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(btnComprar, "Su total es: " + total
						+ " €.\n¿Está seguro de que quiere realizar la compra?") == JOptionPane.OK_OPTION) {
					JOptionPane.showMessageDialog(btnComprar, "Gracias por comprar en Congelados Fishadro :)");
					frame.dispose();
					Almacen.cesta.clear();
					new MenuPrincipal(MenuPrincipal.parent, 0);
				}
			}
		});
	}
}
