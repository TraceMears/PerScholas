package com.perscholas.Queue;

import java.util.LinkedList;

public class Queue extends LinkedList {

	
	public Queue() {
		System.out.println("Queue is created");
		System.out.println();
	}
	
	public void printQueue() {
		for (int i=0; i<this.size(); i++) {
			System.out.print(this.get(i)+ " ");			
		}
		System.out.println();
		System.out.println();
	}	
	
	
	public void enqueue(int x) {
		this.addFirst(x);
		System.out.println("Pushing " + x + " to queue");
		System.out.print("Queue: ");
		this.printQueue();
	}
	
	public void dequeue() {
		System.out.println("Popped " + this.peekLast() + " from queue: ");
		this.removeLast();
		System.out.print("Queue: ");
		this.printQueue();
	}	
}
