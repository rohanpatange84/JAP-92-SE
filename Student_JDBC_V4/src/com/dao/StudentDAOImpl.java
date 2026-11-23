package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.exception.StudentDAOException;
import com.model.Student;
import com.utilty.DBUtility;

public class StudentDAOImpl implements StudentDAO{

//	public static Connection getCon() {
//		Connection con = null;
//		try() {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92", "root", "7666");
//
//		} catch (Exception e) {
//			System.out.println("While Connection---> " + e);
//		}
//		return con;
//	}

	public void addStudent(Student s1) {
		String query = "insert into student (id,name,marks) values(?,?,?)"; // ? place holder
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setInt(1, s1.getId());
			ps.setString(2, s1.getName());
			ps.setDouble(3, s1.getMark());

			int rowCount = ps.executeUpdate();

			if (rowCount > 0)
				System.out.println("Data Added SUCESS...");
		} catch (Exception e) {
			StudentDAOException ex = new StudentDAOException("Student ADD Failed To Add");
			ex.initCause(e);
			throw ex;
		}
	}

	public void deleteStudent(int id) {
		String query = "DELETE FROM STUDENT WHERE id=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setInt(1, id);

			int rowCount = ps.executeUpdate();

			if (rowCount > 0) {
				System.out.println("Data DELETE SUCESS...");
			}
		} catch (Exception e) {
			StudentDAOException ex = new StudentDAOException("Student DELETE Failed To Delete ");
			ex.initCause(e);
			throw ex;
		}
	}

	public void updateStudent(int id, String name, double marks) {
		String query = "UPDATE STUDENT SET name=? , marks=?  WHERE id=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setString(1, name);
			ps.setDouble(2, marks);
			ps.setInt(3, id);

			int rowCount = ps.executeUpdate();

			if (rowCount > 0)
				System.out.println("Data UPDATE SUCESS...");

		} catch (Exception e) {
			StudentDAOException ex = new StudentDAOException("Student UPDATE Failed To Update ");
			ex.initCause(e);
			throw ex;
		}
	}

	public void readStudent() {
		String query = "select id,name,marks from student;";
		try (Connection con = DBUtility.getDBConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();) {

			System.out.println("-----------------------");
			System.out.println(String.format("%-5s %-10s %-5s", "ID", "Name", "Marks"));
			System.out.println("-----------------------");
			while (rs.next()) {

				System.out.println(String.format("%-5d %-10s %-5s", rs.getInt(1), rs.getString(2), rs.getDouble(3)));

			}
			System.out.println("-----------------------");

		} catch (Exception e) {
			StudentDAOException ex = new StudentDAOException("Student READING Failed To Read ");
			ex.initCause(e);
			throw ex;
		}
	}

	public  Student findStudentById(int id) {
		Student s1 = null;
		String query = "select id,name,marks from student where id=?;";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				s1 = new Student(rs.getInt(1), rs.getString(2), rs.getDouble(3));

			}

		} catch (Exception e) {
			System.out.println("While finding student by id--->" + e);
		}

		if (s1 == null) {
			System.out.println("Student not found with id " + id);
		}

		return s1;

	}

	public  void findAllNames() {
		String query = "select name from student;";
		try (Connection con = DBUtility.getDBConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();) {

			System.out.println("---------");
			System.out.println(String.format("%-10s", "Names"));
			System.out.println("---------");
			while (rs.next()) {

				System.out.println(rs.getString(1));

			}
			System.out.println("---------");

		} catch (Exception e) {
			System.out.println("While reding data --->" + e);
		}
	}

	public  void findIdAndName() {
		String query = "select id,name from student;";
		try (Connection con = DBUtility.getDBConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();) {

			System.out.println("---------------");
			System.out.println(String.format("%-5s %-10s", "Id", "Names"));
			System.out.println("---------------");
			while (rs.next()) {

				System.out.println(String.format("%-5s %-10s", +rs.getInt(1), rs.getString(2)));

			}
			System.out.println("---------------");

		} catch (Exception e) {
			System.out.println("While finding id and names --->" + e);
		}
	}

	public  void findIdAndMark() {

		String query = "select id,marks from student;";
		try (Connection con = DBUtility.getDBConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();) {

			System.out.println("----------------");
			System.out.println(String.format("%-5s %-10s", "Id", "Mark"));
			System.out.println("----------------");
			while (rs.next()) {

				System.out.println(String.format("%-5d %-10f", +rs.getInt(1), rs.getDouble(2)));

			}
			System.out.println("----------------");

		} catch (Exception e) {
			System.out.println("While finding id and marks --->" + e);
		}
	}
	
	
	public  void addAllStudent(List<Student> list) {
		String query = "insert into student (id,name,marks) values(?,?,?)"; // ? place holder
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			for (int i = 0; i < list.size(); i++) {
				Student s1 = list.get(i);
				ps.setInt(1, s1.getId());
				ps.setString(2, s1.getName());
				ps.setDouble(3, s1.getMark());
				ps.addBatch();

			}

			int[] rowCount = ps.executeBatch();

			if (rowCount.length > 0)
				System.out.println("Data Added SUCESS..." + rowCount.length);
		} catch (Exception e) {
			System.out.println("While adding data --->" + e);
		}
	}

//	public static void addAllStudent(List<Student> list) {
//		String query = "insert into student (id,name,marks) values(?,?,?)"; // ? place holder
//
//		for (int i = 0; i < list.size(); i++) {
//			Student s1 = list.get(i);
//			try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(query);) {
//
//				ps.setInt(1, s1.getId());
//				ps.setString(2, s1.getName());
//				ps.setDouble(3, s1.getMark());
//
//				int rowCount = ps.executeUpdate();
//
//				// if (rowCount > 0)
//				// System.out.println("Data Added SUCESS...");
//			} catch (Exception e) {
//				System.out.println("While adding data --->" + e);
//			}
//
//		}
//	}
//
//	public static void addAllStudent2(List<Student> list) {
//
//		for (int i = 0; i < list.size(); i++) {
//			Student s1 = list.get(i);
//			addStudent(s1);
//		}
//
//	}
//
//	public static void addAllStudent3(List<Student> list) {
//		String query = "insert into student (id,name,marks) values(?,?,?)"; // ? place holder
//		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(query);) {
//			int rowCount = 0;
//			for (int i = 0; i < list.size(); i++) {
//				Student s1 = list.get(i);
//				ps.setInt(1, s1.getId());
//				ps.setString(2, s1.getName());
//				ps.setDouble(3, s1.getMark());
//				rowCount = ps.executeUpdate();
//
//			}
//
//			if (rowCount > 0)
//				System.out.println("Data Added SUCESS... " + rowCount);
//		} catch (Exception e) {
//			System.out.println("While adding data --->" + e);
//		}
//	}



}
