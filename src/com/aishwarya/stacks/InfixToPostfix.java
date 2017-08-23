package com.aishwarya.stacks;

public class InfixToPostfix {
	
	
	public static int getPrecedence(char c1) {
		int ret = 0;
		if(c1 == '+' || c1 == '-'){
			ret = 1;
		}else if(c1 == '*' || c1 == '/') {
			ret = 2;
		}else if(c1 == '^') {
			ret = 3;
		}
		return ret;
	}
	

	public static String infixToPostfix(String infix) {

		Stacks<Character> st = new Stacks<Character>();

		char[] ch = infix.toCharArray();
		int len = ch.length;
		int i = 0;

		StringBuilder sb = new StringBuilder("");

		while (i < len) {
			if (ch[i] >= 48 && ch[i] <= 57) {
				sb.append(ch[i]);
			} else {
				if (!st.isEmpty() && getPrecedence(st.top()) < getPrecedence(ch[i])) {
					st.push(ch[i]);
				} else{
					while (!st.isEmpty() && getPrecedence(st.top()) >= getPrecedence(ch[i])) {
						sb.append(st.pop());
					}
					st.push(ch[i]);
				}
			}

			if (ch[i] == '(') {
				st.push(ch[i]);
			} else if (ch[i] == ')') {
				while (!st.isEmpty() && st.top() != '(') {
					sb.append(st.pop());
				}
			}
			i++;
		}

		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		
		String infix = "1*2+3";
		System.out.println("Infix String is: " + infix);
		String postfix = infixToPostfix(infix);
		System.out.println("Postfix String is: " + postfix);
	}

}
