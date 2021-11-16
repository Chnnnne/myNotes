package lanqiao.year2021_12th_simulate;

import java.util.Scanner;

import algorithm.数论.gcd;

public class P1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int count=0;
		for(int i=1;i<=n;i++) {
			if(gcd(2020,i)==1) {
				count++;
			}
		}
		System.out.println(count);

	}//main

	private static int gcd(int a, int b) {
		while(b!=0) {
			int temp=a%b;
			a=b;
			b=temp;
		}
		return a;
	}
}
