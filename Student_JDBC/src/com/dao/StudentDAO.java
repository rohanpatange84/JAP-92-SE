package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Student;

public class StudentDAO {

	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92", "root", "7666");

		} catch (Exception e) {
			System.out.println("While Connection---> " + e);
		}
		return con;
	}

	public static void addStudent(Student s1) {

		try {
			Connection con = getCon();
			String query = "insert into student (id,name,marks) values(?,?,?)"; // ? place holder

			// Create PreparedStatement Object By Calling method from Connection
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, s1.getId());
			ps.setString(2, s1.getName());
			ps.setDouble(3, s1.getMark());

			int rowCount = ps.executeUpdate();

			if (rowCount > 0)
				System.out.println("Data Added SUCESS...");
		} catch (Exception e) {
			System.out.println("While adding data --->" + e);
		}
	}

	public static void deleteStudent(int id) {

		try {
			Connection con = getCon();

			String query = "DELETE FROM STUDENT WHERE id=?";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);

			int rowCount = ps.executeUpdate();

			if (rowCount > 0) {
				System.out.println("Data DELETE SUCESS...");
			}
		} catch (Exception e) {
			System.out.println("While delecting data --->" + e);
		}
	}

	public static void updateStudent(int id, String name, double marks) {

		try {
			Connection con = getCon();

			String query = "UPDATE STUDENT SET name=? , marks=?  WHERE id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, name);
			ps.setDouble(2, marks);
			ps.setInt(3, id);

			int rowCount = ps.executeUpdate();

			if (rowCount > 0)
				System.out.println("Data UPDATE SUCESS...");

		} catch (Exception e) {
			System.out.println("While updating data --->" + e);
		}
	}
	
	public static void readStudent() {

		try {
			Connection con = getCon();

			String query = "select id,name,marks from student;";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getInt(1) + " ");
				System.out.print(rs.getString(2) + " ");
				System.out.print(rs.getDouble(3) + " ");
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("While reding data --->" + e);
		}
	}

}
