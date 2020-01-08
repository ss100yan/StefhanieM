package com.revature.polymorphism;

/*
 * When we want to use a class that is located in a different package,
 * we must import it so that it will be visible here in this package.
 * We cannot import packages, but rather specific classes.
 * 
 * We may also the wildcard symbol to indicate that we want to import
 * all classes from a package.
 * 
 * Note that Java will always use a more explicit import if there happen
 * to be two classes with the same name.
 * 
 * Also, you don't actually have to import anything as you can always
 * choose to use the fully qualified class name.
 * 
 * 
 */
import com.revature.classes.Primitives;
//import com.revature.classes.*;
//import com.revature.packagethatdoesntexist.Primitives;

public class Overloaded {

	private Primitives p;
//	com.revature.classes.Primitives p1; //Sadly, this is valid code.
	private int i;
	private String fab;
	public String touchThis;
	protected String touchThatToo;
	
	/*
	 * We've defined this method that takes a string as an argument.
	 */
	public void beFabulous(String s) {
		System.out.println(s + " is fabulous.");
	}
	
	/*
	 * What if we wanted multiple versions of the beFabulous method?
	 * In order to achieve this, we would have to overload the method.
	 * Overloading occurs when we have multiple versions of the same
	 * method within the same class. In order to overload a method,
	 * the method name should be the same and the list of parameters
	 * must change in some way.
	 * 
	 * Either the type of the parameter must change, or the number
	 * of parameters must change.
	 */
	
	public void beFabulous(int s) {
		System.out.println(s + " is a fabulous number.");
	}
	
	public void beFabulous(String s, int i) {
		System.out.println(s + " is a fabulous string that has been " +
	"accompanied by the fabulous number " + i);
	}
	
	public static void main(String[] args) {
		String aString = "dfsafsf";
		Overloaded ol = new Overloaded();
		ol.beFabulous(aString);
		ol.beFabulous(1);
		ol.beFabulous(aString, 8);
		
		/*
		 * The OverloadedChild class has inherited the public and
		 * protected fields/methods from the Overloaded class.
		 */
		OverloadedChild oc = new OverloadedChild();
		oc.beFabulous(4);
		
		MyInterface.staticMethod();
	}
}

/*
 * In Java, you may extend up to one class. When a class extends another
 * class, it inherits that class's methods and fields (all except for
 * the private ones).
 */
class OverloadedChild extends Overloaded{
	
	/*
	 * Recall that overloading occurs within the same class. Overriding,
	 * on the other hand, occurs when a different implementation of a 
	 * method that has been inherited from another class/interface 
	 * is provided.
	 */
	
	/*(
	 * Let's override the version of beFabulous we inherited that takes
	 * an int. Note that the method signature (when overriding) must
	 * be exactly the same.
	 */
	@Override 
	public void beFabulous(int s) {
		System.out.println("This is a fabulous " + s + ", and it belongs" +
	" to the child class. This version of this method, that is.");
	}
}
