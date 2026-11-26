package com.dao;

import java.time.LocalTime;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.exception.StudentDAOException;
import com.model.Student;
import com.utility.DBUtility;

public class StudentDAO {

	public static void addStudent(Student s1) {
		String query = "insert into studentst (name,marks,admission_date,admission_time) values(?,?,?,?)"; // ? place
																											// holder
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setString(1, s1.getName());
			ps.setDouble(2, s1.getMarks());
			ps.setObject(3, s1.getAdmissionDate());
			ps.setObject(4, s1.getAdmissionTime());

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
		String query = "DELETE FROM studentst WHERE id=?";
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

		String query = "select * from studentst;";
		try (Connection con = DBUtility.getDBConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();) {

			System.out.println("---------------------------------------------------");
			System.out.println(String.format("%-5s %-10s %-8s %-15s %-10s", "ID", "Name", "Marks", "Date", "Time"));
			System.out.println("---------------------------------------------------");
			while (rs.next()) {
				LocalDate lo = rs.getDate("admission_date").toLocalDate();
				LocalTime lt = rs.getTime("admission_time").toLocalTime();

				System.out.println(String.format("%-5d %-10s %-8s %-15s %-10s", rs.getInt(1), rs.getString(2),
						rs.getDouble(3), lo, lt));

			}
			System.out.println("---------------------------------------------------");

		} catch (Exception e) {
			StudentDAOException ex = new StudentDAOException("Student READ Failed To Read");
			ex.initCause(e);
			throw ex;
		}
	}

//
	public static void updateStudent(int id, String name, double marks, LocalDate lo, LocalTime lt) {

		String query = "UPDATE studentst SET name=? , marks=? ,admission_date=?,admission_time=? WHERE id=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			ps.setString(1, name);
			ps.setDouble(2, marks);
			ps.setObject(3, lo);
			ps.setObject(4, lt);
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

	public static boolean isIdPresent(int id) {
		boolean light = false;
		String query = "select id from studentst;";
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
		String quary = "SELECT * FROM studentst WHERE id = ?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(quary);) {

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setMarks(rs.getDouble("marks"));
				student.setAdmissionDate(rs.getDate("admission_date").toLocalDate());
				student.setAdmissionTime(rs.getTime("admission_time").toLocalTime());
			}

		} catch (Exception e) {

			StudentDAOException ex = new StudentDAOException("Student GetById Failed To Get");
			ex.initCause(e);
			throw ex;

		}
		return student;

	}

	public static void updateStudentWithId(int id, int newId, String name, double marks, LocalDate lo,LocalTime lt) {

		String query = "UPDATE studentst SET id =?, name=? , marks=? ,admission_date=?,admission_time=? WHERE id=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(query);) {
			ps.setInt(1, newId);
			ps.setString(2, name);
			ps.setDouble(3, marks);
			ps.setObject(4, lo);
			ps.setObject(5, lt);
			ps.setInt(6, id);

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
		String quary = "SELECT MAX(marks) FROM studentst";
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
		String quary = "SELECT MIN(marks) FROM studentst";
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
		String quary = "SELECT AVG(marks) FROM studentst";
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
