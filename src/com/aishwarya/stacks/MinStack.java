package com.aishwarya.stacks;

public class MinStack {
	
	Stacks<Integer> minStack = new Stacks<Integer>();
	Integer minEle;
	
	
	void getMinimum() {
		if(minStack.isEmpty()) {
			System.out.println("Empty Stack");
			return;
		}
		System.out.println("Minimum element is: " + minEle);
	}
	
	void peek() {
		if(minStack.isEmpty()) {
			System.out.println("Empty Stack");
			return;
		}
		Integer top = minStack.top();
		if(top < minEle) {
			minEle = top;
		}else {
			System.out.println("Peek Element is: " + top);
			return;
		}
	}
	
	void push(int a) {
		
		if(minStack.isEmpty()) {
			minStack.push(a);
			minEle = a;
			return;
		}
		
		else if(minStack.top() > a) {
			minEle = a;
		}
		
		minStack.push(a);
	}
	
	void pop() {
		if(minStack.isEmpty()) {
			System.out.println("Empty Stack");
			return;
		}
		
			Integer t = minStack.pop();
			
			if( t < minEle) {
				
			}
		
	}
	
	public static void main(String args[]) {
		
	}

}
