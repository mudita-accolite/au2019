package com.accolite.au.collections;

public class Book implements Comparable<Book> {

	String name;
	String authorName;
	int price;

	public Book(String name, String authorName, int price) {
		super();
		this.name = name;
		this.authorName = authorName;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return name + "->" + authorName + "->" + price;
	}

	@Override
	public int compareTo(Book b) {
		if (this.getPrice() > b.getPrice())
			return 1;
		else if (this.getPrice() < b.getPrice())
			return -1;
		return 0;

	}

	public void decreaseByTwenty() {
		int dec = 20 * price / 100;
		price = price - dec;
	}
}
