package com.revature.equality;

import com.revature.classes.Planet;

public class DotEquals {

	private Planet p;
	private int i;
	
	/*
	 * Our other option for comparing object equality is the "equals" method
	 * which all objects inherit from the Object class. This by default
	 * compares reference equality and then proceeds to compare the values
	 * of each of the fields of an object. That said, if overridden, we can
	 * change this default behavior.
	 */
	
	public static void main(String[] args) {
		
		String s1 = "yo";
		String s2 = "yo";
		String s3 = "no";
		String s4 = "pizza";
		
		System.out.println(s1 == s2); //true because of the String pool
		
		System.out.println(s1.equals(s2));
		
		System.out.println(s1.equals(s4));
	}

	/*
	 * This is the default implementation for the equals method that is
	 * inherited from the Object class.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DotEquals other = (DotEquals) obj;
		if (i != other.i)
			return false;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		return true;
	}
	
}
