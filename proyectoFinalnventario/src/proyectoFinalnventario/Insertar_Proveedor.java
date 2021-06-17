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
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Insertar_Proveedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField_CIF;
	private JTextField textField_Empresa;
	private JTextField textField_Direccion;
	private JTextField textField_Ciudad;
	private JTextField textField_Telefono;
	private JTextField textField_Email;
	private Conexion conexion;

	/**
	 * Create the frame.
	 */
	public Insertar_Proveedor(Conexion conexion) {
		this.conexion = conexion;
		setTitle("Insertar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_CIF = new JTextField();
		textField_CIF.setBounds(115, 44, 520, 53);
		contentPane.add(textField_CIF);
		textField_CIF.setColumns(10);

		textField_Empresa = new JTextField();
		textField_Empresa.setColumns(10);
		textField_Empresa.setBounds(115, 107, 520, 53);
		contentPane.add(textField_Empresa);

		textField_Direccion = new JTextField();
		textField_Direccion.setColumns(10);
		textField_Direccion.setBounds(115, 170, 520, 53);
		contentPane.add(textField_Direccion);

		textField_Ciudad = new JTextField();
		textField_Ciudad.setColumns(10);
		textField_Ciudad.setBounds(115, 233, 520, 53);
		contentPane.add(textField_Ciudad);

		textField_Telefono = new JTextField();
		textField_Telefono.setColumns(10);
		textField_Telefono.setBounds(115, 296, 520, 53);
		contentPane.add(textField_Telefono);

		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(115, 361, 520, 53);
		contentPane.add(textField_Email);

		JButton Guardar = new JButton("Guardar");
		Guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String tabla = "proveedor";
					ArrayList<String> valores = new ArrayList<String>();
					valores.add(textField_CIF.getText());
					valores.add(textField_Empresa.getText());
					valores.add(textField_Direccion.getText());
					valores.add(textField_Ciudad.getText());
					valores.add(textField_Telefono.getText());
					valores.add(textField_Email.getText());
					conexion.insertar(tabla, valores);
					/*conexion.insertar(tabla, 1, textField_CIF.getText());
					conexion.insertar(tabla, 2, textField_Empresa.getText());
					conexion.insertar(tabla, 3, textField_Direccion.getText());
					conexion.insertar(tabla, 4, textField_Ciudad.getText());
					conexion.insertar(tabla, 5, textField_Telefono.getText());
					conexion.insertar(tabla, 6, textField_Email.getText());*/
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		Guardar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		Guardar.setBounds(655, 159, 97, 127);
		contentPane.add(Guardar);

		JLabel Label_CIF = new JLabel("CIF");
		Label_CIF.setHorizontalAlignment(SwingConstants.CENTER);
		Label_CIF.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		Label_CIF.setBounds(10, 44, 85, 53);
		contentPane.add(Label_CIF);

		JLabel Label_Empresa = new JLabel("Empresa");
		Label_Empresa.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Empresa.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		Label_Empresa.setBounds(10, 107, 85, 53);
		contentPane.add(Label_Empresa);

		JLabel Label_Direccion = new JLabel("Direccion");
		Label_Direccion.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Direccion.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		Label_Direccion.setBounds(10, 170, 85, 53);
		contentPane.add(Label_Direccion);

		JLabel Label_Ciudad = new JLabel("Ciudad");
		Label_Ciudad.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Ciudad.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		Label_Ciudad.setBounds(10, 233, 85, 53);
		contentPane.add(Label_Ciudad);

		JLabel Label_Telefono = new JLabel("Telefono");
		Label_Telefono.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Telefono.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		Label_Telefono.setBounds(10, 296, 85, 53);
		contentPane.add(Label_Telefono);

		JLabel Label_Email = new JLabel("Email");
		Label_Email.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Email.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 15));
		Label_Email.setBounds(10, 361, 85, 53);
		contentPane.add(Label_Email);

	}
}
