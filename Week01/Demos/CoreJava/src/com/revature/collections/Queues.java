package com.revature.collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class Queues {

	public static void main(String[] args) {
		Queue<String> q = new PriorityQueue<>();
		
		//Adding to queues
		q.add("string 1");
		q.add("string 2");
		q.add("string 3");
		
		System.out.println(q);
		
		//This retrieves AND removes the first string in the queue
		String firstInLine = q.poll();
		System.out.println(firstInLine);
		System.out.println(q);
		
		//This peeks at the first string in the queue but doesn't remove it.
		String firstInLineNow = q.peek();
		System.out.println(firstInLineNow);
		System.out.println(q);
	}
}
