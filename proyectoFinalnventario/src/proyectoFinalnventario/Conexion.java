package proyectoFinalnventario;

import java.sql.*;

public class Conexion {

	private String url;
	private String user;
	private String password;
	private Connection connect;
	
	public Conexion(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public void conectar() throws SQLException {
		try {
			connect = DriverManager.getConnection(this.url, this.user, this.password);
			Statement statement = connect.createStatement();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void consultar(String instruccion) throws SQLException {
		try {
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(instruccion);
			while (rs.next()) {
				for (int i = 0; i<rs.getMetaData().getColumnCount(); i++) {
						System.out.println(rs.getString(i) + ", ");
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void insertar(String registro) throws SQLException {
		try {
			PreparedStatement preparedStatement = connect
					.prepareStatement(registro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
