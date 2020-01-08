package com.revature.classes;

/*
 * There are 8 primitives in Java. It is important to note that primitives
 * are NOT objects, which means they don't inherit methods from the Object
 * class.
 */
public class Primitives {

	private int i; //a numeric (integer) value; size 32 bits
	private double d; //a floating-point value; size 64 bits
	private float f; //a floating-point value; size 32 bits
	private long l; //a numeric (integer) value; size 64 bits
	private boolean b; //represents "true" or "false"
	private char c; //represents a character; uses single quotes; size 16 bits
	private short s; //a numeric value (integer); size 16 bits
	private byte by; //represents a numeric values; size 8 bits
	
	/*
	 * If you ever want to use an object representation of a primitive,
	 * Java provides "wrapper classes." These are object representations
	 * of our primitives.
	 * 
	 * When using wrapper classes, primitives are "boxed" as objects.
	 * 
	 * Java may also "autobox" or "autounbox" primitives for us. This
	 * occurs when automatically wraps a primitive as an object for us.
	 * For instance, when you add an int to a Java collection, it is
	 * automatically boxed as an Integer for you.
	 */
	Integer i2 = new Integer(3);
	Double d2;
	Float f2 = new Float(45.8); //Java is being nice here, right?
	Long l2;
	Boolean b2;
	Character c2;
	Short s2;
	Byte by2;
	
	public static void main(String[] args) {
		
		//In Java, certain prmitive data types are "promoted" when 
		//you attempt to perform operations with them.
		
		short s1 = 6;
		short s2 = 7;
		
		/*
		 * This is not allowed as the short variables are promoted to
		 * ints when we attempt to add them. We must store this result
		 * as an int.
		 */
//		short s3 = s1 + s2;
		
		int i1 = s1 + s2;
		
		/*
		 * Of course, we can also cast from one data type to another.
		 * Be mindful, however, of casting as you can lose data when
		 * casting from a larger data to a smaller data type.
		 * 
		 * NOTE: Just make sure that you're casting compatible types.
		 */
		
		long l1 = 45565;
		
		int i2 = (int) l1; //casting a long to an int
		
		/*
		 * NOTE: When initializing doubles and floats, be mindful of
		 * the fact that Java interprets floating-point literals as
		 * doubles.
		 */
		Primitives p = new Primitives();
		p.d = 67.8;
		p.f = 54.4f; //In order to store this in a float variable,
					 //we must specify that it is a float by appending
					 //an "f"
		
		/*
		 * Again, note that their are max values for what can be
		 * stored in each data type.
		 */
		
		byte by1 = 127; //For instance, byte can store values from
						//-128 to 127
	}
}
