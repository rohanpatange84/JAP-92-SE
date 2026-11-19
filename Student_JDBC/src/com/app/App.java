package com.app;


import com.dao.StudentDAO;
import com.model.Student;

public class App {
	
	public static void main(String[] args) {
		
		Student s1 = new Student(11,"Suraj",85);
		
		StudentDAO dao = new StudentDAO();
		
		dao.deleteStudent(22);
		dao.addStudent(s1);
		dao.readStudent();
		dao.updateStudent(12,"Rohan P",98);
		dao.readStudent();
		
		
		
		
		
		
		
		
	}

}
