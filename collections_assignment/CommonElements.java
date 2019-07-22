package com.accolite.au.collections;

import java.util.ArrayList;
import java.util.stream.*;

public class CommonElements {
	public static void main(String args[]) {
		// creating two ArrayLists
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		// Adding items to list1
		list1.add("Hello");
		list1.add("This");
		list1.add("Is");
		list1.add("Java");
		// adding items to list2
		list2.add("Hello");
		list2.add("Java");
		list2.add("Folks");
		// checking for the common elements
		ArrayList<String> list3 = new ArrayList<String>();
		for (String s1 : list1) {
			if (list2.contains(s1)) {
				list3.add(s1);
			}
		}
		System.out.println("common elements in the array lists are");
		System.out.println(list3);

		// we can perform the same task using stream filter,which is explained below
		ArrayList<String> list4 = new ArrayList<String>();
		ArrayList<String> list5 = new ArrayList<String>();
		// Adding items to list4
		list4.add("a");
		list4.add("b");
		list4.add("c");
		list4.add("d");
		list4.add("e");
		list4.add("f");
		list4.add("b");
		// adding items to list5
		list5.add("b");
		list5.add("d");
		list5.add("e");
		list5.add("h");
		list5.add("g");
		list5.add("c");
		// checking for the common elements using stream filter
		System.out.print("Common elements of both lists are: \n");
		System.out.println(list4.stream().filter(list5::contains).collect(Collectors.toList()));
	}
}
