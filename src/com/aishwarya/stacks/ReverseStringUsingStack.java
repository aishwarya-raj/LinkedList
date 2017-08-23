package com.aishwarya.stacks;

public class ReverseStringUsingStack {
	
	static String reverseString(String s) {
		Stacks<Character> st = new Stacks<Character>();
		StringBuilder sb = new StringBuilder("");
		char c[] = s.toCharArray();
		int i = 0;
		while(i < c.length) {
			st.push(c[i]);
			i++;
		}
		
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		
		return sb.toString();
	}
	
	public static void main(String args[]) {
		String s = "Ashi Verma";
		String reverse = reverseString(s);
		System.out.println(reverse);
	}
	
}
