package proyectoFinalnventario;

import java.sql.*;
import java.util.ArrayList;

public class Conexion {

	private String url;
	private String user;
	private String password;
	private Connection connect;
	private Statement statement;
	private ResultSet rs;
	
	public Conexion() {
		
	}
	
	public Conexion(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public void conectar() throws SQLException {
		try {
			connect = DriverManager.getConnection(this.url, this.user, this.password);
			statement = connect.createStatement();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void consultar(String columna, String tabla, String valor) throws SQLException {
		try {
			statement = connect.createStatement();
			rs = statement.executeQuery("select");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void mostrarTabla(String tabla) throws SQLException {
		try {
			statement = connect.createStatement();
			rs = statement.executeQuery("Select * from " + tabla);
			while (rs.next()) {
				for (int i = 1; i<=rs.getMetaData().getColumnCount(); i++) {
						System.out.println(rs.getString(i) + ", ");
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void insertar(String columna, String tabla) throws SQLException {
		try {
			PreparedStatement preparedStatement = connect
					.prepareStatement("Insert into" + columna +" from" + tabla);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void borrar(String columna, String tabla, String valor) throws SQLException {
		try {
			PreparedStatement prepraredStatement = connect
					.prepareStatement("Delete " + columna + " from " + tabla + " where " + valor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
