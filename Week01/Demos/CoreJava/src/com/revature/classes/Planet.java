package com.revature.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * Packages in Java are used to logically organize our classes and interfaces. They
 * also serve name spaces which help us avoid naming conflicts. Addendum: Packages
 * are conventionally named using reverse domain naming.
 * 
 * Also, note that our class name starts with a capital letter. This is just convention.
 * 
 * NOTE: There can only be one public class per file in Java.
 * 
 * When you create a new class, there is no intrinsic way of sorting or
 * comparing the instances of that class. For instance, how would you
 * compare two planets?
 * 
 * The solution to this is to use either the Comparable or Comparator
 * interface. The Comparable interface is internal to a class whereas
 * the Comparator interface is external to a class.
 */
public class Planet implements Serializable, Comparable<Planet>{
	
	/*
	 * We also typically include fields (member variables) in our classes. So let's
	 * define a couple:
	 * 
	 * NOTE: Each time we create a Planet object, it will come with its own copies
	 * of each of these fields.
	 * 
	 * ACCESS MODIFIERS
	 * ================
	 * 
	 * There are 4 access modifiers in Java:
	 * 
	 * public: the field/method is accessible from anywhere within the application
	 * protected: the field/method is accessible from within this package AND within
	 * 			  classes which extend this class
	 * default (package-private): the field/method is accessible only within this package
	 * private: the field/method is accessible only within this class
	 */
	
	/*
	 * The transient modifier specifies that this field will not be serialized.
	 */
	public transient String myString;
	private int savingPrivateInt;
	int defaultInt; //The implication is that if there is no access modifier explicitly
	                //provided, the access is "default"
	protected String protectMe;

	/*
	 * This is a constructor. Note that it is NOT a method as it doesn't have a return
	 * type. It is simply used to create new instances of objects.
	 * 
	 * In Java, you are provided with a default constructor which is a "no-args"
	 * constructor. If, however, you explicitly include a constructor here in this
	 * class, you are no longer using the default constructor.
	 */
	public Planet() {
		/*
		 * Recall that all objects in Java inherit from the Object class. Whenever
		 * an object is construct, a call to the super class's constructor is made -
		 * even if we don't explicitly make the call. Let's explicitly add this call
		 * to our constructor:
		 */
		super();
	}
	
	/*
	 * Note that we can create overload versions of our constructor. This time, we
	 * want to create a constructor using fields.
	 */
	
	public Planet(String myString, int savingPrivateInt, int defaultInt, String protectMe) {
		/*
		 * "this" is a keyword which refers to "this instance of the class"
		 */
		this.myString = myString; //GOOD
//		myString = myString; BAD
		this.savingPrivateInt = savingPrivateInt;
		this.defaultInt = defaultInt;
		this.protectMe = protectMe;
	}
	
	/*
	 * We can define methods in order to create reusable blocks of code. What we have
	 * below is referred to as a method signature. A method signature includes:
	 * 
	 * An access modifier
	 * A return type
	 * A method name
	 * A list of parameters(optionally)
	 * A list of exceptions that this method may throw (optionally)
	 */
	
	/*
	 * Typically, our fields will be private. In order to allow access to these fields,
	 * we usually create getters and setters. Getters allow us to "get" our fields while
	 * setters allow us to "mutate" our fields.
	 * 
	 * Getters and Setters typically have conventional names such as "get" + "fieldName".
	 * Let's create some getters and setters!
	 */
	
	public String getMyString() {
		return myString;
	}
	
	public void setMyString(String myString) {
		this.myString = myString;
	}
	
	public int getSavingPrivateInt() {
		return savingPrivateInt;
	}
	
	public void setSavingPrivateInt(int savingPrivateInt) {
		this.savingPrivateInt = savingPrivateInt;
	}
	
	public int getDefaultInt() {
		return defaultInt;
	}
	
	public void setDefaultInt(int defaultInt) {
		this.defaultInt = defaultInt;
	}
	
	public String getProtectMe() {
		return protectMe;
	}
	
	public void setProtectMe(String protectMe) {
		this.protectMe = protectMe;
	}
	
	public void printStuff(String stuff) {
		System.out.println(stuff);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + defaultInt;
		result = prime * result + ((myString == null) ? 0 : myString.hashCode());
		result = prime * result + ((protectMe == null) ? 0 : protectMe.hashCode());
		result = prime * result + savingPrivateInt;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planet other = (Planet) obj;
		if (defaultInt != other.defaultInt)
			return false;
		if (myString == null) {
			if (other.myString != null)
				return false;
		} else if (!myString.equals(other.myString))
			return false;
		if (protectMe == null) {
			if (other.protectMe != null)
				return false;
		} else if (!protectMe.equals(other.protectMe))
			return false;
		if (savingPrivateInt != other.savingPrivateInt)
			return false;
		return true;
	}

	/*
	 * This is a main method in Java. It serves as the entrypoint into our program.
	 * This is where execution begins.
	 */
	public static void main(String[] args) {
//		System.out.println("This is a planet class.");
		
		/*
		 * Let's create an instance of this Planet class and call our printStuff method.
		 * Note that whenever we create an object, it comes with its own copies of
		 * the methods and fields declared on the class -- unless, of course, those fields
		 * or methods are static. The "new" keyword is used with the constructor
		 * to create a new object.
		 * 
		 * The first "Planet" is our reference type. The "p" is our reference variable.
		 */
		
		Planet p = new Planet();
		Planet p2 = new Planet();
		p2.savingPrivateInt = 2;
		p.printStuff("Passing in a string. Ayye!");
		
		/*
		 * Let's create a collection of planets so that we may sort them.
		 */
		
		List<Planet> planets = new ArrayList<>();
		planets.add(p2);
		planets.add(p);
		
		Collections.sort(planets);
		System.out.println(planets);
	}

	@Override
	public String toString() {
		return "Planet [myString=" + myString + ", savingPrivateInt=" + savingPrivateInt + ", defaultInt=" + defaultInt
				+ ", protectMe=" + protectMe + "]";
	}

	/*
	 * We are establishing a natural order for our Planet objects.
	 */
	@Override
	public int compareTo(Planet o) {
		if(this.savingPrivateInt > o.savingPrivateInt) {
			return 1;
		}else if(this.savingPrivateInt < o.savingPrivateInt) {
			return -1;
		}
		return 0;
	}
}
