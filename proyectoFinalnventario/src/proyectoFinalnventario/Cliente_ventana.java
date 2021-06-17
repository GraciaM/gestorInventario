package proyectoFinalnventario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;

public class Cliente_ventana extends JFrame {

	private JPanel contentPane;
	private String port;
	private String server;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente_ventana frame = new Cliente_ventana();
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
	public Cliente_ventana() {
		setTitle("Confirmar pedidos");
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
