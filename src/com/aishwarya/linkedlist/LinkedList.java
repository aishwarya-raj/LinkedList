package com.aishwarya.linkedlist;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;


public class LinkedList<E> {

	public static class Node<E> {
		public E item;
		public Node<E> next;

		Node(E data, Node<E> next) {
			this.item = data;
			this.next = next;
		}

		Node(Node<E> next) {
			this.next = next;
		}

		Node() {

		}
	}

	public Node<E> head = null;
	Node<E> start = null;
	int size = 0;
	int size1 = 0;
	int sizeC = 0;

	public void addFirst(E data) {
		Node<E> temp = new Node<E>(data, null);
		Node<E> q = head;
		if (q == null) {
			head = temp;
		} else {
			temp.next = head;
			head = temp;
		}
		size++;
	}
	
	public void addLast(E data) {
		Node<E> temp = new Node<E>(data,null);
		Node<E> q = head;
		if(q == null) {
			head = temp;
		}else {
			while(q.next != null) {
				q = q.next;
			}
			q.next = temp;
		}
	}

	void addLastCircular(E data) {
		Node<E> temp = new Node<E>(data, null);
		temp.next = temp;
		Node<E> q = head;
		if (q == null) {
			head = temp;
		} else {
			while (q.next != head) {
				q = q.next;
			}
			q.next = temp;
			temp.next = head;
		}
		sizeC++;
	}

	Node<Integer> createList() {
		Scanner scan = new Scanner(System.in);
		Node<Integer> q = null;
		Node<Integer> head = null;
		System.out.println("Enter the element of the linked list");
		for (int i = 0; i < 5; i++) {
			Node<Integer> temp = new Node<Integer>(null);
			temp.item = scan.nextInt();
			if (head == null) {
				head = temp;
			} else {
				q = head;
				while (q.next != null) {
					q = q.next;
				}
				q.next = temp;
			}
			size1++;
		}
		scan.close();
		System.out.print("Elements of the linked list are: ");
		for (Node<Integer> i = head; i != null; i = i.next) {
			System.out.print(i.item + " ");
		}
		System.out.println();
		System.out.println("Size of the linked list is: " + size1);
		return head;
	}

	/*
	 * void createCircularLinkedList(){ Node<E> q = new Node<E>(null);
	 * System.out.println("Creating a Circular Linked List of 5 nodes"); Node<E>
	 * head = addFirst(5); }
	 */

	void display() {
		System.out.print("Elements of the linked list are: ");
		for (Node<E> i = head; i != null; i = i.next) {
			System.out.print(i.item + " ");
		}
		System.out.println();
		System.out.println("Size of the linked list is: " + size);
	}

	void displayCircular() {
		System.out.println("Elements of the circular linked List are: ");
		for (Node<E> i = head; i.next != head; i = i.next) {
			System.out.print(i.item + " ");
		}
		System.out.println();
		System.out.println("Size of the Circular Linked List is: " + sizeC);
	}

	public E deleteFirst() {
		E deleteElement = null;
		if (head == null) {
			System.out.println("Empty List");
		} else {
			deleteElement = head.item;
			head = head.next;
			size--;
			System.gc();// free(temp);
		}
		return deleteElement;
	}

	void deleteLast() {
		if (head == null) {
			System.out.println("List Underflow");
		} else {
			Node<E> temp = new Node<E>(null);
			Node<E> q = new Node<E>(null);
			q = head;
			temp = head;
			while (temp.next != null) {
				q = temp;
				temp = temp.next;
			}
			q.next = null;
			size--;
			System.gc();
		}
	}

	void deleteIntermediate(int pos) {
		int k = 1;
		if (head == null) {
			System.out.println("List is Empty");
		} else {
			Node<E> temp = new Node<E>(null);
			Node<E> q = new Node<E>(null);
			q = head;
			while (q != null && k < pos - 1) {
				k++;
				q = q.next;
			}
			temp = q.next;
			q.next = temp.next;
			size--;
			// System.gc();
		}
	}

	void reverseList() {
		// reverse kar do list fir starting se nth node display kara do
		if (head == null) {
			System.out.println("List Underflow");
		} else {
			Node<E> current = head;
			Node<E> next = null;
			Node<E> prev = null;
			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			head = prev;
		}

	}

