package leetcode.March;

import java.util.LinkedList;

public class P0150_逆波兰表达式 {
	
	public static void main(String[] args) {
		
		
	}//main
	
	
    public int evalRPN(String[] tokens) {
    	LinkedList<Integer> stack = new LinkedList<Integer>();
    	int len = tokens.length;
    	for(int i=0 ; i<len;i++) {
    		if(isOperator(tokens[i])) {
    			int y=stack.pop();
    			int x=stack.pop();
    			stack.push(calculate(x,y,tokens[i]));
    		}
    		else
    			stack.push(Integer.parseInt(tokens[i]));
    	}
    	
    	
    	return stack.peek();
    }


	private Integer calculate(int x, int y, String str) {
		if(str.equals("+"))
			return x+y;
		if(str.equals("-"))
			return x-y;
		if(str.equals("*"))
			return x*y;
		if(str.equals("/"))
			return x/y;
		return null;
	}


	private boolean isOperator(String str) {
		if(str.equals("/")||str.equals("*")
				||str.equals("+")||str.equals("-"))
			return true;
		return false;
	}
}
