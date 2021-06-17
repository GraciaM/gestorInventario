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
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ResultSet consultar(String columna, String tabla, String valor) throws SQLException {
		try {
			statement = connect.createStatement();
			rs = statement.executeQuery("select " + columna + " from " + tabla + " where " + valor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	public ResultSet mostrarTabla(String tabla) throws SQLException {
		ResultSet res = null;
		try {
			statement = connect.createStatement();
			res = statement.executeQuery("Select * from " + tabla);
			/*
			 * while (rs.next()) { for (int i = 1; i<=rs.getMetaData().getColumnCount();
			 * i++) { System.out.println(rs.getString(i) + ", "); } }
			 */
		} catch (Exception e) {
			System.out.println(e);
		}
		return res;
	}

	public void insertar(String tabla, ArrayList<String> valores) throws SQLException {
		try {

			// PreparedStatement preparedStatement = connect.prepareStatement("Insert into"
			// + tabla + " values (?, ?)");
			String valores_array = "";
			for (int i = 0; i<valores.size()-1; i++) {
				valores_array+= "'"+valores.get(i)+"', ";
			}
			valores_array+= "'"+ valores.get(valores.size()-1) +"'";
			PreparedStatement preparedStatement = connect
					.prepareStatement("insert into " + tabla + " values " + "(" + valores_array + ")");
					//.prepareStatement("Insert into " + tabla + " values ('" + indice + "', '" + valor + "')");
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void borrar(String columna, String tabla, String valor) throws
	 * SQLException { try { PreparedStatement prepraredStatement = connect
	 * .prepareStatement("Delete " + columna + " from " + tabla + " where " +
	 * valor); } catch (SQLException e) { e.printStackTrace(); } }
	 */

}