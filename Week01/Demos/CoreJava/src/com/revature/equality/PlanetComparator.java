package com.revature.equality;

import java.util.Comparator;

import com.revature.classes.Planet;

public class PlanetComparator implements Comparator<Planet>{

	/*
	 *Note that this compare method does compare two instances of the Planet
	 *class, but it does so externally (meaning this method is not a member
	 *of the Planet class.
	 */
	@Override
	public int compare(Planet o1, Planet o2) {
		if(o1.getSavingPrivateInt() > o2.getSavingPrivateInt()) {
			return 1;
		}else if(o1.getSavingPrivateInt() < o2.getSavingPrivateInt()) {
			return -1;
		}
		return 0;
	}

}
