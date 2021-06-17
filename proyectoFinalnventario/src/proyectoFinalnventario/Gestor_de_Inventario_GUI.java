package proyectoFinalnventario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class Gestor_de_Inventario_GUI {

	private JFrame frmGestorDeInventario;
	private Conexion conexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestor_de_Inventario_GUI window = new Gestor_de_Inventario_GUI();
					window.frmGestorDeInventario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public Gestor_de_Inventario_GUI() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize() throws SQLException {
		frmGestorDeInventario = new JFrame();
		frmGestorDeInventario.setIconImage(Toolkit.getDefaultToolkit().getImage("img/inventario.png"));
		frmGestorDeInventario.setTitle("Gestor de inventario SERTECCO");
		frmGestorDeInventario.setBounds(100, 100, 450, 300);
		frmGestorDeInventario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestorDeInventario.getContentPane().setLayout(null);

		conexion = new Conexion("jdbc:mysql://localhost:3306/inventario", "root", "administrador");
		try {
			conexion.conectar();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		JLabel Registro_texto = new JLabel("Registro");
		Registro_texto.setHorizontalAlignment(SwingConstants.CENTER);
		Registro_texto.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 25));
		Registro_texto.setBounds(10, 82, 132, 32);
		frmGestorDeInventario.getContentPane().add(Registro_texto);

		JLabel Consulta_texto = new JLabel("Consulta");
		Consulta_texto.setHorizontalAlignment(SwingConstants.CENTER);
		Consulta_texto.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 25));
		Consulta_texto.setBounds(152, 82, 130, 32);
		frmGestorDeInventario.getContentPane().add(Consulta_texto);

		JLabel Pedidos_texto = new JLabel("Pedidos");
		Pedidos_texto.setHorizontalAlignment(SwingConstants.CENTER);
		Pedidos_texto.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 25));
		Pedidos_texto.setBounds(292, 82, 132, 32);
		frmGestorDeInventario.getContentPane().add(Pedidos_texto);

		JLabel Título_texto = new JLabel("Sertecco");
		Título_texto.setForeground(new Color(0, 206, 209));
		Título_texto.setHorizontalAlignment(SwingConstants.CENTER);
		Título_texto.setFont(new Font("Tahoma", Font.PLAIN, 80));
		Título_texto.setBounds(59, 11, 322, 69);
		frmGestorDeInventario.getContentPane().add(Título_texto);

		JButton Registro_boton = new JButton("");
		Registro_boton.setIcon(new ImageIcon("img/Registro.png"));
		Registro_boton.setBounds(10, 115, 132, 135);
		Registro_boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registro rg;
				try {
					rg = new Registro(conexion);
					rg.setVisible(true);
					rg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frmGestorDeInventario.getContentPane().add(Registro_boton);

		JButton Consulta_boton = new JButton("");
		Consulta_boton.setIcon(new ImageIcon("img/Consulta.png"));
		Consulta_boton.setBounds(152, 115, 132, 135);
		Consulta_boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Consulta cons = new Consulta(conexion);
				cons.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				cons.setVisible(true);

			}
		});
		frmGestorDeInventario.getContentPane().add(Consulta_boton);

		JButton Pedidos_boton = new JButton("");
		Pedidos_boton.setIcon(new ImageIcon("img/Pedidos.png"));
		Pedidos_boton.setBounds(292, 115, 132, 135);
		Pedidos_boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pedidos ped = new Pedidos();
				ped.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ped.setVisible(true);

			}
		});
		frmGestorDeInventario.getContentPane().add(Pedidos_boton);
	}
}