package com.aishwarya.stacks;

import java.util.Scanner;

public class SpanSIofAI {
	
	//Complexity is O(n^2)
	
	static int[] span() {
		int s[] = new int[5];
		Scanner scan = new Scanner(System.in);
		int a[] = new int[5];
		for(int i = 0; i < 5; i++) {
			a[i] = scan.nextInt();
		}
		for(int i = 0; i < 5; i++) {
			int j = 1;
			while(j <= i && a[i] > a[i-j]) {
				j++;
			}
			s[i] = j;
		}
		scan.close();
		return s;
	}
	
	//Not Working
	static int[] spanUsingStack() {
		
		Stacks<Integer> st = new Stacks<Integer>();
		int a[] = {6,3,4,5,2};
		int n = a.length;
		int s[] = new int[5];
		int p;
		for(int i = 0; i < n; i++) {
			while(!st.isEmpty()) {
				if(a[i] > a[st.top()]) {
					st.pop();
				}
			}
			if(st.isEmpty()) {
				p = -1;
			}else {
				p = st.top();
			}
			s[i] = i - p;
			st.push(i);
		}
		
		return s;
	}
	
	
	public static void main(String args[]) {
		int b[] = spanUsingStack();
		System.out.println("Span of Array is: ");
		for(int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
	}
	
}
