package com.revature.varargs;

/*
 * Varargs stands for "variable arguments," and it allows us to pass in
 * what is essentially an array of objects into a method as an argument -
 * but as multiple parameters.
 */
public class Varargs {

	public int add(int x, int y) {
		return x + y;
	}
	
	public int add(int x, int y, int z) {
		return x + y + z;
	}
	
	public static void main(String[] args) {
		
		Varargs vary = new Varargs();
		System.out.println(vary.add(3, 4));
		System.out.println(vary.add(3, 4, 5));
		System.out.println(vary.add(4, 5, 6, 3, 8));
	}
	
	//Let's do this the right way. This allows me to pass in any number of
	//integers into this method as arguments.
	
	/*
	 * NOTE: If you're using varargs, the variable argument must be the last
	 * in your list of arguments. This also implies that there can only
	 * be one variable argument.
	 */
	
	public int add(int z, int...x) {
		int sum = 0;
		
		for(int inty : x) {
			sum += inty;
		}
		
		return sum;
	}
	
}
