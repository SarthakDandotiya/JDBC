import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessing {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Batch Processing

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/practice", "root", "root");

		connection.setAutoCommit(false);

		Statement statement = connection.createStatement();

		statement.addBatch("INSERT INTO Employee VALUES(105, 'Claire', 24, 81000.0)");
		statement.addBatch("INSERT INTO Employee VALUES(106, 'Pam', 26, 61000.0)");

		statement.executeBatch();

		connection.commit();
		System.out.println("Batch Processed.");
		connection.close();

	}

}
