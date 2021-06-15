package proyectoFinalnventario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField CIF;
	private JTextField Empresa;
	private JTextField Direccion;
	private JTextField Ciudad;
	private JTextField Email;
	private JTextField Telefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
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
		
		CIF = new JTextField();
		CIF.setBounds(77, 48, 325, 20);
		contentPane.add(CIF);
		CIF.setColumns(10);
		
		Empresa = new JTextField();
		Empresa.setColumns(10);
		Empresa.setBounds(77, 79, 325, 20);
		contentPane.add(Empresa);
		
		Direccion = new JTextField();
		Direccion.setColumns(10);
		Direccion.setBounds(77, 110, 325, 20);
		contentPane.add(Direccion);
		
		Ciudad = new JTextField();
		Ciudad.setColumns(10);
		Ciudad.setBounds(77, 141, 325, 20);
		contentPane.add(Ciudad);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(77, 172, 325, 20);
		contentPane.add(Email);
		
		Telefono = new JTextField();
		Telefono.setColumns(10);
		Telefono.setBounds(77, 203, 220, 20);
		contentPane.add(Telefono);
		
		JButton Guardar = new JButton("Guardar");
		Guardar.setBounds(307, 203, 95, 47);
		contentPane.add(Guardar);
		
		JLabel CIF_label = new JLabel("CIF");
		CIF_label.setFont(new Font("Tahoma", Font.BOLD, 10));
		CIF_label.setHorizontalAlignment(SwingConstants.CENTER);
		CIF_label.setBounds(20, 51, 46, 14);
		contentPane.add(CIF_label);
		
		JLabel Empresa_label = new JLabel("Empresa");
		Empresa_label.setHorizontalAlignment(SwingConstants.CENTER);
		Empresa_label.setFont(new Font("Tahoma", Font.BOLD, 10));
		Empresa_label.setBounds(10, 82, 57, 14);
		contentPane.add(Empresa_label);
		
		JLabel Direccion_label = new JLabel("Direccion");
		Direccion_label.setHorizontalAlignment(SwingConstants.CENTER);
		Direccion_label.setFont(new Font("Tahoma", Font.BOLD, 10));
		Direccion_label.setBounds(10, 113, 57, 14);
		contentPane.add(Direccion_label);
		
		JLabel Ciudad_label = new JLabel("Ciudad");
		Ciudad_label.setHorizontalAlignment(SwingConstants.CENTER);
		Ciudad_label.setFont(new Font("Tahoma", Font.BOLD, 10));
		Ciudad_label.setBounds(10, 144, 57, 14);
		contentPane.add(Ciudad_label);
		
		JLabel Email_label = new JLabel("Email");
		Email_label.setHorizontalAlignment(SwingConstants.CENTER);
		Email_label.setFont(new Font("Tahoma", Font.BOLD, 10));
		Email_label.setBounds(10, 175, 57, 14);
		contentPane.add(Email_label);
		
		JLabel Telf_label = new JLabel("Tel\u00E9fono");
		Telf_label.setHorizontalAlignment(SwingConstants.CENTER);
		Telf_label.setFont(new Font("Tahoma", Font.BOLD, 10));
		Telf_label.setBounds(10, 206, 57, 14);
		contentPane.add(Telf_label);
		
	}
}
