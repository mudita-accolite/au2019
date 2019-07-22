package com.accolite.au.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DuplicateStrings {

	public static void main(String[] args) {
		// creating a list of strings
		List<String> list = new ArrayList<String>();
		// adding elements to list
		list.add("tables");
		list.add("chairs");
		list.add("sofa");
		list.add("tables");
		list.add("fans");
		list.add("lights");
		list.add("beds");
		list.add("mattress");
		list.add("beds");
		List<String> list1 = new ArrayList<String>();
		// storing duplicate items in a different list
		for (String s : new ArrayList<String>(list)) {
			list.remove(s);
			if (list.contains(s) && !list1.contains(s))
				list1.add(s);
		}
		Collections.sort(list1);
		// printing the remaining elements in alphabetical order
		System.out.println("List having duplicates in alphabetical order is,");
		int i;
		for (i = 0; i < list1.size() - 1; i++)
			System.out.print(list1.get(i) + ", ");
		if (i == (list1.size()) - 1)
			System.out.println(list1.get(i));

	}

}