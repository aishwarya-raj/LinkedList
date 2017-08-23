package com.aishwarya.linkedlist;

public class ReverseString {
	
	public static void main(String args[]) {
		String s = "My name is Aishwarya Raj";
		char ch[] = s.toCharArray();
		for(int i = ch.length-1; i >= 0; i--) {
			System.out.print(ch[i]);
		}
		System.out.print("\n");
		StringBuilder sb = new StringBuilder(s.length());
		int i =0;
			while(i < ch.length) {
				sb.append(s.charAt(i));
				i++;
			}
		
		sb = sb.reverse();
		System.out.println("Letter by Letter Reverse:- " + sb);
		
		String[] split = s.split(" ");
		String result = "";
		for(int j = split.length-1; j >= 0; j--) {
			result = result + split[j] + " ";
		}
		System.out.println("Senetence Reverse is:- "+ result);
	}
	
}
