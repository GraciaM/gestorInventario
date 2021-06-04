package proyectoFinalnventario;

import java.sql.*;

public class Inventario {

	public static void main(String[] args) throws SQLException{
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Setup the connection with the DB
			String url="jdbc:mysql://localhost:3306/inventario";
			String user="root";
			String password="administrador";
			Connection connect=DriverManager.getConnection(url,user,password); 


			// Statements allow to issue SQL queries to the database
			Statement statement = connect.createStatement();
			//      statement.execute("insert into students values (4, 'Perico el de los Palotes')");

			// Result set get the result of the SQL query
			ResultSet rs = statement.executeQuery("select *  from proveedor");
			//    writeResultSet(resultSet);
			while (rs.next()) {
				System.out.println(rs.getString("CIF") + ", " + rs.getString("Empresa") + ", " 
			+ rs.getString("Direccion") + ", " + rs.getString("Ciudad") + ", " + rs.getString("Telefono") + ", " 
			+ rs.getString("Email")); 


			}
			// PreparedStatements can use variables and are more efficient
		/*	PreparedStatement preparedStatement = connect
					.prepareStatement("insert into  students values ( ?, ?)");*/

			// Parameters start with 1
			/*preparedStatement.setInt(1, 5);
			preparedStatement.setString(2, "El quinto elemento");

			preparedStatement.executeUpdate();

			preparedStatement = connect
					.prepareStatement("SELECT code, name from students");
			rs = preparedStatement.executeQuery();
			writeResultSet(rs);*/



		} catch (Exception e) {
			System.out.println(e);;

		}
	}

	private static void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			int code = resultSet.getInt("code");  
			String name = resultSet.getString("name");

			System.out.println("Code: " + code);
			System.out.println("Name: " + name);

		}
	}

}
