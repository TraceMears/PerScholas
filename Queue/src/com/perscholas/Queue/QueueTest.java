package com.perscholas.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue queue = new Queue();
		
		queue.enqueue(24);
		queue.enqueue(45);
		queue.enqueue(87);
		queue.dequeue();
		queue.enqueue(52);
		queue.enqueue(92);
		queue.enqueue(32);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(42);
		queue.enqueue(37);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
		
		
	}

}
