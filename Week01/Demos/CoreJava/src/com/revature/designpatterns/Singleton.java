package com.revature.designpatterns;

import com.revature.classes.Planet;

/*
 * The Singleton design pattern is a creational design pattern by which
 * we create a single instance of a class so that there will only be one
 * instance of that class in use at any given time.
 * 
 * In laymen's terms: Let's use the exact same object again and again and
 * again.
 */
public class Singleton {

	//The static keyword makes this a "class variable," which means we
	//don't need an instance of the Singleton class to use as only one
	//copy is shared amongst all instances of the Singleton class.
	public static Planet p;
	
	//Each time a planet is requested, I will return the exact same planet.
	//I will only construct a new planet object if p is null, which will
	//only be true the first time this method is called.
	public Planet getPlanet() {
		
		if(p == null) {
			p = new Planet();
		}
		return p;
	}
}
