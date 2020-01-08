package com.revature.collections;

import java.util.Vector;

public class Vectors {

	public static void main(String[] args) {
		
		Vector<String> v = new Vector<>();
		
		//Adding object to vector
		v.add("string 1");
		v.add("string 2");
		v.add("string 3");
		
		System.out.println(v);
		
		//Removing object from vector by index
		v.remove(0);
		//Removing object from vector
		v.remove("string 2");
		
		System.out.println(v);
		
	}
}
