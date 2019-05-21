import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {

	public static void main(String[] args) {
		// UPDATE DATA

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/practice", "root", "root");

			Statement statement = connection.createStatement();

			int result = statement.executeUpdate("UPDATE Employee SET name='Doug',salary=73000.0 WHERE id=101;");

			System.out.println(result + " Value(s) Affected.");

			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
