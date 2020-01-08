package com.revature.collections;

public class ArraysThreeWays {

	/*
	 * Just in case you're not familiar with how to create arrays in Java, you have
	 * three options:
	 * 
	 * NOTE: Arrays are not part of the Collection interface. They are just
	 * basic Java objects.
	 */

	public static void main(String[] args) {

		String[] arr = { "string 1", "string 2" };
		String[] arr2 = new String[3];
		String[] arr3 = new String[] { "string 1", "string 2", "string 3" };

		// Note that the "[]" symbol can be placed after the reference variable:

		String arr4[] = { "string 1", "string 2" };

		// And, of course, we can have our multi-dimensional arrays. And, yes,
		// both of these are two-dimensional arrays (so the second one is
		// syntactically valid.

		String[][] arr5 = new String[5][];
		String[] arr6[] = new String[3][];

	}
}
