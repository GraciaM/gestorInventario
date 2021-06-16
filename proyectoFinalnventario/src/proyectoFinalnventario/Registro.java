package proyectoFinalnventario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
	private DefaultTableModel model = new DefaultTableModel();

	/**
	 * Create the frame.
	 *
	 * @throws SQLException
	 */

	public Registro(Conexion conexion) throws SQLException {
		this.conexion = conexion;
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\Registro.png"));
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox Opciones = new JComboBox();

		Opciones.setBounds(10, 11, 157, 62);
		contentPane.add(Opciones);
		Opciones.addItem("Proveedor");
		Opciones.addItem("Producto");
		Opciones.addItem("Electrodomestico");
		Opciones.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					switch (Opciones.getSelectedItem().toString()) {
					case "Proveedor":
						mostrarEnInterfaz("proveedor");
						break;
					case "Producto":
						mostrarEnInterfaz("producto");
						break;
					case "Electrodomestico":
						mostrarEnInterfaz("familia");
						break;
					}
				} catch (SQLException e) {
// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 595, 391);
		contentPane.add(scrollPane);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		JButton Insertar = new JButton("Insertar");
		Insertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		Insertar.setBounds(318, 13, 287, 60);
		contentPane.add(Insertar);
	}

	public void mostrarEnInterfaz(String tabla) throws SQLException {
		ResultSet res = conexion.mostrarTabla(tabla);

// POR METADATOS
		ResultSetMetaData metaDatos = res.getMetaData();
// Se obtiene el número de columnas.
		int numeroColumnas = metaDatos.getColumnCount();

// Se crea un array de etiquetas para rellenar
		Object[] etiquetas = new Object[numeroColumnas];

// Se obtiene cada una de las etiquetas para cada columna
		for (int i = 0; i < numeroColumnas; i++) {
			etiquetas[i] = metaDatos.getColumnLabel(i + 1);

		}
		model.setColumnIdentifiers(etiquetas);
		model.setRowCount(0);
// Bucle para cada resultado en la consulta
		while (res.next()) {
// Se crea un array que será una de las filas de la tabla.
			Object[] fila = new Object[numeroColumnas]; // Hay tres columnas en la tabla

// Se rellena cada posición del array con una de las columnas de la tabla en
// base de datos.
			for (int i = 0; i < numeroColumnas; i++)
				fila[i] = res.getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

// Se añade al modelo la fila completa.
			model.addRow(fila);
		}
	}
}