	void nthNodeFromEnd(int n) {
		if (head == null) {
			System.out.println("List Underflow");
		} else {
			Node<E> current = head;// Using Reversing of the Linked List
									// Technique.
			Node<E> next = null;
			Node<E> prev = null;
			while (current != null) {
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			head = prev;
		}
		Node<E> q = head;
		int k = 1;
		while (q != null && k < n) {
			q = q.next;
			k++;
		}

		System.out.println("Nth Node from the end is: " + q.item);
	}

	void nthNodeFromEndHashTable(int n) {
		Hashtable<Integer, Node<E>> ht = new Hashtable<Integer, Node<E>>();
		int i = 1;
		Node<E> q = head;
		while (q != null) {
			ht.put(i, q);
			i++;
			q = q.next;
		}
		Node<E> temp = head;
		int size = ht.size();
		int pos = size - n;
		int j = 1;
		while (j < pos) {
			temp = temp.next;
		}
		System.out.println("Nth node from the end using the has htable is : " + temp.item);
	}

	void nthNodeFromEndTwoPointers(int n) {
		Node<E> p = head;
		Node<E> pN = head;
		int i = 1;
		while (i <= n) {
			p = p.next;
			i++;
		}
		while (p != null) {
			p = p.next;
			pN = pN.next;
		}

		System.out.println("Nth Node from the End using two pointers are: " + pN.item);
	}

	void checkNullTerminatedListOrEndsWithCycle() {// This is Floyd Cycle
													// Finding Algorithm.
		Node<E> slow = head;
		Node<E> fast = head;
		while (fast != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (slow == fast) {
				System.out.println("Linked list ends with a cycle.");
				break;
			}
		}
		if (fast == null) {
			System.out.println("Linked List is Null Terminated");
		}
	}

	int lengthOfLoop() {
		int count = 1;
		Node<E> slow = head;
		Node<E> fast = head;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				System.out.println("Loop Exists.");
				slow = head;
				while (fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				Node<E> startNodeLoop = slow.next;
				while (startNodeLoop != slow) {
					startNodeLoop = startNodeLoop.next;
					count++;
				}
				break;
			}
		}
		return count;
	}

	void checkNullTerminatedListOrEndsWithCycleUsingHashTable() {// ye wala
																	// puchna
																	// hai i.e.
		// question number 7 and how we cannot solve this question using sorting
		// technique.

		Hashtable<Integer, Node<E>> ht = new Hashtable<Integer, Node<E>>();
		// Node<E> temp = head;
		Node<E> q = head;
		int i = 1;
		while (q != null) {
			ht.put(i, q);
			q = q.next;
			i++;
		}
		Set<Integer> j = ht.keySet();
		for (Integer k : j) {
			System.out.println("Value of " + k + " is: " + ht.get(k));
		}
	}

	void findStartNodeOfLoop() {

		Node<E> slow = head;
		Node<E> fast = head;

		while (fast != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (slow == fast) {
				System.out.println("Loop exists.");
				slow = head;
				while (slow != fast) {
					fast = fast.next;
					slow = slow.next;
				}
				System.out.println("Starting Node of the Loop is: " + slow.item);
				break;
			}
		}

		if (fast == null) {
			System.out.println("There is no Loop in the Linked List. Hence No Starting Node");
		}
	}

	void addNodeInSortedList(E data) {
		/*Node<E> temp = new Node<E>(data, null);
		Node<E> q = head;
		Node<E> current = null;

		
		 * while (q != null && q.item <= temp.item) { current = q; q = q.next; }
		 * temp.next = q; current.next = temp; size++;
		 */
	}

	/*
	 * void reverse(){ Node<E> current= head; Node<E> prev = null; Node<E> next
	 * = null;
	 * 
	 * while(current != null){ next = current.next; current.next = prev; prev =
	 * current; current = next; } head = prev; }
	 */

	// Check karwana hai
	void findMergingPoint() {
		Node<E> q = start;
		Node<E> p = head;
		Hashtable<Integer, Node<E>> ht = new Hashtable<Integer, Node<E>>();
		int i = 1;
		while (q != null) {
			ht.put(i, start);
			i++;
		}
		int k = 1;
		int htSize = ht.size();
		while (p != null && k <= htSize) {
			Node<E> j = ht.get(p);
			if (j == p) {
				System.out.println("Merging point is obtained: " + j.item);
			}
			k++;
			p = p.next;
		}

	}

	boolean checkLengthEvenOrOdd() {
		Node<E> q = head;
		int count = 0;
		if (q == null) {
			return false;
		} else {
			while (q != null) {
				count++;
				q = q.next;
			}
		}
		if (count % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	void mergeSortedList(){
		
	}
	
	void divideCircularLinkedList(){
		Node<E> slow = head;
		Node<E> fast = head;
		Node<E> q = null;
		Node<E> p = null;
		int count = 0;
		
		while(slow != null){
			count++;
			slow = slow.next;
		}
		if(count%2==0){
			while(fast!=null){
				q = slow;
				//p = fast;
				fast = fast.next.next;
				slow = slow.next;
				//p = fast;
			}
		}else{
			while(fast.next!=null){
				fast = fast.next.next;
				slow = slow.next;
				q = slow;
				p = fast;
			}
		}
		Node<E> start = q.next;
		//p.next = start;
		q.next = head;
	}

	public static void main(String a[]) {
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		linkedlist.addFirst(12);
		linkedlist.addFirst(11);
		linkedlist.addFirst(10);
		linkedlist.addFirst(9);
		linkedlist.addFirst(8);
		linkedlist.addFirst(6);
		linkedlist.addFirst(8);
		linkedlist.display();
		System.out.println(linkedlist.head.item);
			}

}