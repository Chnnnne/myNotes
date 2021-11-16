package package01;

import java.util.Scanner;

public class Work4 {
	public static void main(String []args)
	{	
		Scanner sc=new Scanner(System.in);
		System.out.println("请依次输入两个数");
		String str1=sc.next();
		String str2=sc.next();
//	以下完成对齐工作///////////////////
		if(str1.length()>str2.length())
		{
			int t=str1.length()-str2.length();
			while(t>0)
			{
				str2="0"+str2;
				t--;
			}
		}
		else 
		{
			int t=str2.length()-str1.length();
			while(t>0)
			{
				str1="0"+str1;
				t--;
			}
		}
////////////////////////////////////
		BigInteger b1=new BigInteger(BigInteger.StrtoBs(str1));
		BigInteger b2=new BigInteger(BigInteger.StrtoBs(str2));
		BigInteger sumBigInteger=b1.Add(b2);
		System.out.println("两数相加结果是");
		sumBigInteger.Prin_mbdata();
		
		BigInteger subtractBigInteger=b1.Subtract(b2);
		System.out.println("两数相减结果是");
		subtractBigInteger.Prin_mbdata();
		
		BigInteger mulBigInteger=b1.Multiply(b2);
		System.out.println("两数相乘的结果是");
		mulBigInteger.Prin_mbdata();
	}
}
