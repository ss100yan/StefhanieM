package com.revature.equality;

import com.revature.classes.Planet;

public class DoubleEquals {

	/*
	 * In Java, there are several ways to compare object equality. One of
	 * those entails using the == (double equals) operator. This operator
	 * compares the addresses of two objects. This is referred to as 
	 * "reference equality".
	 */
	
	public static void main(String[] args) {
		
		Planet p = new Planet();
		Planet p2 = new Planet();
		Planet p3 = new Planet();
		
		p = p2;
		
		System.out.println(p == p2); //NOW p and p2 point to the same object
	}
}
