package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBook {
	
	public static  void deletBook(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92","root","7666");
		
		String query = "DELETE FROM book WHERE isbnid=?";
		
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		
		int rowCount = ps.executeUpdate();
		
		if(rowCount>0) {
			System.out.println("Data DELETE SUCESS...");
		}
	}

}
