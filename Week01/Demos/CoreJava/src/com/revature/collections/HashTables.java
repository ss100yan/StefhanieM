package com.revature.collections;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashTables {

	public static void main(String[] args) {
		
		Hashtable<Integer,String> hashy = new Hashtable<>();
		
		hashy.put(1, "string 1");
		hashy.put(2, "string 2");
		hashy.put(3, "string 3");
		hashy.put(4, "string 4");
		
		System.out.println(hashy);
		
		//Remove a String using its key
		hashy.remove(1);
		System.out.println(hashy);
		
		//Since Hashtable is an implementation of map (albeit a thread-safe one),
		//it's not iterable. So let's get the key set and interate over that to
		//find the key of our choice.
		
		Set<Integer> s = hashy.keySet();
		
		Iterator it = s.iterator();
		
		while(it.hasNext()) {
			Integer i = (Integer) it.next();
			
			if(i.equals(2)) {
				System.out.println(hashy.get(i));
			}
		}
	}
}
