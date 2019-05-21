import java.sql.*;
import java.util.*;

public class PreparedStatements {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Inserting Values with Prepared Statements until user presses 0

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/practice", "root", "root");

		PreparedStatement ps = connection.prepareStatement("INSERT INTO Employee VALUES(?, ?, ?, ?);");

		Scanner sc = new Scanner(System.in);

		System.out.println("Insert Values into the 'Employee' table: \n");

		do {

			System.out.println("Id: ");
			int id = sc.nextInt();
			System.out.println("Name: ");
			String name = sc.next();
			System.out.println("Age: ");
			int age = sc.nextInt();
			System.out.println("Salary [with Decimals]: ");
			double salary = sc.nextDouble();

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setDouble(4, salary);

			int r = ps.executeUpdate();

			System.out.println(r + " record(s) affected.\n");

			System.out.println("Do you want to continue? y/n: ");
			String s = sc.next();

			if (s.startsWith("n"))
				break;

		} while (true);

		System.out.println("\nNew Database:");

		ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM Employee ORDER BY id;");

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getInt(3) + " - " + rs.getDouble(4));
		}

		connection.close();

	}

}
