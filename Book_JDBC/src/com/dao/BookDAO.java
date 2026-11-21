package com.dao;

import com.model.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {

	public static Connection getCon() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92", "root", "7666");
		} catch (Exception e) {
			System.out.println("While Conniction Building--->");
		}

		return con;

	}

	public static void insertBook(Book b1) {

		try {
			Connection con = getCon();
			
			String quary = "insert into book(isbnid,name,price) values(?,?,?)";

			PreparedStatement ps = con.prepareStatement(quary);
			ps.setInt(1, b1.getId());
			ps.setString(2, b1.getName());
			ps.setDouble(3, b1.getPrice());

			int rowCount = ps.executeUpdate();

			if (rowCount > 0) {
				System.out.println("Data Add SUCESS...");
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println("While Adding data---> " + e);
		}

	}

	public static void deletBook(int id) {

		try {
			Connection con = getCon();
			String quary = "delete from book where isbnid=?";

			PreparedStatement ps = con.prepareStatement(quary);
			ps.setInt(1, id);

			int rowCount = ps.executeUpdate();

			if (rowCount > 0) {
				System.out.println("Data Delet SUCESS...");
			}
			ps.close();
			con.close();

		} catch (Exception e) {
			System.out.println("While Deletion data---> " + e);
		}
	}

	public static void updateBook(int id, String name, double price) {
		try {

			Connection con = getCon();

			String quary = "update book set name=? , price=? where isbnid=?";

			PreparedStatement ps = con.prepareStatement(quary);
			ps.setString(1, name);
			ps.setDouble(2, price);
			ps.setInt(3, id);

			int rowCount = ps.executeUpdate();

			if (rowCount > 0) {
				System.out.println("Data Update Sucess");
			}
			ps.close();
			con.close();

		} catch (Exception e) {

			System.out.println("While Updating Data---> " + e);
		}
	}

	public static void readBooks() {

		try {

			Connection con = getCon();
			
			String quary = "select * from book";

			PreparedStatement ps = con.prepareStatement(quary);

			ResultSet rs = ps.executeQuery();
			System.out.println("---------------------------------");

			System.out.println(String.format("%-5s %-15s %-5s", "ID", "NAME", "PRICE"));
			System.out.println("---------------------------------");

			while (rs.next()) {
				System.out.println(String.format("%-5d %-15s %-5f", rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
			System.out.println("---------------------------------");

			rs.close();
			ps.close();
			con.close();

		} catch (Exception e) {
			System.out.println("While Reading DATA---> ");
		}

	}
	

}
