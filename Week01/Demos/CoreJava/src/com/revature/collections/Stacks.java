package com.revature.collections;

import java.util.Stack;

/*
 * NOTE: Stacks are considered to be somewhat antiquated and are not as commonly
 * used as other data structures.
 */
public class Stacks {

	public static void main(String[] args) {
		
		Stack<String> s = new Stack<>();
		
		//Adding objects to a stack
		s.add("string 1");
		s.add("string 2");
		s.add("string 3");
		s.add("string 4");
		s.add("string 5");
		s.add("string 6");
		s.add("string 7");
		
		System.out.println(s);
		
		//Remove objects from a stack (both by index and by object"
		s.remove(0);
		s.remove("string 3");
		
		System.out.println(s);
		
		//The pop method removes and returns the object that is on the
		//top of the stack.
		String topOfStack = s.pop();
		System.out.println(topOfStack);
		System.out.println(s);
		
		//The push method adds an object to the top of the stack
		String newlyAdded = s.push("string 8");
		System.out.println(newlyAdded);
	}
}
