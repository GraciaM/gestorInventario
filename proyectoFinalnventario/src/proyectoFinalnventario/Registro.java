package proyectoFinalnventario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField CIF;
	private JTextField Empresa;
	private JTextField Direccion;
	private JTextField Ciudad;
	private JTextField Email;
	private JTextField Telefono;
	static Conexion conexion;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Registro(Conexion conexion) {
		this.conexion = conexion;
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\FP\\Programaci\u00F3n\\Proyecto_inventario\\Registro.png"));
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox Opciones = new JComboBox();
		Opciones.setBounds(10, 11, 123, 26);
		contentPane.add(Opciones);
		Opciones.addItem("Proveedor");
		Opciones.addItem("Producto");
		Opciones.addItem("Electrodoméstico");
		
		table = new JTable();
		table.setBounds(395, 239, -354, -173);
		contentPane.add(table);
		try {
			conexion.mostrarTabla("proveedor");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println("1");
		
		
		
		
		
	}
}
