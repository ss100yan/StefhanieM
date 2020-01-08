package com.revature.collections;

import java.util.Set;
import java.util.TreeSet;

public class Sets {

	public static void main(String[] args) {
		
		/*
		 * The TreeSet is an implementation of SortedSet, a subinterface of
		 * Set, that sorts the objects using their natural order.
		 */
		Set<String> s = new TreeSet<>();
		
		//Adding objects to my set
		s.add("string 1");
		s.add("string 2");
		s.add("thing 1");
		s.add("thing 2");
		
		System.out.println(s);
		
		//Removing a string from my set
		s.remove("string 1");
		
		System.out.println(s);
	}
}
