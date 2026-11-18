package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBook {
	
	public static void updateBook(int id,String name,double price) throws SQLException, ClassNotFoundException {
		

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92", "root", "7666");

		String query = "UPDATE book SET name=? , price=?  WHERE isbnid=?";

		PreparedStatement ps = con.prepareStatement(query);

		ps.setString(1, name);
		ps.setDouble(2, price);
		ps.setInt(3, id);

		int rowCount = ps.executeUpdate();

		if (rowCount > 0)
			System.out.println("Data UPDATE SUCESS...");
	}

}
