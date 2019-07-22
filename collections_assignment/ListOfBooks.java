package com.accolite.au.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import com.accolite.au.collections.Book;

public class ListOfBooks {

	public static void main(String[] args) {
		Book b1 = new Book("os", "Galvin", 400);
		Book b2 = new Book("Python", "Andrew", 450);
		Book b3 = new Book("C++", "Balaguruswamy", 400);
		Book b4 = new Book("java", "piyush", 500);
		Book b5 = new Book("C", "yashwant", 400);
		Book b6 = new Book("Cloud", "Andrew", 450);
		Book b7 = new Book("Oops", "Abhishek", 200);
		Book b8 = new Book("Dbms", "Coremann", 150);
		Book b9 = new Book("Network", "frouzan", 190);
		Book b10 = new Book("Digital", "Morris", 200);
		Book b11 = new Book("Discrete", "kenneth", 150);
		Book b12 = new Book("Web", "Andrew", 190);
		// creating list of books and adding items to it
		List<Book> book = new ArrayList<>();
		book.add(b1);
		book.add(b2);
		book.add(b3);
		book.add(b4);
		book.add(b5);
		book.add(b6);
		book.add(b7);
		book.add(b8);
		book.add(b9);
		book.add(b10);
		book.add(b11);
		book.add(b12);
		System.out.println("List of Books.....");
		for (Book b : book)
			System.out.println(b);
		// sorting based on price using comparable
		Collections.sort(book);
		System.out.println("Sorted List-Based on Price,using comparable");
		for (Book b : book)
			System.out.println(b);
		System.out.println("\n");
		// sorting based on price using comparator
		book.sort(new BookComparator());
		System.out.println("Sorted List-Based on Price and then name,using comparator function");
		for (Book b : book)
			System.out.println(b);
		System.out.println("\n");
		Iterator<Book> iter = book.iterator();
		while (iter.hasNext()) {
			Book cur = (Book) iter.next();
			cur.decreaseByTwenty();
		}
		System.out.println("Books after giving discount of 20%,");
		for (Book b : book)
			System.out.println(b);
		System.out.println("\n");

	}

}
