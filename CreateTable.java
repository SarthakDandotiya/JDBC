import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		// CREATE TABLE

		try {

			// Registering the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establishing Connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/practice", "root", "root");

			// Create Statement using the connection
			Statement statement = connection.createStatement();

			// Execute Update
			statement
					.executeUpdate("CREATE TABLE Test(id int(10), name varchar(40), age int(3), salary double(10,2));");

			System.out.println("Table Created Succesfully!");

			// Close Connection
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
