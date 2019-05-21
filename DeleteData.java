import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {

	public static void main(String[] args) {
		// DELETE DATA

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/practice", "root", "root");

			Statement statement = connection.createStatement();

			int result = statement.executeUpdate("DELETE FROM Employee WHERE id=105;");

			System.out.println(result + " Value(s) Affected.");

			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
