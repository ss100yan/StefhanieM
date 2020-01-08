package com.revature.polymorphism;

/*
 * Covariance allows us to take advantage of polymorphism in a different
 * way in Java. Covariance entails setting a reference to the super
 * to an instance of the child class.
 */
public class Covariance {
	
	public static void main(String[] args) {
		
		/*
		 * Here we've set a reference to the super (Ryan) to an instance
		 * of the child class (Bozo). Note that this reference type
		 * can be a class or even interface.
		 * 
		 * Note, however, that the methods and fields that can be
		 * accessed depend on the reference type. For instance, the
		 * variable c has a type of "Ryan", so it can only access
		 * fields and methods that exist on the Ryan class.
		 */
		Ryan c = new Bozo();
		
		SomeInterface i = new Bozo();
		
		Ryan r = new Ryan();
		
		/*
		 * We have the option of casting our objects. But beware.
		 * Sometimes you cannot cast from one object to another, and
		 * to make matters worse, the compiler won't always catch it.
		 * This will result in a ClassCastException.
		 */
		
//		c = (Overloaded) i; //This is bad, and the compiler immediately
							//catches it.
		
		/*
		 * This looks harmless, but it will throw a ClassCastException.
		 * That is because we are trying to downcast. The reference "r"
		 * points to a Ryan object, and that Ryan object never had
		 * access to anything on the Christina class as Ryan is
		 * Christina's super. 
		 * 
		 * Upcasting, on the other hand, occurs when we attempt to move
		 * from a child class to a parent class when casting.
		 */
//		Christina ch = (Christina) r;
	}
}

interface SomeInterface{
	
	void someMethod();
}

class Ryan implements SomeInterface{
	
	public void makeJoke() {
		
	}
	
	public void namePolkamans() {
		
	}
	
	public void beMean() {
		
	}

	@Override
	public void someMethod() {
		// TODO Auto-generated method stub
		
	}
}

class Christina extends Ryan{
	
	public void gossip() {
		
	}
	
	public void talkALot() {
		
	}
	
	public void beBubbles() {
		
	}
}

class Bozo extends Christina{
	
	public void bozoShow() {
		
	}
	
	public void beAmusing() {
		
	}
}

