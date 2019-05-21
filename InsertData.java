import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) {
		// INSERT DATA

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/practice", "root", "root");

			Statement statement = connection.createStatement();

			statement.executeUpdate("INSERT INTO Employee VALUES(105, 'Claire', 24, 81000.0);");

			System.out.println("Values Successfully Inserted into Table!");

			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
