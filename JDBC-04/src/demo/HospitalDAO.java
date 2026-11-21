package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HospitalDAO {

	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_db", "root", "7666");
		} catch (Exception e) {
			System.out.println("Whilr connection--->" + e);
		}

		return con;
	}

	public static void readData() {
		String quary = "SELECT * FROM patients";
		try (Connection con = getCon();
				PreparedStatement ps = con.prepareStatement(quary);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				System.out.print(rs.getInt("id") + " ");
				System.out.print(rs.getString("name") + " ");
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("While Reading data--->" + e);
		}

	}
	
	public static void deletData(int id) {
		String quary = "DELETE FROM patients WHERE id =?";
		try (Connection con = getCon();
				PreparedStatement ps = con.prepareStatement(quary);
				) {
			
			ps.setInt(1,id);
			ps.execute();
			

		} catch (Exception e) {
			System.out.println("While Reading data--->" + e);
		}
		
	}

	public static void main(String[] args) {
		
		deletData(6);

	}
}
