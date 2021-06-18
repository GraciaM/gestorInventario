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
import javax.swing.JOptionPane;
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
	private Conexion conexion;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();
	private JTextField textField;

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
		setBounds(100, 100, 924, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox Opciones = new JComboBox();
		JButton Insertar = new JButton("Insertar");
		JButton Borrar = new JButton("Borrar");

		Opciones.setBounds(10, 11, 157, 62);
		contentPane.add(Opciones);
		Opciones.addItem("Proveedor");
		Opciones.addItem("Pieza");
		Opciones.addItem("Electrodomestico");
		Opciones.addItem("Producto");
		mostrarEnInterfaz("proveedor");
		Opciones.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					switch (Opciones.getSelectedItem().toString()) {
					case "Proveedor":
						mostrarEnInterfaz("proveedor");
						Insertar.setEnabled(true);
						Borrar.setEnabled(true);
						break;
					case "Pieza":
						mostrarEnInterfaz("pieza");
						Insertar.setEnabled(true);
						Borrar.setEnabled(true);
						break;
					case "Electrodomestico":
						mostrarEnInterfaz("familia");
						Insertar.setEnabled(false);
						Borrar.setEnabled(false);
						break;
					case "Producto":
						mostrarEnInterfaz("pieza_pertenece_Producto");
						Insertar.setEnabled(false);
						Borrar.setEnabled(false);
						break;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 888, 391);
		contentPane.add(scrollPane);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		Insertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (Opciones.getSelectedItem().toString()) {
				case "Proveedor":
					Insertar_Proveedor insertarPro = new Insertar_Proveedor(conexion);
					insertarPro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					insertarPro.setVisible(true);
					break;
				case "Pieza":
					Insertar_Pieza insertarProd = new Insertar_Pieza(conexion);
					insertarProd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					insertarProd.setVisible(true);
					break;
				}
			}
		});
		Insertar.setBounds(512, 12, 188, 60);
		contentPane.add(Insertar);
		
		Borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
			String valor = table.getColumnName(1) + "= '" + table.getValueAt(table.getSelectedRow(), 1) + "'";
			conexion.borrar(Opciones.getSelectedItem().toString(), valor);
			} catch (SQLException e) {
			e.printStackTrace();
			}
			}
			});
		Borrar.setBounds(710, 12, 188, 60);
		contentPane.add(Borrar);

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