package proyectoFinalnventario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class Consulta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta frame = new Consulta();
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
	public Consulta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\FP\\Programaci\u00F3n\\Proyecto_inventario\\Consulta.png"));
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
	}

}
