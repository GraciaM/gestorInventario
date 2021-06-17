package proyectoFinalnventario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Pedidos extends JFrame implements Serializable {

	private JPanel contentPane;
	private String server;
	private JButton Server;
	private JButton Client;
	private String port;

	/**
	 * Create the frame.
	 */
	public Pedidos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/Pedidos.png"));
		setTitle("Pedidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Botón para conectarse como Servidor.
		Server = new JButton("S");
		Server.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		Server.setBounds(236, 11, 82, 51);
		contentPane.add(Server);
		Server.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean connect = false;
				port = JOptionPane.showInputDialog(contentPane, "Port");

				if (!connect) {
					try {
						ServerSocket server = new ServerSocket(Integer.parseInt(port));
						Socket cliente = server.accept();
						ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());

						// mandamos un objeto pedido
						Pedido ped = new Pedido();
						outObjeto.writeObject(ped);

						// se obtiene un stream para leer un objeto
						ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
						Pedido dato = (Pedido) inObjeto.readObject();

						/*
						 * readingFromSocket reading = new readingFromSocket(input, Read);
						 * reading.start();
						 */

						// CERRAR STREAMS Y SOCKETS
						outObjeto.close();
						inObjeto.close();
						cliente.close();
						server.close();

					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (NumberFormatException | IOException e) {
						e.printStackTrace();
					}
				}

			}
		});

		Client = new JButton("C");
		Client.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		Client.setBounds(342, 11, 82, 51);
		contentPane.add(Client);
		Client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean connect = false;
				port = JOptionPane.showInputDialog(contentPane, "Port");
				server = JOptionPane.showInputDialog(contentPane, "IP");
				if (!connect) {
					Socket socket;
					try {

						Socket cliente = new Socket(server, Integer.parseInt(port));

						// Flujo de entrada para objetos
						ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());

						// Se recibe un objeto

						Pedido dato = (Pedido) perEnt.readObject();

						// FLUJO DE salida para objetos
						ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());

						// Se envía el objeto
						perSal.writeObject(dato);

						// CERRAR STREAMS Y SOCKETS
						perEnt.close();
						perSal.close();
						cliente.close();

					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (NumberFormatException | IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
}
