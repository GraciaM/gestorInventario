package proyectoFinalnventario;

import java.sql.*;

public class Conexion {

	private String url;
	private String user;
	private String password;
	
	public Conexion(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public void conectar() throws SQLException {
		try {
			Connection connect = DriverManager.getConnection(this.url, this.user, this.password);
			Statement statement = connect.createStatement();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
