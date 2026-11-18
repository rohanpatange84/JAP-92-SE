package insert2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddStudent {
		public static void main(String[] args)throws ClassNotFoundException, SQLException{
			
			int id = 22;
			String name = "Suraj";
			double marks = 87;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92","root","7666");
		
			String query="insert into student (id,name,marks) values(?,?,?)";  // ? place holder
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, marks);
			
			int rowCount = ps.executeUpdate();
			
			if(rowCount>0) {
				System.out.println("Data add SUCESS...");
			}
			
		}
		
		
}
