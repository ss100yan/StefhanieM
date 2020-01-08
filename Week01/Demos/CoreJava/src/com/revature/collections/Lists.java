package com.revature.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.revature.classes.Planet;

public class Lists {

	public static void main(String[] args) {
		
		//Covariance
		List list1 = new ArrayList(); //List with no type safety
		/*
		 * When using a collection, we typically use generics to enforce
		 * type safety. This guarantees that everything that is added to
		 * this list is of the specified type. You cannot use primitives
		 * here.
		 */
		List<String> list2 = new ArrayList<>(); //List with type safety.
		
		//Adding objects to our list
		list1.add("string literal");
		list1.add(1); //example of autoboxing
		list1.add(new Planet());
		
//		System.out.println(list1);
		
		list2.add("turn");
		list2.add("down");
		list2.add("for");
		list2.add("what");
		
		//Removing objects from our list
		list1.remove(0);
		list1.remove(new Planet()); //not a reference to the planet I added above
		
		//Retrieving objects in our list
//		System.out.println(list1.get(0));
//		
//		System.out.println(list1);
//		
//		System.out.println(list2);
		
		//TRADITIONAL FOR LOOP vs FOR EACH LOOP/ENHANCED FOR LOOP
		
		//traditional for loop
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		
		//enhanced for loop/for each loop
		for(String s : list2) {
			System.out.println(s);
		}
		
		//We can also use an iterator
		Iterator it = list2.iterator();
		
		/*
		 * This is a while loop. It is one option for flow control. You pass
		 * a boolean expression to it (something that evaluates to true or false)
		 * and this loop executes as long as the expression evalutes to true.
		 */
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		/*
		 * NOTE: You may also use a do-while loop if you want the code inside
		 * of your loop to run at least once.
		 */
		
		do {
			System.out.println("I'm running at least once.");
		}while(false);
	}
}
