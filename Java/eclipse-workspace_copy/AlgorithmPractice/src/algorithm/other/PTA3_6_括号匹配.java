package algorithm.other;

import java.util.Scanner;
import java.util.Stack;

public class PTA3_6_括号匹配 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		sc.nextLine();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < T; i++) {
			stack.clear();
			String str=sc.nextLine();
			char[] charArray = str.toCharArray();
			int j;
			for (j = 0; j < charArray.length; j++) {
				if(charArray[j]=='('||charArray[j]=='['||charArray[j]=='{') {//左括号直接入栈
					stack.push(charArray[j]);
				}else if (getAnotherPair(charArray[j])==stack.peek()) {//右括号则进行判断
					stack.pop();
				}
				else {
					break;
				}
			}
			if(j==charArray.length) System.out.println("YES");
			else	System.out.println("NO");
			
		}
	}//main
	
	public static char getAnotherPair(char c) {
		if(c==')') return '(';
		if(c=='}') return '{';
		if(c==']') return '[';
		return '0';
	}
	
}
