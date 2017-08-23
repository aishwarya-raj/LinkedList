package com.aishwarya.queue;
import com.aishwarya.stacks.Stacks;

public class Queue<E> {
	
	Stacks<E> st = new Stacks<E>();
	
	Stacks<E> st1 = new Stacks<E>();
	
	void enQueue(E data) {
		if(st.isEmpty()) {
			st.push(data);
		} else {
			while(!st.isEmpty()) {
				st1.push(st.pop());
			}
			st.push(data);
			while(!st1.isEmpty()) {
				st.push(st1.pop());
			}
		}
		
	}
	
	E deQueue() {
			return st.pop();
	}
	
	void printQueue() {
		System.out.println("Queue is:- ");
		
		while(!st.isEmpty()) {
			System.out.print(st.top() + " ");
			st.pop();
		}
	}
	
	public static void main(String args[]) {
		Queue<Integer> q = new Queue<Integer>();
		
		q.enQueue(9);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		
		q.deQueue();
		q.deQueue();
		
		q.enQueue(5);
		
		q.deQueue();
		
		q.enQueue(6);
		q.enQueue(8);
		
		
		q.printQueue();
		System.out.print("\n");
		System.out.println("Queue is First In First Out.");
		System.out.println("And this is implementation of queue using two stacks.");
	}
	
}
