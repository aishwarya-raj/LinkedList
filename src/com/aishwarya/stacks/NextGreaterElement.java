package com.aishwarya.stacks;

public class NextGreaterElement {
	
	void nextGreaterElement(int a[]) {
		
		Stacks<Integer> st = new Stacks<Integer>();
		int n = a.length;
		
		for(int i = 0; i < n-1; i++) {
			int j = i + 1;
			while(j > i && j < a.length) {
				if(a[i] < a[j]) {
					st.push(a[j]);
					break;
				}else if(j == n-1) {
					st.push(-1);
					break;
				}
				j++;
			}
			
		}
		st.push(-1);
		ReverseStackUsingPushPop sb = new ReverseStackUsingPushPop();
		sb.reverseStack(st);
		st.printStack();
	}
	
	
	void nextGreater(int a[]) {
		
		Stacks<Integer> st = new Stacks<Integer>();
		int n = a.length;
		st.push(a[0]);
		int ele = 0, next = 0;
		for(int i = 1; i < n; i++) {
			next = a[i];
			if(!st.isEmpty()) {
				ele = st.pop();
				
				while(ele < next) {
					System.out.println("Next Greater element for the element: " + ele + " is " + next);
					if(st.isEmpty()) {
						break;
					}
					ele = st.pop();
				}
				if(ele > next) {
					st.push(ele);
				}
			}
			st.push(next);
		}
		
		while(!st.isEmpty()) {
			ele = st.pop();
			next = -1;
			System.out.println("Next Greater Element for the element: " + ele + " is " + next);
		}
		
	}
	
	public static void main(String args[]) {
		int a[] = {13,7,6,12};
		System.out.println("Next Greater Element of the Elements of the Array are: ");
		NextGreaterElement nge = new NextGreaterElement();
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		nge.nextGreater(a);
	}

}
