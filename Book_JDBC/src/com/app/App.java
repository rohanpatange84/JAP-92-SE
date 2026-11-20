package com.app;

import java.util.Scanner;
import com.model.Book;
import com.dao.BookDAO;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookDAO dao = new BookDAO();

		Book b1;
		boolean light = true;

		do {
			
			System.out.println("Enter 1 Adding data");
			System.out.println("Enter 2 Deleting data");
			System.out.println("Enter 3 Updating data");
			System.out.println("Enter 4 Reading data");
			System.out.println("Enter 5 Exit");
			
			int n = sc.nextInt();

			switch (n) {
			case 1:
				System.out.println("Enter id: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter name: ");
				String name = sc.nextLine();
				System.out.println("Enter price: ");
				double price = sc.nextDouble();
				b1 = new Book(id, name, price);
				dao.insertBook(b1);

				break;

			case 2:
				System.out.println("Enter id: ");
				int id2 = sc.nextInt();
				dao.deletBook(id2);
				break;

			case 3:
				System.out.println("Enter id: ");
				int id3 = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter name: ");
				String name3 = sc.nextLine();
				System.out.println("Enter price: ");
				double price3 = sc.nextDouble();
				dao.updateBook(id3, name3, price3);

				break;

			case 4:
				dao.readBooks();
				break;
			
			default:
				System.out.println("Invalid input...!");
				break;

			}

		} while (light);

	}
}
