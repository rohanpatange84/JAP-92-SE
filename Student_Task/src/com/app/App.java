package com.app;

import java.time.LocalDate;
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
			System.out.println("------------------------");
			System.out.println("Enter 1  Adding Data");
			System.out.println("Enter 2  Deleting Data");
			System.out.println("Enter 3  Updating Data");
			System.out.println("Enter 4  Reading Data");
			System.out.println("Enter 5  Get StudentById");
			System.out.println("Enter 6  Updating Data WithID");

			System.out.println("Enter 7  Get Maximum Marks");
			System.out.println("Enter 8  Get Minimum Marks");


			System.out.println("Enter 10  Exit!");

			n = sc.nextInt();

			switch (n) {

			case 1:
				sc.nextLine();
				System.out.println("Enter Name:");
				String name = sc.nextLine();
				System.out.println("Enter Mark:");
				double mark = sc.nextDouble();
				System.out.println("Enter yaer");
				int year = sc.nextInt();
				System.out.println("Enter month");
				int month = sc.nextInt();
				System.out.println("Enter day");
				int day = sc.nextInt();
				LocalDate lo = LocalDate.of(year, month, day);
				s1 = new Student(name, mark, lo);
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
				if (StudentDAO.isIdPresent(id3)) {
					sc.nextLine();
					System.out.println("Enter Name:");
					String name3 = sc.nextLine();
					System.out.println("Enter Mark:");
					double mark3 = sc.nextDouble();
					System.out.println("Enter yaer");
					int year3 = sc.nextInt();
					System.out.println("Enter month");
					int month3 = sc.nextInt();
					System.out.println("Enter day");
					int day3 = sc.nextInt();
					LocalDate lo3 = LocalDate.of(year3, month3, day3);
					dao.updateStudent(id3, name3, mark3, lo3);
				} else {
					System.out.println("Invalid id");
				}
				break;

			case 4:
				dao.readStudent();
				break;

			case 5:
				System.out.println("Enter id:");
				int id5 = sc.nextInt();
				Student s5 = dao.getStudentById(id5);
				System.out.println(s5);
				break;
				
			case 6:
				System.out.println("Enter id:");
				int id6 = sc.nextInt();
				if (StudentDAO.isIdPresent(id6)) {
					
					System.out.println("Enter newId:");
					int newId=sc.nextInt();
					sc.nextLine();
;					System.out.println("Enter Name:");
					String name3 = sc.nextLine();
					System.out.println("Enter Mark:");
					double mark3 = sc.nextDouble();
					System.out.println("Enter yaer");
					int year3 = sc.nextInt();
					System.out.println("Enter month");
					int month3 = sc.nextInt();
					System.out.println("Enter day");
					int day3 = sc.nextInt();
					LocalDate lo3 = LocalDate.of(year3, month3, day3);
					dao.updateStudentWithId(id6,newId, name3, mark3, lo3);
				} else {
					System.out.println("Invalid id");
				}
				break;


			case 7:
				System.out.println("Enter id:");
				int id61 = sc.nextInt();
				if (StudentDAO.isIdPresent(id61)) {

					System.out.println("Enter newId:");
					int newId = sc.nextInt();
					sc.nextLine();
					;
					System.out.println("Enter Name:");
					String name3 = sc.nextLine();
					System.out.println("Enter Mark:");
					double mark3 = sc.nextDouble();
					System.out.println("Enter yaer");
					int year3 = sc.nextInt();
					System.out.println("Enter month");
					int month3 = sc.nextInt();
					System.out.println("Enter day");
					int day3 = sc.nextInt();
					LocalDate lo3 = LocalDate.of(year3, month3, day3);
					dao.updateStudentWithId(id61, newId, name3, mark3, lo3);
				} else {
					System.out.println("Invalid id");
				}
				break;

			case 8:
				double marks=dao.findMaxMarks();
				System.out.println("Maximum marks "+marks);
				break;
				
			case 88:
				double marks8=dao.findMinMarks();
				System.out.println("Mimum marks "+marks8);
				break;
				
			case 9:
				double average=dao.findAverageMarks();
				System.out.println("Average marks "+average);
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
