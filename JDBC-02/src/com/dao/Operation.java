package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Book;

public class Operation {
	
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
