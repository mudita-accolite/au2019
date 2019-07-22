package com.accolite.au.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.accolite.au.collections.Book;

public class BookHashMap {

	public static void main(String[] args) {
		Book b1 = new Book("os", "Galvin", 400);
		Book b2 = new Book("Python", "Andrew", 450);
		Book b3 = new Book("C++", "Balaguruswamy", 400);
		Book b4 = new Book("java", "piyush", 500);
		Book b5 = new Book("C", "Andrew", 400);
		Book b6 = new Book("Cloud", "Balaguruswamy", 450);
		Book b7 = new Book("Oops", "Abhishek", 200);
		Book b8 = new Book("Dbms", "Coremann", 150);
		Book b9 = new Book("Network", "frouzan", 190);
		Book b10 = new Book("Digital", "Morris", 200);
		Book b11 = new Book("Discrete", "kenneth", 150);
		Book b12 = new Book("Web", "Andrew", 190);
		// creating list of books and storing value in the list
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
		HashMap<String, Integer> map = new HashMap<>();
		// checking which authors have written more than 2 books and storing the details
		// in map.
		for (Book b : book) {
			String s = b.getAuthorName();
			if (map.containsKey(s))
				map.put(s, map.get(s) + 1);
			else
				map.put(s, 1);
		}
		// HashMap having Author Name and Number of Books written greater than 2
		System.out.println("Authors who have written more than 2 books:");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 2)
				System.out.println(entry.getKey());
		}

	}

}
