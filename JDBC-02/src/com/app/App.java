package com.app;



import java.sql.SQLException;

import com.dao.Operation;
import com.model.Book;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Book b1 = new Book(1, "ABC", 120);
		Book b2 = new Book(2, "XYZ", 220);
		Book b3 = new Book(3, "PQR", 330);
		
		Operation.addBook(b1);
		Operation.addBook(b2);
		Operation.deletBook(1);
		Operation.updateBook(2, "uuu", 777);

		
		

		

	}
}
