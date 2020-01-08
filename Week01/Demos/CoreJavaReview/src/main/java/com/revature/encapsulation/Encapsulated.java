package com.revature.encapsulation;

public class Encapsulated {

	public String flowers;
	public String stan;
	private int positiveNumber = 1;
	public boolean booly;
	
	public void setPositiveNumber(int i) {
		if(i < 1) {
			System.out.println("No.");
		} else {
			this.positiveNumber = i;
		}
	}
	
	public int getPositiveNumber() {
		System.out.println(this.positiveNumber);
		return this.positiveNumber;
	}
	
	public static void main(String[] args) {
		
		AnotherClass ac = new AnotherClass();
		ac.method1();
	}
	
}

class AnotherClass{
	
	public void method1() {
		Encapsulated e = new Encapsulated();
		e.setPositiveNumber(2);
		e.getPositiveNumber();
	}
}
