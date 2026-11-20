package com.app;
import com.model.Book;
import com.dao.BookDAO;

public class App {
		public static void main(String[] args) {
			BookDAO dao = new BookDAO();
			
			Book b1 = new Book(111,"Harry Potter",999);
			
			dao.insertBook(b1);
			dao.deletBook(2);
			dao.updateBook(3,"abc",888);
			
			
			
			
		}
}
