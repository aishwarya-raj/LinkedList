package com.aishwarya.stacks;

public class ThreeStacksInArray {
	
	static int topA = -1;
	static int topB = -2;
	static int topC = 6;
	static int maxSize = 6;
	int a[] = new int[6];
	
	void pushA(int data) {
		if(topA + 1 == topB || topA+1 == topC || topA == maxSize-1 || topC == 0) {
			System.out.println("Stack A is Full");
		}else{
			topA = topA + 1;
			a[topA] = data;
		}
	}
	
	int popA() {
		int popElement;
		if(topA == -1) {
			System.out.println("Stack Underfow");
			return -1;
		}else{
			popElement = a[topA];
			a[topA] = 0;
			topA--;
		}
		return popElement;
	}
	
	
	void printStackA() {
		if(topA == -1){
			System.out.println("Stack A is Empty");
		}else{
			System.out.println("Elements of the Stack A are:");
			for(int i = 0 ;i <= topA; i++) {
				System.out.print(a[i] + " ");
			}
		}
		System.out.print("\n");
	}
	
	
	void pushB(int data) {
		if(topA + 1 == topC || topA == maxSize-1 || topC == 0 || topB + 1 == topC ) {
			System.out.println("Stack B is Full");
		}else if(topB == -2 && topA  < 6/2-1 && topC > 6/2-1){
			topB = 6/2-1;
			a[topB] = data;
		}
		else{
			topB = topB + 1;
			a[topB] = data;
		}
	}
	
	int popB() {
		int popElementB;
		if(topB == -2) {
			System.out.println("Stack B Underflow");
			return -1;
		}else{
			popElementB = a[topB];
			a[topB] = 0;
			if(topB == 6/2-1) {
				topB = -2;
			}else{
				topB--;
			}
		}
		return popElementB;
	}
	
	void printStackB() {
		if(topB  == -2){
			System.out.println("Stack B is Empty");
		}else {
			System.out.println("Elements of the Stack B are: ");
			for(int i = 6/2-1; i <= topB; i++ ){
				System.out.print(a[i] + " ");
			}
		}
		System.out.println();
	}
	
	
	void pushC(int data) {
		if(topB + 1 == topC || topC == 0 || topA+1 == topC || topA == maxSize-1 || topB == maxSize-1) {
			System.out.println("Stack Overflow");
		}else {
			topC = topC - 1;
			a[topC] = data;
		}
		
	}
	
	int popC() {
		int popElementC;
		if(topA == maxSize-1 || topB == maxSize-1 || topC == maxSize) {
			System.out.println("Stack C is Empty");
			return -1;
		}else {
			popElementC = a[topC];
			a[topC] = 0;
			topC++;
		}
		return popElementC;
	}
	
	
	void printStackC() {
		if(topC == 6) {
			System.out.println("Stack C is Empty");
		}else {
			System.out.println("Elements of Stack C are: ");
			for(int i = topC; i < 6; i++) {
				System.out.print(a[i] + " ");
			}
		}
		System.out.print("\n");
	}
	
	void printThreeStacksInArray() {
		System.out.println("Elements of the Array are: ");
		for(int i = 0; i < 6; i++) {
			System.out.print(a[i]+ " ");
		}
		System.out.print("\n");
	}
	
	
	public static void main(String args[]) {
		ThreeStacksInArray t = new ThreeStacksInArray();
		t.pushA(1);
		t.pushA(2);
		t.printStackA();
		
		t.pushB(3);
		t.pushB(4);
		t.printStackB();
		
		t.printThreeStacksInArray();
		
		t.popA();
		t.popA();
		t.popA();
		t.popB();
		
		t.printStackA();
		t.printStackB();
		
		t.pushC(6);
		t.pushC(5);
		
		t.printStackC();
		
		t.popC();
		t.printStackC();
		t.printThreeStacksInArray();
		
	}
	
}
