package com.revature.classes;

/*
 * A POJO is a "Plain Old Java Object." It is a design pattern and is
 * just a conventional way of creating a class. A POJO typically has
 * fields, a constructor with a fields, a no-args constructor, and
 * getters and setters.
 */
public class Pojo {

	private int pojoNum;
	private String pojoString;
	private Planet pojoPlanet;
	
	public Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pojo(int pojoNum, String pojoString, Planet pojoPlanet) {
		super();
		this.pojoNum = pojoNum;
		this.pojoString = pojoString;
		this.pojoPlanet = pojoPlanet;
	}

	public int getPojoNum() {
		return pojoNum;
	}

	public void setPojoNum(int pojoNum) {
		this.pojoNum = pojoNum;
	}

	public String getPojoString() {
		return pojoString;
	}

	public void setPojoString(String pojoString) {
		this.pojoString = pojoString;
	}

	public Planet getPojoPlanet() {
		return pojoPlanet;
	}

	public void setPojoPlanet(Planet pojoPlanet) {
		this.pojoPlanet = pojoPlanet;
	}
}
