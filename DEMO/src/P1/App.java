package P1;

import java.util.Scanner;

class Student {
	static int id=1;
	String name;
	double mark;
	 int newid;
	
	

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, double mark) {
		
		this.newid = id++;
		this.name = name;
		this.mark = mark;
	}

	public static int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student [id=" + newid +
			       ", name=" + name +
			       ", mark=" + mark + "]";
	}

}

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Student s1[] = new Student[2];

		for (int i = 0; i < s1.length; i++) {

			
			System.out.println("Enter Name");
			
			String name = sc.next();
			System.out.println("Enter marks");
			double mark = sc.nextDouble();

			s1[i] = new Student(name, mark);

		}

		for (int i = 0; i < s1.length; i++) {

		System.out.println(s1[i]);

		}

	}

}
