package com.dao;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.exception.StudentDAOException;
import com.model.Student;
import com.utility.DBUtility;

public class StudentDAO {

	public static void addStudent(Student s1) {
		String query = "insert into studentD (name,marks,admission_date) values(?,?,?)"; // ? place holder
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setString(1, s1.getName());
			ps.setDouble(2, s1.getMarks());
			ps.setObject(3, s1.getAdmissionDate());

			int rowCount = ps.executeUpdate();

			if (rowCount > 0)
				System.out.println("Data Added SUCESS...");
		} catch (Exception e) {
			StudentDAOException ex = new StudentDAOException("Student ADD Failed To Add");
			ex.initCause(e);
			throw ex;
		}
	}

	public static void deleteStudent(int id) {
		String query = "DELETE FROM studentD WHERE id=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setInt(1, id);

			int rowCount = ps.executeUpdate();

			if (rowCount > 0) {
				System.out.println("Data DELETE SUCESS...");
			}
		} catch (Exception e) {
			StudentDAOException ex = new StudentDAOException("Student DELETE Failed To Delete");
			ex.initCause(e);
			throw ex;
		}
	}

	public static void readStudent() {

		String query = "select * from studentD;";
		try (Connection con = DBUtility.getDBConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();) {

			System.out.println("-------------------------------------");
			System.out.println(String.format("%-5s %-10s %-8s %-10s", "ID", "Name", "Marks", "Date"));
			System.out.println("-------------------------------------");
			while (rs.next()) {
				LocalDate lo = rs.getDate("admission_date").toLocalDate();

				System.out.println(
						String.format("%-5d %-10s %-8s %-10s", rs.getInt(1), rs.getString(2), rs.getDouble(3), lo));

			}
			System.out.println("-------------------------------------");

		} catch (Exception e) {
			StudentDAOException ex = new StudentDAOException("Student READ Failed To Read");
			ex.initCause(e);
			throw ex;
		}
	}

	public static void updateStudent(int id, String name, double marks, LocalDate lo) {

		String query = "UPDATE studentD SET name=? , marks=? ,admission_date=? WHERE id=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setString(1, name);
			ps.setDouble(2, marks);
			ps.setObject(3, lo);
			ps.setInt(4, id);

			int rowCount = ps.executeUpdate();

			if (rowCount > 0)
				System.out.println("Data UPDATE SUCESS...");

		} catch (Exception e) {
			StudentDAOException ex = new StudentDAOException("Student UPDATE Failed To Update");
			ex.initCause(e);
			throw ex;
		}
	}

	public static boolean isIdPresent(int id) {
		boolean light = false;
		String query = "select id from studentD;";
		try (Connection con = DBUtility.getDBConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {

				if (rs.getInt(1) == id) {
					light = true;
				}

			}

		} catch (Exception e) {
			StudentDAOException ex = new StudentDAOException("Student CHECK Failed To Check");
			ex.initCause(e);
			throw ex;
		}
		return light;
	}

	public static Student getStudentById(int id) {
		Student student = null;
		String quary = "SELECT * FROM studentD WHERE id = ?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(quary);) {

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setMarks(rs.getDouble("marks"));
				student.setAdmissionDate(rs.getDate("admission_date").toLocalDate());
			}

		} catch (Exception e) {

			StudentDAOException ex = new StudentDAOException("Student GetById Failed To Get");
			ex.initCause(e);
			throw ex;

		}
		return student;

	}

	public static void updateStudentWithId(int id, int newId, String name, double marks, LocalDate lo) {

		String query = "UPDATE studentD SET id =?, name=? , marks=? ,admission_date=? WHERE id=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(query);) {
			ps.setInt(1, newId);
			ps.setString(2, name);
			ps.setDouble(3, marks);
			ps.setObject(4, lo);
			ps.setInt(5, id);

			int rowCount = ps.executeUpdate();

			if (rowCount > 0)
				System.out.println("Data UPDATE SUCESS...");

		} catch (Exception e) {
			StudentDAOException ex = new StudentDAOException("Student UPDATE Failed To Update");
			ex.initCause(e);
			throw ex;
		}
	}

	public static double findMaxMarks() {
		double maxMarks = 0;
		String quary = "SELECT MAX(marks) FROM studentD";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(quary);) {

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				maxMarks = rs.getDouble(1);

			}

		} catch (Exception e) {
			StudentDAOException ex = new StudentDAOException("Student MaxMark Failed To Find");
			ex.initCause(e);
			throw ex;
		}

		return maxMarks;
	}

	public static double findMinMarks() {

		double minMarks = 0;
		String quary = "SELECT MIN(marks) FROM studentD";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(quary);) {

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				minMarks = rs.getDouble(1);

			}

		} catch (Exception e) {
			StudentDAOException ex = new StudentDAOException("Student MaxMark Failed To Find");
			ex.initCause(e);
			throw ex;
		}

		return minMarks;

	}

	public static double findAverageMarks() {

		double average = 0;
		String quary = "SELECT AVG(marks) FROM student";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(quary);) {

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				average = rs.getDouble(1);

			}

		} catch (Exception e) {
			StudentDAOException ex = new StudentDAOException("Student MaxMark Failed To Find");
			ex.initCause(e);
			throw ex;
		}

		return average;

	}

}
