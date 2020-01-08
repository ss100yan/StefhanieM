package com.revature.strings;

/*
 * Recall that the String class in Java is immutable and that there is
 * a special place in memory (on the heap) called the String pool.
 * Let's play around with some Strings and then create some "mutable"
 * strings using the StringBuilder and StringBuffer classes.
 */
public class Strings {

	public static void main(String[] args) {
		
		String s1 = "yay!"; //GOOD
		String s2 = new String("yay!"); //BAD
		String s3 = "yay!"; //GOOD
		
		//The "==" operator is used to compare addresses (places in memory)
		//of two objects. When used with primitives, it actually compares
		//value.
		System.out.println(s1 == s3);
		System.out.println(s1 == s2);
		
		/*
		 * Recall that strings are immutable. If we want to use "mutable"
		 * strings, we can either use StringBuilder or StringBuffer.
		 * 
		 * StringBuffer was the original StringBuilder, but it is not
		 * considered good practice to use StringBuffer outside of
		 * multi-threaded environments as StringBuffer is thread-safe
		 * and therefore less efficient.
		 * 
		 * StringBuilder is more efficient and is NOT threadsafe and is
		 * ideal for use outside of multi-threaded environments.
		 */
		
		StringBuilder sBuilder = new StringBuilder(s1);
		System.out.println(sBuilder);
		sBuilder.append('c');
		System.out.println(sBuilder);
		
		StringBuffer sBuffer = new StringBuffer(sBuilder);
		StringBuffer sBuffer2 = new StringBuffer(s1);
		System.out.println(sBuffer);
		System.out.println(sBuffer2);
	
	}
	
}
