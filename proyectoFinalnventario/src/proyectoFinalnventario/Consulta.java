package proyectoFinalnventario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class Consulta extends JFrame {

	private JPanel contentPane;
	private JTextField campoBusqueda;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();
	private Conexion conexion;

	/**
	 * Create the frame.
	 */
	public Consulta(Conexion conexion) {
		this.conexion = conexion;
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/Consulta.png"));
		setTitle("Consulta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Buscar = new JLabel("Buscar por");
		Buscar.setBounds(10, 18, 96, 25);
		contentPane.add(Buscar);
		
		JComboBox busquedas = new JComboBox();
		busquedas.setBounds(80, 11, 96, 38);
		contentPane.add(busquedas);
		busquedas.addItem("Referencia");
		busquedas.addItem("Nombre");
		busquedas.addItem("Familia");
		
		campoBusqueda = new JTextField();
		campoBusqueda.setBounds(10, 56, 166, 20);
		contentPane.add(campoBusqueda);
		campoBusqueda.setColumns(30);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valor = campoBusqueda.getText();
				String condicion = "";
				try {
					switch (busquedas.getSelectedItem().toString()) {
					case "Referencia":
						condicion = "id = '";
						condicion+= valor + "'";
						mostrarConsulta("*", "pieza", condicion);
						break;
					case "Nombre":
						condicion = "nombre = '";
						condicion+= valor + "'";
						mostrarConsulta("*", "pieza", condicion);
						break;
					case "Familia":
						condicion = "familia.nombre = '";
						condicion+= valor + "' and familia.nombre = nombrefamilia";
						mostrarConsulta("*", "pieza, familia, producto", condicion);
						break;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(186, 55, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 87, 414, 163);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		/*table.setBounds(10, 87, 414, 163);
		contentPane.add(table);*/

	}
	public void mostrarConsulta(String columna, String tabla, String condicion) throws SQLException {
		ResultSet res = conexion.consultar(columna, tabla, condicion);

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
