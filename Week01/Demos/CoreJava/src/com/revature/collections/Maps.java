package com.revature.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Maps {

	public static void main(String[] args) {
		
		//Maps have keys and values. In this case, the key is an integer,
		//and the value is a string.
		Map<Integer,String> mappy = new HashMap<>();
		
		System.out.println(mappy);
		
		//To add a key and value to the map, we use the "put" method. Note
		//that we may add up to one null key to our map.
		mappy.put(1, "value 1");
		mappy.put(2, "value 2");
		mappy.put(5, "value 5");
		mappy.put(3, "value 3");
		//If you add the same key again with a different value, it just updates
		//the value associated with that key.
		mappy.put(1, "value 1 again");
		
		System.out.println(mappy);
		
		//We can remove an object from our map by its key.
		mappy.remove(5);
		System.out.println(mappy);
		
		//Remember: Maps are not iterable. But sets are! That said, we can
		//just get the map's keys as a set and iterate through that set. Once
		//we find the key we're looking for, we can use that to access the
		//value in our map we want.
		Set<Integer> s = mappy.keySet();
		
		Iterator it = s.iterator();
		
		while(it.hasNext()) {
			Integer key = (Integer) it.next();
			if(key.equals(1)) {
				System.out.println(mappy.get(key));
			}
		}
		
	}
}
