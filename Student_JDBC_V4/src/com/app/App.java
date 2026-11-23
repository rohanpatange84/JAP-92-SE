package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.dao.StudentDAO;
import com.dao.StudentDAOFactory;
import com.model.Student;

public class App {
	static StudentDAO dao = StudentDAOFactory.getStudentDAO();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student s1;

		
		boolean light = true;
		int n;
		
		Student s2 = new Student(1, "Rohan", 95.5);
        Student s3 = new Student(2, "Pawan", 88.5);
        Student s4 = new Student(3, "Rahul", 78.5);
        Student s5 = new Student(4, "Amit", 85.0);
        Student s6 = new Student(5, "Suraj", 92.5);
        
		
		List<Student> list = new ArrayList<>();
		
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		list.add(s6);
		

		do {

			System.out.println("Enter 1  Adding Data");
			System.out.println("Enter 2  Deleting Data");
			System.out.println("Enter 3  updating Data");
			System.out.println("Enter 4  Reading Data");
			System.out.println("Enter 5  Find student by id");
			System.out.println("Enter 6  Find all Name");
			System.out.println("Enter 7  Find all Id and Name");
			System.out.println("Enter 8  Find all Id and Mark");
			System.out.println("Enter 9  Adding All Student");
			System.out.println("Enter 10  Exit!");

			n = sc.nextInt();

			switch (n) {

			case 1:
				System.out.println("Enter id:");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Name:");
				String name = sc.nextLine();
				System.out.println("Enter Mark:");
				double mark = sc.nextDouble();
				s1 = new Student(id, name, mark);
				dao.addStudent(s1);
				break;
				
			case 2:
				System.out.println("Enter id:");
				int id2 = sc.nextInt();
				dao.deleteStudent(id2);
				break;

			case 3:
				System.out.println("Enter id:");
				int id3 = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Name:");
				String name3 = sc.nextLine();
				System.out.println("Enter Mark:");
				double mark3 = sc.nextDouble();
				dao.updateStudent(id3, name3, mark3);
				break;

			case 4:
				dao.readStudent();
				break;

			case 5:
				System.out.println("Enter id:");
				int id5 = sc.nextInt();
				Student s22 = dao.findStudentById(id5);
				System.out.println(s22);
				break;

			case 6:
				dao.findAllNames();
				break;

			case 7:
				dao.findIdAndName();
				break;

			case 8:
				dao.findIdAndMark();
				break;
				
			case 9:
				dao.addAllStudent(list);
				break;

			case 10:
				light = false;
				break;

			default:
				System.out.println("Invalid input");
				
			}
			
		} while (light);

	}

}
