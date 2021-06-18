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
	private JPanel panel;
	private JTextField textField;
	private ServerSocket server;
	private Socket cliente;
	private ObjectOutputStream outObjeto;
	private ObjectInputStream inObjeto;

	/**
	 * Create the frame.
	 */
	public Servidor_ventana() {
		setTitle("Hacer pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 658);
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
		Nombre.setBounds(110, 100, 305, 38);
		contentPane.add(Nombre);

		Precio_Total = new JTextField();
		Precio_Total.setColumns(10);
		Precio_Total.setBounds(110, 235, 118, 36);
		contentPane.add(Precio_Total);

		Precio_Unidad = new JTextField();
		Precio_Unidad.setColumns(10);
		Precio_Unidad.setBounds(110, 190, 96, 38);
		contentPane.add(Precio_Unidad);

		JSpinner Cantidad = new JSpinner();
		Cantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		Cantidad.setBounds(110, 142, 96, 44);
		contentPane.add(Cantidad);

		Hacer_Pedido = new JButton("Pedir");
		Hacer_Pedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					outObjeto = new ObjectOutputStream(cliente.getOutputStream());
// mandamos un objeto pedido
					System.out.println(Precio_Unidad.getText());
					double precio_ud = Double.valueOf(Precio_Unidad.getText());
					Pedido ped = new Pedido(Referencia.getText(), Nombre.getText(), (int) Cantidad.getValue(),
							precio_ud);
					outObjeto.writeObject(ped);


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
		lblCantidad.setBounds(10, 148, 128, 38);
		contentPane.add(lblCantidad);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecio.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		lblPrecio.setBounds(10, 190, 128, 38);
		contentPane.add(lblPrecio);

		lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		lblTotal.setBounds(10, 233, 128, 38);
		contentPane.add(lblTotal);

		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 281, 405, 277);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel Confirmacion_prov = new JLabel("Confirmaci\u00F3n de pedidos:");
		Confirmacion_prov.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 18));
		Confirmacion_prov.setBounds(10, 10, 275, 35);
		panel.add(Confirmacion_prov);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(20, 53, 372, 214);
		panel.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setColumns(10);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 10));
		/*try {
			inObjeto = new ObjectInputStream( cliente.getInputStream());
			textArea.setText(inObjeto.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		JLabel lblPrecioFinalDel = new JLabel("Precio final del pedido");
		lblPrecioFinalDel.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioFinalDel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 21));
		lblPrecioFinalDel.setBounds(20, 568, 225, 38);
		contentPane.add(lblPrecioFinalDel);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(255, 568, 128, 43);
		contentPane.add(textField);

// CERRAR STREAMS Y SOCKETS
		/*
		 * outObjeto.close(); inObjeto.close(); cliente.close(); server.close();
		 */

	}
}