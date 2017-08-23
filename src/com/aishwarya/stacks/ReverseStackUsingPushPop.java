package com.aishwarya.stacks;

public class ReverseStackUsingPushPop {
	
	void reverseStack(Stacks<Integer> s) {
		
		int data ;
		if(s.isEmpty()) {
			return;
		}
		data = s.pop();
		reverseStack(s);
		insertAtBottom(s,data);
		
	}
	
	void insertAtBottom(Stacks<Integer> s, int data) {
		
		int temp ;
		if(s.isEmpty()) {
			s.push(data);
			return;
		}
		temp = s.pop();
		insertAtBottom(s,data);
		s.push(temp);
		
	}
	
	public static void main(String args[]) {
		Stacks<Integer> s = new Stacks<Integer>();
		ReverseStackUsingPushPop reverse = new ReverseStackUsingPushPop(); 
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		
		s.printStack();
		System.out.print("\n");
		reverse.reverseStack(s);
		System.out.println("Reverse Element of the Stack are: ");
		s.printStack();
	}
	
}
