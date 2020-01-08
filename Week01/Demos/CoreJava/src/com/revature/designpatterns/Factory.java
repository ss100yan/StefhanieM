package com.revature.designpatterns;

import com.revature.classes.Planet;

/*
 * The Factory design pattern (which is often used with the Singleton design
 * pattern) entails creating a "factory" which returns preconfigured objects
 * based on what was requested.
 */
public class Factory {

	public static Planet p;
	
	public Planet getPlanet(String name) {
		
		if(name.equals("Mercury")) {
			p = new Mercury();
		}else if
			(name.equals("Venus")) {
			p = new Venus();
		}else if(name.equals("Earth"))
			p = new Earth();//When making an if-else statement/block, you don't
							//need the {} if there is only a single statement
							//inside of the if/else block
		return p;
	}
	
	public static void main(String[] args) {
		Planet myPlanet = new Factory().getPlanet("Mercury");
		System.out.println(myPlanet.getClass());
	}
}

class Mercury extends Planet{
	
}

class Venus extends Planet{
	
}

class Earth extends Planet{
	
}
