package com.aishwarya.stacks;

public class InfixToPrefix {
	
	//Call the getPrecedence Method from InfixToPostfix class
	
	String infixToPrefix(String infix) {
		
		Stacks<String> opd = new Stacks<String>();
		Stacks<Character> opr = new Stacks<Character>();
		opr.push('#');
		
		StringBuilder sb = new StringBuilder("");
		
		char[] ch = infix.toCharArray();
		int i = 0;
		int len = ch.length;
		while(i < len) {
			if(ch[i] >= 48 && ch[i] <= 57) {
				opd.push(""+ch[i]);
			}
			else {
				if(InfixToPostfix.getPrecedence(opr.top()) < InfixToPostfix.getPrecedence(ch[i])) {
					opr.push(ch[i]);
				}else {
					while(!opr.isEmpty() && InfixToPostfix.getPrecedence(opr.top()) >= InfixToPostfix.getPrecedence(ch[i])) {
						
						sb.append(ch[i]);
						String op2 = opd.pop();
						sb.append(opd.pop());
						sb.append(op2);
						
						opd.push(sb.toString());
					}
					
				}
			}
		}
		
		return sb.toString();
	}
	
	
	public static String printPreFix(String str){
        Stacks<Character> stack = new Stacks<Character>();
        String prefix = "";
        for(int i=str.length()-1;i>=0;i--){
            char c = str.charAt(i);
            if(Character.isLetter(c)){
                prefix = ((Character)c).toString() + prefix;
            }
            else if(c == '('){
                prefix = ((Character)stack.pop()).toString() + prefix;
            }
            else if(c == ')'){
                continue;
            }
            else{
                stack.push(c);
            }
        }
        return prefix;
 
    }
	
	
	public static void main(String args[]) {
		String s = "(1+2*5/8-9)";
		String prefix = printPreFix(s);
		System.out.println("Prefix String is: " + prefix);
	}
	
}
