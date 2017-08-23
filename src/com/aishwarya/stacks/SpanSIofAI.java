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
	
	
	public static void main(String args[]) {
		int a[] = span();
		System.out.println("Span of Array is: ");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
}
