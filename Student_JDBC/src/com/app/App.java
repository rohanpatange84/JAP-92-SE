package com.app;

import java.util.Scanner;
import com.dao.StudentDAO;
import com.model.Student;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student s1;

		StudentDAO dao = new StudentDAO();
		boolean light = true;
		int n;
		do {

			
			System.out.println("Enter 1  Adding Data");
			System.out.println("Enter 2  Deleting Data");
			System.out.println("Enter 3  updating Data");
			System.out.println("Enter 4  Reading Data");
			System.out.println("Enter 5  Exit!");

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

				dao.updateStudent(id3,name3,mark3);
				break;

			case 4:

				dao.readStudent();
				break;

			case 5:

				light = false;

				break;

			default:
				System.out.println("Invalid input");

			}
		} while (light);

	}

}
