package com.aishwarya.stacks;

import com.aishwarya.linkedlist.LinkedList.Node;

public class StackImplement {
	
	
	static int evaluatePostfix(String s) {
		Stacks<Integer> stack = new Stacks<Integer>();
		char ch[] = s.toCharArray();
		for(int i = 0 ; i < ch.length; i++) {
			if(ch[i] >= 48 && ch[i] <= 57){
				stack.push(ch[i]-48);
			}else{
				int num1 = stack.pop();
				int num2 = stack.pop();
				switch(ch[i]){
				case '+': stack.push(num2+num1);break;
				case '-': stack.push(num2-num1);break;
				case '*': stack.push(num2*num1);break;
				case '/': stack.push(num2/num1);break;
				}
			}
		}
		return stack.top.item;
	}
	
	
	static void evaluateInfix(String s) {
		
		String postfix = InfixToPostfix.infixToPostfix(s);
		int result = evaluatePostfix(postfix);
		System.out.println(result);
		
	}
	
	int getMinimum(Integer a[]) {
		int n = a.length;
		Stacks<Integer> mainSt = new Stacks<Integer>();
		Stacks<Integer> minSt = new Stacks<Integer>();
		for(int i = 0; i < n ; i++) {
			if(minSt.isEmpty() && mainSt.isEmpty()) {
				minSt.push(a[i]);
				mainSt.push(a[i]);
				
			}
			else if(minSt.top.item >= (Integer)a[i]){
				minSt.push(a[i]);
				mainSt.push(a[i]);
				
			} else {
				mainSt.push(a[i]);
			}
		}
		return minSt.top.item;
		//System.out.println(minSt.top.item);
	}
	
	void checkPallindromeString(String s) {
		
		Stacks<Character> s1 = new Stacks<Character>();
		char ch[] = s.toCharArray();
		int i = 0;
		while(i < ch.length && ch[i] != 'X') {
			s1.push(ch[i]);
			i++;
		}
		
		while(!s1.isEmpty() && i < ch.length) {
			if(ch[i] == s1.top()) {
				s1.pop();
			}
			i++;
		}
		
		if(s1.isEmpty()) {
			System.out.println("String is Pallindrome");
		}else {
			System.out.println("String is not Pallindrome");
		}
	} 
	
	 void checkPallindromeLinkedList(Node<Character> head) {
		
		Stacks<Character> s1 = new Stacks<Character>();
		
		Node<Character> temp = head;
		
		while(temp.item != 'X' && temp.next != null) {
			s1.push(temp.item);
			temp = temp.next;
		}
		
		while (temp != null && !s1.isEmpty()) {
			if(temp.item == s1.top()) {
				s1.pop();
			}
			temp = temp.next;
		}
		
		if(s1.isEmpty()) {
			System.out.println("String is Pallindrome");
		}else {
			System.out.println("String is not Pallindrome");

		}
	}
	
	 //this solution is same as implementing queue using stacks
	 void reverseStackElements(Stacks<Integer> s) {
		 Stacks<Integer> st = new Stacks<Integer>();
		 if(s.isEmpty()) {
			 System.out.println("Empty Stack");
			 return;
		 }
		 while(!s.isEmpty()) {
			 st.push(s.pop());
		 }
		 System.out.print("\n");
		 System.out.print("Elements in the reverse order of the stack: ");
		 while(!st.isEmpty()) {
			  System.out.print(st.pop() + " ");
		 }
		 
	 }
	 
	 
	 
	
	public static void main (String args[]) {
		//StackImplement st = new StackImplement();
		String s = "1+2*3";
		System.out.print("Infix Evaluation Result is: " );
		evaluateInfix(s);
		
		/*LinkedList<Character> linkedlist = new LinkedList<Character>();
		linkedlist.addFirst('a');
		linkedlist.addFirst('b');
		linkedlist.addFirst('c');
		linkedlist.addFirst('X');
		linkedlist.addFirst('c');
		linkedlist.addFirst('b');
		linkedlist.addFirst('a');
		st.checkPallindromeLinkedList(linkedlist.head);
		
		 Stacks<Integer> stack = new Stacks<Integer>();
		 stack.push(1);
		 stack.push(2);
		 stack.push(3);
		 stack.push(4);
		 stack.push(5);
		 stack.printStack();
		 
		 st.reverseStackElements(stack);*/
		//System.out.println(linkedlist.head.item);
		//String pallindrome = "ababababababababababXbabababababababababa";
		//st.checkPallindromeString(pallindrome);
		//Integer[] a = {2,3,4,5,6,7,8,9,2,3,4,90,0,-30,-90};
		//System.out.println(st.getMinimum(a));
		//String infix = "(1+2*3)";
		//String postfix = "123*+";
		//int res = st.evaluatePostfix(infix);
		//int result = evaluatePostfix(postfix);
		//System.out.println("Result of the evaluation of the Postfix String " + postfix + " is " + result);
	}
}
