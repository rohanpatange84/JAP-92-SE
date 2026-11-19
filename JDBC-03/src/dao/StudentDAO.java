package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDAO {

	public void addStudent(Student student) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2 Get DB Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92", "root", "7666");

			// String query = "insert into student values (" + id + ",'" + name + "'," +
			// marks + " )";
			String query = "insert into student (id,name,marks) values(?,?,?)"; // ? place holder

			// Create PreparedStatement Object By Calling method from Connection
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setDouble(3, student.getMarks());

			// Excute Query

			int rowCount = ps.executeUpdate();

			if (rowCount > 0)
				System.out.println("Data Added SUCESS...");
		} catch (Exception e) {

			System.out.println("While Adding Student   --->   " + e);

		}
	}

	public List<Student> getAllStudents() {

		List<Student> list = new ArrayList<Student>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92", "root", "7666");

			String SQL = "SELECT ID,NAME,MARKS FROM STUDENT";
			PreparedStatement ps = con.prepareStatement(SQL);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student student = new Student(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				list.add(student);
			}
		} catch (Exception e) {
			System.out.println("While Reading Student  " + e);
		}

		return list;
	}

	public static Student findStudentById(int id) {
		Student s1 = new Student();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92", "root", "7666");

			String query = "select * from student where id =?"; // ? place holder

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s1.setId(rs.getInt(1));

				s1.setName(rs.getString(2));

				s1.setMarks(rs.getDouble(3));
			}

			
			return s1;
		} catch (Exception e) {

			System.out.println("While Finding Student   --->   " + e);

		}
		return s1;

	}

	public static void findAllNames() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jap92", "root", "7666");

			String query = "select name from student;";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getInt(1) + " ");

				System.out.println();
			}

			int rowCount = ps.executeUpdate();

			if (rowCount > 0)
				System.out.println("Data Find SUCESS...");

		} catch (Exception e) {

			System.out.println("While Finding Name of All Student   --->   " + e);

		}

	}

}