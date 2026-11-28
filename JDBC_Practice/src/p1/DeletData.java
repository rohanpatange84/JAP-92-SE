package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class DeletData {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id");
		int id = sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92", "root", "7666");
			
			String quary = "DELETE FROM student WHERE id=?";
			
			PreparedStatement ps = con.prepareStatement(quary);
			ps.setInt(1, id);
			
			int rowCount =ps.executeUpdate();
			
			if(rowCount>0) {
				System.out.println("Data Delete sucess...");
			}
			
		}catch(Exception e) {
			System.out.println("while Deleting data..."+e);
		}
	}

}
