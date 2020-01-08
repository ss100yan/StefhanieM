package com.revature.staticVars;

public class Static {

	private static int cakeSlices = 1;
	private int myCakeSlices;
	
	public Static(int myCakeSlices) {
		this.myCakeSlices = myCakeSlices;
	}
	
	public void addCakeSlice() {
		cakeSlices++;
		this.myCakeSlices--;
	}
	
	public int getMyCakeSlices() {
		return this.myCakeSlices;
	}
	
	public int getCommunityCake() {
		return cakeSlices;
	}
	
	public static void main(String[] args) {
		
		Static fred = new Static(1);
		System.out.println(fred.getMyCakeSlices());
		System.out.println(fred.getCommunityCake());
		fred.addCakeSlice();
		System.out.println(fred.getMyCakeSlices());
		System.out.println(fred.getCommunityCake());
		
		Static wilma = new Static(5);
		System.out.println(wilma.getMyCakeSlices());
		System.out.println(wilma.getCommunityCake());
		wilma.addCakeSlice();
		System.out.println(wilma.getMyCakeSlices());
		System.out.println(wilma.getCommunityCake());
		
		Static barney = new Static(2);
		System.out.println(barney.getCommunityCake());

	}
}
