package com.aishwarya.stacks;

public class TwoStackInArray {
	
	static int topA = -1;
	static int topB = 6;
	static int maxStack = 6;
	
	static int a[] = new int[6];
	
	static void pushA(int data) {
		
		if(topA == maxStack-1 || (topA + 1 == topB) || topB == 0) {
			System.out.println("Stack Overflow");
		}else {
			topA = topA + 1;
			a[topA] = data;
		}
	
	}
	 
	static int popA() {
		
		int popEleA = 0;
		if(topA == -1) { 
			System.out.println("Stack Undeflow");
		}else {
			popEleA = a[topA];
			a[topA] = 0;
			topA--;
		}
		return popEleA;
	}
	
	static void pushB(int data) {
		
		if ((topB - 1 == topA) || topA == maxStack-1 || topB == 0) {
			System.out.println("Stack Overflow");
		}else {
			topB = topB - 1;
			a[topB] = data;
		}
	}
	
	static int popB() {
		int popEleB = 0;
		if(topB == maxStack) {
			System.out.println("Stack Underflow");
		}else {
			popEleB = a[topB];
			a[topB] = 0;
			topB = topB + 1;
		}
		return popEleB;
	}
	
	static void printTwoStack(int a[]) {
		System.out.println("Two Stack Implemenetation is: ");
		for(int i = 0; i <= 5; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void main(String args[]) {
		
		pushA(1);
		pushA(2);
		popB();
		popA();
		
		printTwoStack(a);
	}
}
