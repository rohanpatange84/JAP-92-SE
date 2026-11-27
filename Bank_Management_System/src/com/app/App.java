package com.app;

import java.util.Scanner;

import com.dao.BankDAO;

import com.model.Bank;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BankDAO dao = new BankDAO();

		boolean light = true;

		do {
			System.out.println("------------------------");
			System.out.println("Enter 1   Adding User");
			System.out.println("Enter 2   Delete User");
			System.out.println("Enter 3   Read User");
			System.out.println("Enter 10  Exit!");
			int n = sc.nextInt();

			switch (n) {

			case 1:

				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter password");
				int password = sc.nextInt();
				Bank b1 = new Bank(name, password);

				dao.addBank(b1);

				break;
			case 2:

				System.out.println("Enter id");
				int id = sc.nextInt();
				

				dao.deleteBank(id);

				break;
				
			case 3:

				dao.readBank();

				break;

			case 10:

				light = false;

				break;

			default:
				System.out.println("Invalid input....!");
				break;

			}

		} while (light);

	}

}
