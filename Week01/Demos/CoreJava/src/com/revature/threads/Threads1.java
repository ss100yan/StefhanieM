package com.revature.threads;

/*
 * Recall that there are two ways to create a thread in Java. Here's the
 * first:
 */
public class Threads1 extends Thread{

	/*
	 * This is a static int, which means there's only one copy of it. Note
	 * that I've made this "x" volatile, which means that the value of x
	 * may only be read/accessed from main memory.
	 */
	public static volatile int x;
	
	/*
	 * The run method is where we place our thread's logic. This defines
	 * the tasks which our thread will carry out.
	 */
	@Override
	public void run() {
		super.run();
		System.out.println("Threads1 in the house!");
	}

	public static void main(String[] args) {
		
		/*
		 * Gets us a reference to our current thread, which is main in
		 * this case.
		 */
		System.out.println(Thread.currentThread().getName());
		
		//Create a new instance of our Threads1 class
		Threads1 t1 = new Threads1();
		//In order to use or runnable, we must pass it to the Thread constructor.
		Threads2 t2 = new Threads2();
		Thread thread = new Thread(t2);
		/*
		 * In order to make our thread "runnable", we have to start it using
		 * the "start" method.
		 */
		t1.start();
		thread.start();
		
//		try {
//			/*
//			 * If you want a thread to sleep for a duration, use Thread.sleep().
//			 */
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		while(x < 100) {
			incrementX();
			System.out.println("Main did this.");
		}
		
	}
	
	/*
	 * If I wanted to ensure that only thread at a time could access this
	 * method, I would have to make this block of code synchronized.
	 */
	public synchronized static void incrementX() {
		x++;
	}
}
