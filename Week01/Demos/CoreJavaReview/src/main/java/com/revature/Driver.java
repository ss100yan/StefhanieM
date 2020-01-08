package com.revature;

import com.revature.syntax.Syntax;

public class Driver {

	public static void main(String[] args) {
		
		Syntax syntax = new Syntax(); //creating new instance of Syntax class
		Syntax syntax2 = new Syntax();
		
		try {
			/*
			 * You don't need a reference to an object to use it or call
			 * methods on it.
			 */
			System.out.println(syntax.whatsUp("Joseph"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Let's work with method chaining. As stated earlier, we don't need
		//a reference to an object to call methods on it. We can call a method
		//on an object immediately after it has been returned.
		System.out.println(syntax.methodChaining()
				.get(2)
				.concat(" and I concat")
				.isEmpty());
	}
}
