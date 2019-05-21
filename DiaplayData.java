import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DiaplayData {

	public static void main(String[] args) {
		// DISPLAY DATA

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/practice", "root", "root");

			Statement statement = connection.createStatement();
			// By default, the ResultSet object can be moved forward only and it is not
			// updatable.
			// To make this object to move forward and backward as well as make it updatable
			// we pass the following arguments to 'createStatement()'.
			// Statement statement =
			// connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = statement.executeQuery("SELECT * FROM Employee ORDER BY id;");

			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getInt(3) + " - " + rs.getDouble(4));
			}

			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
