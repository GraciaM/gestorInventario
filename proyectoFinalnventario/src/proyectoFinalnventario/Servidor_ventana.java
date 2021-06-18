package proyectoFinalnventario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Servidor_ventana extends JFrame {

	private JPanel contentPane;
	private String port;
	private JTextField Referencia;
	private JTextField Nombre;
	private JTextField Precio_Total;
	private JTextField Precio_Unidad;
	private JButton Hacer_Pedido;
	private JLabel lblReferencia;
	private JLabel lblNombre;
	private JLabel lblCantidad;
	private JLabel lblPrecio;
	private JLabel lblTotal;
	private ServerSocket server;
	private Socket cliente;
	private ObjectOutputStream outObjeto;
	private ObjectInputStream inObjeto;
	private Pedido ped;

	/**
	 * Create the frame.
	 */
	public Servidor_ventana() {
		setTitle("Hacer pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton conectar = new JButton("Conectar con proveedor");
		conectar.setForeground(new Color(0, 206, 209));
		conectar.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 15));
		conectar.setBounds(10, 10, 218, 32);
		contentPane.add(conectar);
		conectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean connect = false;
				port = JOptionPane.showInputDialog(contentPane, "Port");

				if (!connect) {
					try {
						server = new ServerSocket(Integer.parseInt(port));
						cliente = server.accept();
					} catch (NumberFormatException | IOException e) {
						e.printStackTrace();
					}
				}

			}

		});

		Referencia = new JTextField();
		Referencia.setBounds(110, 52, 305, 38);
		contentPane.add(Referencia);
		Referencia.setColumns(10);

		Nombre = new JTextField();
		Nombre.setColumns(10);
		Nombre.setBounds(110, 96, 305, 38);
		contentPane.add(Nombre);

		Precio_Total = new JTextField();
		Precio_Total.setColumns(10);
		Precio_Total.setBounds(110, 248, 109, 36);
		contentPane.add(Precio_Total);

		Precio_Unidad = new JTextField();
		Precio_Unidad.setColumns(10);
		Precio_Unidad.setBounds(110, 145, 96, 38);
		contentPane.add(Precio_Unidad);
		
		JSpinner Cantidad = new JSpinner();
		
		
		Cantidad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				ped = new Pedido();
				ped.setReferencia(Referencia.getText());
				ped.setNombre(Nombre.getText());
				ped.setCantidad((int) Cantidad.getValue());
				ped.setPrecio(Double.parseDouble(Precio_Unidad.getText()));
				Precio_Total.setText(String.valueOf(ped.getPrecio_total()));
			}
		});
		Cantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		Cantidad.setBounds(110, 194, 96, 44);
		contentPane.add(Cantidad);

		Hacer_Pedido = new JButton("Pedir");
		Hacer_Pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					outObjeto = new ObjectOutputStream(cliente.getOutputStream());
// mandamos un objeto pedido
					double precio_ud = Double.valueOf(Precio_Unidad.getText());
					ped = new Pedido(Referencia.getText(), Nombre.getText(), (int) Cantidad.getValue(),
							precio_ud);
					outObjeto.writeObject(ped);
					Precio_Total.setText(String.valueOf(ped.getPrecio_total()));


				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		Hacer_Pedido.setForeground(new Color(0, 206, 209));
		Hacer_Pedido.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 30));
		Hacer_Pedido.setBounds(238, 148, 177, 123);
		contentPane.add(Hacer_Pedido);

		lblReferencia = new JLabel("Referencia");
		lblReferencia.setHorizontalAlignment(SwingConstants.LEFT);
		lblReferencia.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		lblReferencia.setBounds(10, 52, 128, 38);
		contentPane.add(lblReferencia);

		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		lblNombre.setBounds(10, 100, 128, 38);
		contentPane.add(lblNombre);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidad.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		lblCantidad.setBounds(10, 195, 128, 38);
		contentPane.add(lblCantidad);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecio.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		lblPrecio.setBounds(10, 145, 128, 38);
		contentPane.add(lblPrecio);

		lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		lblTotal.setBounds(10, 244, 128, 38);
		contentPane.add(lblTotal);

// CERRAR STREAMS Y SOCKETS
		/*
		 * outObjeto.close(); inObjeto.close(); cliente.close(); server.close();
		 */

	}
}