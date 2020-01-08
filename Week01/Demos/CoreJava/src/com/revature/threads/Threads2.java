package com.revature.threads;

/*
 * Our other option for creating a thread is implementing the Runnable
 * interface. In order to use an instance of this class to start a thread,
 * we must pass that instance into the Thread class's constructor.
 */
public class Threads2 implements Runnable{

	@Override
	public void run() {
		
//		System.out.println("Threads2 in the house!");
		while(Threads1.x < 100) {
			Threads1.incrementX();
			System.out.println("Threads2 did this.");
		}
	}

}
