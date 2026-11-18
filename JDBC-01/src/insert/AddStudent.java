package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddStudent {
		
	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		
		int id = 12;
		String name = "Rohan";
		double marks= 80;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92","root","7666");
		
		String queary = "insert into student values ("+id+",'"+name+"',"+marks+")";
		
		Statement stmt = con.createStatement();
		
		int rowCount = stmt.executeUpdate(queary);
		
		if(rowCount>0) {
			System.out.println("Data Added SUCESS...");
		}
		
	}
}
