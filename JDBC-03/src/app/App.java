package app;

import java.util.List;

import dao.StudentDAO;
import model.Student;

public class App {

	public static void main(String[] args) {

		// user input

		StudentDAO dao = new StudentDAO();
		Student student = new Student(11, "Kalpesh", 77.77);

		// store to db

		List<Student> list = dao.getAllStudents();
		
		Student s1 = dao.findStudentById(12);
		
		System.out.println(s1);
		
//		System.out.println(list);
//		
//		System.out.println("------------------");
//		
//		dao.findAllNames();

	}

}