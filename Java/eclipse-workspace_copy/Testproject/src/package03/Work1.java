package package03;

import java.io.IOException;
import java.util.Scanner;

public class Work1 {
	public static void main(String []agrs) throws IOException
	{
		System.out.print("请输入第一个整数：");
		int a=new Scanner(System.in).nextInt();
		System.out.print("请输入第二个整数：");
		
		int b=new Scanner(System.in).nextInt();
		System.out.println("计算结果:"+a+"+"+b+"="+(a+b));
	}
}
