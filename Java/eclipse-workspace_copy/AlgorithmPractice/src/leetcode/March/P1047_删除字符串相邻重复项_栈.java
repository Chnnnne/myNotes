package leetcode.March;

import java.util.Iterator;
import java.util.LinkedList;

public class P1047_删除字符串相邻重复项_栈 {
	public static void main(String[] args) {
//    	System.out.println(null=='c');
		System.out.println(new P1047_删除字符串相邻重复项_栈().removeDuplicates("zcaabbcw"));
//		String str="zcaabbcw";
//		String replace = str.replace("aa", "");
//		String replaceAll = str.replaceAll("[\\w]2", "");
//		System.out.println(replaceAll);
    	
	}//main
	
    public String removeDuplicates(String S) {
    	LinkedList<Character> stack = new LinkedList<Character>();
    	char[] charArray = S.toCharArray();
    	int m=S.length();
    	for(int i=0;i<m;i++) {
    		if(!stack.isEmpty()&&stack.peek()==charArray[i])
    			stack.pop();
    		else
    			stack.push(charArray[i]);
    	}
    	StringBuilder sb = new StringBuilder();
    	for (Character c : stack) {
    		sb.append(c);
    	}
    	return sb.reverse().toString();
    }
	
	
    public String removeDuplicates1(String S) {
    	String temp;
    	String ret=new String(S);
    	for(char c='a';c<='z';c++) {
    		temp=c+""+c;
    		ret=ret.replace(temp, "");
    	}
    	if(S.equals(ret)) return ret;
    	return removeDuplicates(ret);
    }
}
