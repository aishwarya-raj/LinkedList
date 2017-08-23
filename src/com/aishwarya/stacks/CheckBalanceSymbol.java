package com.aishwarya.stacks;

public class CheckBalanceSymbol {
	
	boolean isMatchingSymbol(char ch1, char ch2) {

		if (ch1 == '(' && ch2 == ')') {
			return true;
		} else if (ch1 == '[' && ch2 == ']') {
			return true;
		} else if (ch1 == '{' && ch2 == '}') {
			return true;
		} else {
			return false;
		}
	}

	boolean checkBalanceSymbols(String s) {
		Stacks<Character> st = new Stacks<Character>();
		char[] ch = s.toCharArray();
		
		for (int i = 0; i < ch.length; i++) {

			if (ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {
				st.push(ch[i]);
			}

			else if (ch[i] == ')' || ch[i] == ']' || ch[i] == '}') {

				if (st.isEmpty()) {
					return false;
				} else if (isMatchingSymbol(st.top.item, ch[i])) {
					st.pop();
				}
			}
		}

		return st.isEmpty();
	}

	public static void main(String args[]) {
		CheckBalanceSymbol cbs = new CheckBalanceSymbol();
		String s = "(({[(())]})))";
		boolean value = cbs.checkBalanceSymbols(s);
		System.out.println("Are Symbols Balanced: " + value);
	}
	
	
}
