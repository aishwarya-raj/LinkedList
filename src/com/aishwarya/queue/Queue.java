package com.aishwarya.queue;

import com.aishwarya.linkedlist.LinkedList;
import com.aishwarya.stacks.Stacks;

public class Queue<E> extends LinkedList<E> {

	Stacks<E> st = new Stacks<E>();
	Stacks<E> st1 = new Stacks<E>();

	public static class Node<E> {
		E item;
		Node<E> next;

		Node(E data, Node<E> next) {
			this.item = data;
			this.next = next;
		}
	}

	Node<E> front = null;
	Node<E> rear = null;

/*	void enQueue(E data) {
		addLast(data);
	}

	E deQueue() {
		E dequeueElement = deleteFirst();
		if (dequeueElement == null) {
			System.out.println("Stack is Empty");
		}
		return dequeueElement;
	}
*/
	boolean isEmpty() {
		if (front == null && rear == null) {
			return true;
		} else {
			return false;
		}
	}

	void enQueueUsingStack(E data) {
		if (st.isEmpty()) {
			st.push(data);
		} else {
			while (!st.isEmpty()) {
				st1.push(st.pop());
			}
			st.push(data);
			while (!st1.isEmpty()) {
				st.push(st1.pop());
			}
		}

	}

	E deQueueUsingStack() {
		return st.pop();
	}

	void printQueueUsingStack() {
		System.out.println("Queue is:- ");

		while (!st.isEmpty()) {
			System.out.print(st.top() + " ");
			st.pop();
		}
	}

	public static void main(String args[]) {
		Queue<Integer> q = new Queue<Integer>();

		q.enQueueUsingStack(9);
		q.enQueueUsingStack(2);
		q.enQueueUsingStack(3);
		q.enQueueUsingStack(4);

		q.deQueueUsingStack();
		q.deQueueUsingStack();

		q.enQueueUsingStack(5);

		q.deQueueUsingStack();

		q.enQueueUsingStack(6);
		q.enQueueUsingStack(8);

		q.printQueueUsingStack();
		System.out.print("\n");
		System.out.println("Queue is First In First Out.");
		System.out.println("And this is implementation of queue using two stacks.");
	}

}
