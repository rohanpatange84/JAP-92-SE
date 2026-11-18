package com.model;

import java.util.Objects;

public class Book {
	
	private int isbnid;
	private String name;
	private double price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int isbnid, String name, double price) {
		super();
		this.isbnid = isbnid;
		this.name = name;
		this.price = price;
	}

	public int getIsbnid() {
		return isbnid;
	}

	public void setIsbnid(int isbnid) {
		this.isbnid = isbnid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbnid=" + isbnid + ", name=" + name + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbnid, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return isbnid == other.isbnid && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	

}
