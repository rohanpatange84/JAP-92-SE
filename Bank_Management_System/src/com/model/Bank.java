package com.model;

import java.util.Random;

public class Bank {
	private static int id = 1;
	private long accountNo;
	private String name;
	private double balance = 10000;

	Random rand = new Random();

	public Bank(String name) {

		this.id = id++;
		this.accountNo = rand.nextLong(10_000_000_000L, 100_000_000_000L);

	}

	public static int getId() {
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

	@Override
	public String toString() {
		return "Bank [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + ", rand=" + rand + "]";
	}

	public void depositeMoney(double amount) {

		this.balance = this.balance + amount;

		System.out.println("Monet deposite SUCESS");

	}

	public void withdrawMoney(double amount) {

		if (amount > this.balance) {
			System.out.println("Insufficent Balance...!");
		} else {
			this.balance = this.balance - amount;
			System.out.println("Withdraw SUCESS");
		}
	}
	
	
	
	

}
