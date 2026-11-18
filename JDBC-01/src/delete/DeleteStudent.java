package delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DeleteStudent {
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			int id =12;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92","root","7666");
			
			String query = "DELETE FROM STUDENT WHERE id=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			int rowCount = ps.executeUpdate();
			
			if(rowCount>0) {
				System.out.println("Data DELETE SUCESS...");
			}
			
		}
}
