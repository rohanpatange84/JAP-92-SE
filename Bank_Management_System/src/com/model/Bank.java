package com.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Bank {
	private static int idGEN = 1;
	private int id;
	private long accountNo;
	private String name;
	private double balance = 10000;
	private int password;
	LocalDate date;
	LocalTime time;

	Random rand = new Random();

	Scanner sc = new Scanner(System.in);

	public Bank(String name, int password) {

		this.id = idGEN++;
		this.name = name;
		this.accountNo = rand.nextLong(10_000_000_000L, 100_000_000_000L);

		this.date = LocalDate.now();

		this.time = LocalTime.now();

	}

	public int getId() {
		return id;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + ", date="
				+ date + ", time=" + time + "]";
	}

	public void depositeMoney(double amount) {

		this.balance = this.balance + amount;

		System.out.println("Monet deposite SUCESS");

	}

	public void withdrawMoney() {

		System.out.println("Enter password");
		int pass = sc.nextInt();

		if (pass == this.password) {

			System.out.println("Enter amount");
			int amount = sc.nextInt();

			if (amount > this.balance) {
				System.out.println("Insufficent Balance...!");
			} else {
				this.balance = this.balance - amount;
				System.out.println("Withdraw SUCESS");
			}

		} else {
			System.out.println("Wrong Password..!");
		}

	}

}
