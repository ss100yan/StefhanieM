package com.revature.lambdas;


/*
 * As of Java 8, we can use lambda expressions to pass around our implementations
 * in order to perform more functional programming. In order to use Lambda,
 * we must use a special type of interface called a functional interface.
 */
public class Lambdas {

	//When using Lambdas, we use the functional interface as our reference
	//type like so:
	
	FunctionalInterface add = (int x, int y) -> {return x + y;};
	FunctionalInterface subtract = (int x, int y) -> {return x - y;};
	FunctionalInterface multiply = (int x, int y) -> {return x * y;};
	
	public static void main(String[] args) {
		
		Lambdas lambdas = new Lambdas();
		System.out.println(lambdas.math(lambdas.multiply, 3, 4));
	}
	
	/*
	 * We can pass our implementations around our application like so:
	 */
	public int math(FunctionalInterface mathOp, int x, int y) {
		return mathOp.doMath(x, y);
	}
}


