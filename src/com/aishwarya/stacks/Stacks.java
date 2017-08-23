//A stack is an ordered list where insertion and deletion are done at one end called top of the stack
//Pop-Delete element
//Push-Insert element
//Overflow-Push element in full stack
//Underflow-Pop element from empty stack

package com.aishwarya.stacks;


public class Stacks<E> {

	public static class Node<E> {
		E item;
		Node<E> next;

		Node(E data, Node<E> next) {
			this.item = data;
			this.next = next;
		}

	}

	public Node<E> top = null;

	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}

	public void push(E data) {
		Node<E> temp = new Node<E>(data, null);
		if (isEmpty()) {
			top = temp;
		} else {
			temp.next = top;
			top = temp;
		}
	}
	
	

	public E pop() {
		
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return null;
		} else {
			E popElement = top.item;
			top = top.next;
			return popElement;
		}
		
	}

	public void printStack() {
		Node<E> i = top;
		System.out.print("Elements of the Stack are: ");
		while (i != null) {
			System.out.print(i.item + " ");
			i = i.next;
		}
	}

	public E top() {
			return top.item;
	}

	void createStack(E a[]) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			push(a[i]);
		}
	}

		
	

	public static void main(String args[]) {
		Stacks<Integer> stack = new Stacks<Integer>();
		Integer[] a = { 11, 12, 13, 14, 15, 16, 17 };
		stack.createStack(a);
		stack.printStack();
		System.out.print("\n");
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println("Is Stack Empty: " + stack.isEmpty() );
		stack.printStack();
		System.out.println();
	}
}
