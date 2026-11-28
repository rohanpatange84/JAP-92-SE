package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadData {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92", "root", "7666");

			String quary = "SELECT id,name,marks FROM student;";

			PreparedStatement ps = con.prepareStatement(quary);

			ResultSet rs = ps.executeQuery();
			System.out.println("----------------------------");
			System.out.println(String.format("%-5s %-10s %-5s","ID","NAME","MARKS"));
			System.out.println("----------------------------");

			while (rs.next()) {
				System.out.println(String.format("%-5d %-10s %-5f", rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
			System.out.println("----------------------------");

		} catch (Exception e) {
			System.out.println("While Reding data..." + e);
		}

	}

}
