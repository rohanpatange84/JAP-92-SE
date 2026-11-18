package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Book;

public class Addbook {
	
	public static void  addBook(Book b1) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92", "root", "7666");

		String query = "insert into book (isbnid,name,price) values(?,?,?)"; // ? place holder

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, b1.getIsbnid());
		ps.setString(2, b1.getName());
		ps.setDouble(3, b1.getPrice());

		int rowCount = ps.executeUpdate();

		if (rowCount > 0) {
			System.out.println("Data add SUCESS...");
		}
		
	}
	
	
	

}
