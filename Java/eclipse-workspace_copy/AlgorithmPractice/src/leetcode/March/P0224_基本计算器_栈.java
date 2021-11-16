package leetcode.March;

import java.util.LinkedList;

public class P0224_基本计算器_栈 {
	public static void main(String[] args) {
		System.out.println(new P0224_基本计算器_栈().calculate(" 2-1 + 2 "));
//		String next = new  P0224_基本计算器_栈().getnext("1+2 - 11+25#");
//		System.out.println(next);
//		while(!next.equals("#")) {
//			next = new  P0224_基本计算器_栈().getnext("1+2 - 11+25#");
//			System.out.println(next);
//			
//		}
	}//main
	
	static int i=0;
    int calculate(String s) {
    	i=0;
    	if(s.charAt(0)=='+'||s.charAt(0)=='-')
    		s="0"+s;
    	LinkedList<Integer> OPND = new LinkedList<Integer>();//操作数栈
    	LinkedList<Character> OPTR = new LinkedList<Character>();//运算符栈
    	OPTR.push('#');
    	s=s+"#";
    	String c=getnext(s);//获得下一个有效符号  要么数字要么操作符
    	while(!(c.equals("#")&&OPTR.peek().equals('#'))) {//当读入和栈顶都是'#'时结束
    		if(!isOP(c))//不是操作符的话就直接入栈数字
    		{
    			OPND.push(Integer.parseInt(c));
    			c=getnext(s);
    		}
    		else {//操作符
				switch (Precede(OPTR.peek(),c)) {
				case '<'://栈顶元素优先级低	
					OPTR.push(c.charAt(0)); c=getnext(s);
					break;
				case '='://脱括号
					OPTR.pop(); c=getnext(s);
					break;
				case '>':
					Character theta = OPTR.pop();
					Integer b = OPND.pop();
					Integer a = OPND.pop();
					OPND.push(Operate(a,theta,b));
					break;
				default:
					System.out.println("wrong");
					break;
				}
			}
    			
    	}
    	
    	
    	
    	return OPND.peek();
    }


	private Integer Operate(Integer a, Character theta, Integer b) {
		if(theta.equals('+'))
			return a+b;
		if(theta.equals('-'))
			return a-b;
		return -99999;
	}

	//prec[i][j] 依次是 + - ( ) #
	char [][]prec=new char[][] {
		{'>','>','<','>','>'},
		{'>','>','<','>','>'},
		{'<','<','<','=',' '},
		{'>','>',' ','>','>'},
		{'<','<','<','<','='}
	};
	private char Precede(Character peek, String c) {
		int i=getIndex(peek);
		int j=getIndex(c.charAt(0));
		return prec[i][j];
	}

	private int getIndex(char charAt) {
		if(charAt=='+') return 0;
		if(charAt=='-') return 1;
		if(charAt=='(') return 2;
		if(charAt==')') return 3;
		if(charAt=='#') return 4;
		return -1;
	}


	//获取喜爱个有效字符串
	private String getnext(String s) {
		while(s.charAt(i)==' ') {//空格
			i++;
		}
		//结束符
//		if(s.charAt(i)=='#')
//			return '#'+"";
		
		if(isOP(s.charAt(i)+""))	//操作符 注意包括#
			return s.charAt(i++)+"";
		
		//是数字
		StringBuilder sb = new StringBuilder();
		while(isNum(s.charAt(i))) {
			sb.append(s.charAt(i));
			i++;
		}
		return sb.toString();
	}

	private boolean isNum(char charAt) {
		if('0'<=charAt&&charAt<='9')
			return true;
		return false;
	}


	private boolean isOP(String c) {
		if(c.equals("+")||c.equals("-")||c.equals("(")||c.equals(")")||c.equals("#"))
			return true;
		return false;
	}
}
