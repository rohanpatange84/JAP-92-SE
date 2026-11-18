package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStudent {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		int id = 22;
		String name = "Vivek";
		double marks = 98;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92", "root", "7666");

		String query = "UPDATE STUDENT SET name=? , marks=?  WHERE id=?";

		PreparedStatement ps = con.prepareStatement(query);

		ps.setString(1, name);
		ps.setDouble(2, marks);
		ps.setInt(3, id);

		int rowCount = ps.executeUpdate();

		if (rowCount > 0)
			System.out.println("Data UPDATE SUCESS...");

	}
}
