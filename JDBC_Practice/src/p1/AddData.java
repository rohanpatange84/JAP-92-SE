package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddData {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id");
		int id = sc.nextInt();

		System.out.println("Enter name");
		String name = sc.next();

		System.out.println("Enter mark");
		double mark = sc.nextDouble();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92", "root", "7666");

			String quary = "INSERT INTO student (id,name,marks) value(?,?,?);";

			PreparedStatement ps = con.prepareStatement(quary);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, mark);
			
			int rowCount = ps.executeUpdate();

			if(rowCount>0) {
				System.out.println("Data ADD Sucess..");
			}
			
			
		} catch (Exception e) {
			System.out.println("While Adding data-->" + e);
		}

	}

}
