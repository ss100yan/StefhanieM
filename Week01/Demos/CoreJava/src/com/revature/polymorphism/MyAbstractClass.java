package com.revature.polymorphism;

import java.io.Serializable;

/*
 * There are several non-access modifiers in Java, and the "abstract"
 * keyword is one of them. When used with a class, this keyword denotes
 * that the class may contain abstract methods. Abstract methods are
 * methods that do not have implementations. The point of an abstract
 * method is to be overridden. In fact, you CANNOT instantiate an
 * abstract class.
 * 
 * NOTE: Abstract classes don't have to contain abstract methods.
 */
public abstract class MyAbstractClass {

	public void printStuff() {
		System.out.println("I'm printing stuff.");
	}
	
	/*
	 * Abstract methods are NOT allowed to have implementations, so
	 * do NOT put brackets here. We simply declare the method. The
	 * method will be overridden later.
	 * 
	 * Note that an abstract method cannot use the "final" keyword
	 * as this keyword prevents a method from being overridden.
	 */
	public abstract void printStuffAgain();
}

/*
 * Abstract classes can extend abstract classes, but they are not
 * forced to implement any unimplemented methods.
 */
abstract class AbstractAgain extends MyAbstractClass{
	
	public abstract void lookAtMe();
	
	public abstract void lookAtMeAgain();
}

/*
 * This is the first concrete class that has inherited these unimplemented
 * methods, which means that it MUST override those methods.
 * 
 * Note: When used with a class, the "final" keyword denotes that a 
 * class cannot be extended.
 */
final class ConcreteClass extends AbstractAgain implements ChildInterface{

	@Override
	public void lookAtMe() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lookAtMeAgain() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printStuffAgain() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abstractMethod() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abstractAgain() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void yay() {
		// TODO Auto-generated method stub
		
	}
	
}

/* NO!
class ConcreteClass2 extends ConcreteClass{
	
}
*/
