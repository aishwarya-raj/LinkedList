package com.aishwarya.stacks;

public class StackPermutation {

	Stacks<Integer> st = new Stacks<Integer>();

	void stackPermute(String s) {

		StringBuilder sb = new StringBuilder();
		char ch[] = s.toCharArray();
		int j = 0, i = 0;
		int a[] = { 1, 2, 3, 4, 5, 6 };
		//1st while
		while (i < ch.length) {
			//1st If
			if ((st.isEmpty() || st.top() < Integer.parseInt("" + ch[i]))  && j < a.length) {
				st.push(a[j]);
				j++;
				//2nd while
				while (st.top() != Integer.parseInt("" + ch[i]) && j < a.length) {
					st.push(a[j]);
					j++;
				}
				sb.append(st.pop());
			}
			//2nd if
			else if (!st.isEmpty()  && st.top() == Integer.parseInt("" + ch[i]) ) {
				sb.append(st.pop());
			} 
			//3rd if
			else if ( !st.isEmpty() && st.top() > Integer.parseInt("" + ch[i])) {
				//3rd while
				while (!st.isEmpty() && st.top() != Integer.parseInt("" + ch[i])) {
					st.pop();
				}
				sb.append(st.pop());
			}
			i++;
		}
		System.out.println(sb);
		//4th if
		if (s.equals(sb.toString())) {
			System.out.println("Stack Permuatble");
		} else {
			System.out.println("Stack not Permutable");
		}
	}

	public static void main(String args[]) {
		StackPermutation x = new StackPermutation();
		String s = "31245";
		x.stackPermute(s);
	}

}
