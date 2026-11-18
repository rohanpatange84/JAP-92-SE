package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UpdateStudent {
		public static void main(String[] args) throws ClassNotFoundException, SQLException{
			
			int id = 10;
			String name = "Vivek";
			double marks = 98;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92","root","7666");
			
			String query = ""
			
		}
}
