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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class Cliente_ventana extends JFrame {

	private JPanel contentPane;
	private String port;
	private String server;
	private JTextField Pedidos;
	private JTextField Comentarios;
	private JTextField Coste_pedido;

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
		setBounds(100, 100, 519, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton conectar = new JButton("Conectar con Sertecco");
		conectar.setForeground(new Color(0, 206, 209));
		conectar.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 20));
		conectar.setBounds(137, 10, 358, 50);
		contentPane.add(conectar);
		
		Pedidos = new JTextField();
		Pedidos.setBounds(10, 70, 485, 63);
		contentPane.add(Pedidos);
		Pedidos.setColumns(10);
		
		JRadioButton Confirmar = new JRadioButton("Confirmar");
		Confirmar.setBounds(6, 139, 103, 21);
		contentPane.add(Confirmar);
		
		JRadioButton rdbtnConfirmar = new JRadioButton("Confirmar*");
		rdbtnConfirmar.setBounds(137, 139, 103, 21);
		contentPane.add(rdbtnConfirmar);
		
		JRadioButton Denegar_con_coment = new JRadioButton("Denegar");
		Denegar_con_coment.setBounds(263, 139, 103, 21);
		contentPane.add(Denegar_con_coment);
		
		Comentarios = new JTextField();
		Comentarios.setColumns(10);
		Comentarios.setBounds(10, 166, 485, 43);
		contentPane.add(Comentarios);
		
		JLabel lblPrecioFinalDel = new JLabel("Precio final del pedido");
		lblPrecioFinalDel.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioFinalDel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 21));
		lblPrecioFinalDel.setBounds(132, 540, 225, 38);
		contentPane.add(lblPrecioFinalDel);
		
		Coste_pedido = new JTextField();
		Coste_pedido.setColumns(10);
		Coste_pedido.setBounds(367, 540, 128, 43);
		contentPane.add(Coste_pedido);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(44, 236, 415, 284);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Confirmacion_prov = new JLabel("Confirmaci\u00F3n de pedidos:");
		Confirmacion_prov.setBounds(10, 10, 275, 35);
		Confirmacion_prov.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 18));
		panel.add(Confirmacion_prov);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 53, 372, 215);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(16);
		scrollPane.setColumnHeaderView(textArea);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textArea.setColumns(15);
		
		JLabel lblPedidos = new JLabel("Pedidos:");
		lblPedidos.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 18));
		lblPedidos.setBounds(10, 25, 275, 35);
		contentPane.add(lblPedidos);
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
