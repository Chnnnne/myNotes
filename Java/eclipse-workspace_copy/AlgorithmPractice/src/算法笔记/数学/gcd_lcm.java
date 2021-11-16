package 算法笔记.数学;

import java.util.Scanner;

public class gcd_lcm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int num1 = gcd(a, b);
		int num2 = lcm(a, b);
		System.out.println("gcd: "+num1+"   lcm:"+num2);
	}// main
	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
	private static int lcm(int a, int b) {
		return a/gcd(a, b)*b;
	}
}
