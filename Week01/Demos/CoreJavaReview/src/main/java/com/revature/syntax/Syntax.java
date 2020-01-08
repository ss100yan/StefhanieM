package com.revature.syntax;

import java.util.ArrayList;
import java.util.List;

public class Syntax {

	private int id;
	private int id2 = 4; //initialized field
	private final String s;
	
	/*
	 * This is an instance initializer. This block is run every single time
	 * we create an instance of the class.
	 */
	{
		s = "stuff";
		System.out.println("I just created an instance of the class.");
	}
	
	/*
	 * This is a static initializer. It is executed only once.
	 */
	static {
		System.out.println("Bomb.com static initializer.");
	}
	
	/*
	 * This is a constructor. Notice that it has no return type.
	 */
	public Syntax() {
		System.out.println("This is a constructor.");
	}
	
	/*
	 * This is NOT a constructor as it has a return type. It is just a method.
	 * Also, it's just bad practice to name a method this way.
	 */
	public void Syntax() {
		System.out.println("This is NOT a constructor.");
	}
	
	/*
	 * In order to use this method, I NEED an instance of this class.
	 */
	public String whatsUp(String name) throws Exception{
		
		if(name.equals("Dio Brando")) {
			throw new Exception();
		}
		return "What's up, " + name + " ?!";
	}
	
	public List<String> methodChaining(){
		List<String> strings = new ArrayList<>();
		
		strings.add("Christina");
		strings.add("Russ");
		strings.add("No JoJo characters...aww");
		
		return strings;
		
	}
}
