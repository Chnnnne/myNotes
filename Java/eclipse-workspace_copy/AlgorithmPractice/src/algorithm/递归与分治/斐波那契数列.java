package algorithm.递归与分治;

import java.util.Scanner;

public class 斐波那契数列 {
	public static void main(String[] args) {
		int n=new Scanner(System.in).nextInt();
		if(n<=2) System.out.println(1);
		else {
			int fac[]=new int[2];
			fac[0]=1;fac[1]=1;
			int temp;
			for(int i=3;i<=n;i++) {
				temp=fac[1];
				fac[1]=fac[1]+fac[0];
				fac[0]=temp;
			}
			System.out.println(fac[1]);
		}

	}//main
}
