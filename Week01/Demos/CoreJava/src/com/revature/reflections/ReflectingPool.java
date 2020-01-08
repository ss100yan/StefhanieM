package com.revature.reflections;

import java.lang.reflect.Field;

/*
 * The Reflections API allows Java to perform introspection at runtime. Java
 * can look at its classes' meta data and even change/directly access private
 * fields. Note, however, that using Reflections is expensive and is not
 * recommended unless you really know what you're doing.
 * 
 * NOTE: Many frameworks use reflections.
 */
public class ReflectingPool {

	private Object o;
	private String s;
	
	public static void main(String[] args) {
		
		/*
		 * The Reflections API gives us access to objects which represent
		 * the fields and methods on a class.
		 */
		try {
			ReflectingPool rp = ReflectingPool.class.newInstance();
			Field[] fields = rp.getClass().getDeclaredFields();
			
			for(Field f : fields) {
				//This allows us to directly access even a private field.
				f.setAccessible(true);
				f.set(rp, "ayyyyeeee!");
			}
			
			System.out.println(rp);
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "ReflectingPool [o=" + o + ", s=" + s + "]";
	}
	
}
