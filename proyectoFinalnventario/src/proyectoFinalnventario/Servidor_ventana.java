package proyectoFinalnventario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;

public class Servidor_ventana extends JFrame {

	private JPanel contentPane;
	private String port;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor_ventana frame = new Servidor_ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Servidor_ventana() {
		setTitle("Hacer pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton conectar = new JButton("Conectar");
		conectar.setForeground(new Color(0, 206, 209));
		conectar.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 15));
		conectar.setBounds(10, 10, 118, 21);
		contentPane.add(conectar);
		conectar.addActionListener(new ActionListener() {
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
	}
}
