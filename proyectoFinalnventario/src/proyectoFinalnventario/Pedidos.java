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
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Pedidos extends JFrame implements Serializable {

	private JPanel contentPane;
	private JButton Server;
	private JButton Client;

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
		Server = new JButton("Administrador");
		Server.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 15));
		Server.setBounds(10, 85, 200, 142);
		contentPane.add(Server);
		
		Server.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Servidor_ventana Administrador = new Servidor_ventana();
				Administrador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Administrador.setVisible(true);

			}
		});

		Client = new JButton("Proveedor");
		Client.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 15));
		Client.setBounds(233, 85, 193, 142);
		contentPane.add(Client);
		
		Client.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente_ventana Proveedor = new Cliente_ventana();
				Proveedor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Proveedor.setVisible(true);

			}
		});
		
		JLabel Identificador = new JLabel("Identificate:");
		Identificador.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		Identificador.setHorizontalAlignment(SwingConstants.CENTER);
		Identificador.setBounds(50, 28, 334, 47);
		contentPane.add(Identificador);
		
		
	}
}
