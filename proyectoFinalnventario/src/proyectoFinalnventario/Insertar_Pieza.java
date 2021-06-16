package proyectoFinalnventario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Insertar_Pieza extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ID;
	private JTextField textField_Nombre;
	private JTextField textField_Descripcion;
	private JTextField textField_Ciudad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insertar_Pieza frame = new Insertar_Pieza();
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
	public Insertar_Pieza() {
		setTitle("Insertar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(115, 44, 520, 53);
		contentPane.add(textField_ID);
		textField_ID.setColumns(10);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		textField_Nombre.setBounds(115, 107, 520, 53);
		contentPane.add(textField_Nombre);
		
		textField_Descripcion = new JTextField();
		textField_Descripcion.setColumns(10);
		textField_Descripcion.setBounds(115, 170, 520, 53);
		contentPane.add(textField_Descripcion);
		
		textField_Ciudad = new JTextField();
		textField_Ciudad.setColumns(10);
		textField_Ciudad.setBounds(115, 233, 520, 53);
		contentPane.add(textField_Ciudad);
		
		JButton Guardar = new JButton("Guardar");
		Guardar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		Guardar.setBounds(655, 111, 97, 127);
		contentPane.add(Guardar);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		lblId.setBounds(10, 44, 85, 53);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		lblNombre.setBounds(10, 107, 85, 53);
		contentPane.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		lblDescripcion.setBounds(10, 170, 85, 53);
		contentPane.add(lblDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		lblPrecio.setBounds(10, 233, 85, 53);
		contentPane.add(lblPrecio);
	}
}