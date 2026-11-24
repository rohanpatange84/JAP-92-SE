package com.dao;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			System.out.println("While adding data --->" + e);
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
			System.out.println("While delecting data --->" + e);
		}
	}

	public static void readStudent() {

		String query = "select * from studentD;";
		try (Connection con = DBUtility.getDBConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();) {

			System.out.println("--------------------------------------");
			System.out.println(String.format("%-5s %-10s %-10s  %-10s", "ID", "Name", "Marks", "Date"));
			System.out.println("--------------------------------------");
			while (rs.next()) {
				LocalDate lo = rs.getDate("admission_date").toLocalDate();

				System.out.println(
						String.format("%-5d %-10s %-10s %-10s", rs.getInt(1), rs.getString(2), rs.getDouble(3), lo));

			}
			System.out.println("--------------------------------------");

		} catch (Exception e) {
			System.out.println("While reding data --->" + e);
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
			System.out.println("While updating data --->" + e);
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
			System.out.println("While reding data --->" + e);
		}
		return light;
	}

}
