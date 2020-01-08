package com.revature.polymorphism;

/*
 * This is an interface. It is assumed to be public and abstract by
 * default. You CANNOT instantiate an interface.
 */
public interface MyInterface {
	
	/*
	 * Interfaces can have fields, but those fields must be public,
	 * static, and final.
	 */
	public static final int i = 8;

	/*
	 * Note that methods cannot be private as that doesn't make much
	 * sense.
	 */
	
	public abstract void abstractMethod();
	void abstractAgain(); //the implication is that this method is public
						  //and abstract
	
	/*
	 * We are allowed to have concrete methods on interfaces, but ONLY
	 * if we use either the "default" keyword or the "static" keyword.
	 * If you use either of these keywords, you method must have a body
	 * (i.e. an implementation).
	 * 
	 * The "default" keyword is a non-access modifier that is used to
	 * give a method a body/implementation on an interface.
	 * 
	 * The "static" keyword makes a method/variable a member of the
	 * "class" or "interface" that exists even if an instance of the
	 * class does not instance.
	 */
	public default void defaultImpl() {}
	
	/*
	 * Technically, we can use this method by just referencing the
	 * interface by name since doing so doesn't require that we
	 * instantiate the interface (which is not possible in Java
	 * anyway).
	 */
	public static void staticMethod() {}
}

/*
 * Interfaces can extend interfaces, and they inherit all methods from
 * their parent interfaces.
 */
interface ChildInterface extends MyInterface{
	
	void yay();
}

