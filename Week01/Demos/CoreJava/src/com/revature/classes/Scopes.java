package com.revature.classes;

/*
 * In Java, variables may have several different scopes. A variable's
 * scope may be:
 * 
 * instance
 * method/local
 * block/loop
 */
public class Scopes {

	/*
	 * These are instance variables. They are accessible all throughout
	 * this class. Each instance of this class comes with its own copy
	 * of each of these instance variables. Instance variables do not
	 * have to be assigned a value, but they can be. If they are not
	 * assigned a value, they will be given the most basic value they
	 * can be given. Objects are "null" if not assigned a value. Primitives
	 * are given basic "0" or false values. int, for instance, defaults to
	 * 0.
	 */
	private int scopeInt;
	private String scopeString;
	private Pojo scopePojo;
	
	public void methodScope() {
		/*
		 * This is a local variable. It is NOT available for use
		 * outside of this method, but it is available for use
		 * all throughout this method.
		 */
		int i = 0;
		
		/*
		 * If we create a variable within a loop, that variable is only
		 * in scope within that loop. For instance, "e" cannot be
		 * accessed outside of this "for loop".
		 */
		
		for(int e = 0; e < 5; e++) {
			
		}
		
	}
}
