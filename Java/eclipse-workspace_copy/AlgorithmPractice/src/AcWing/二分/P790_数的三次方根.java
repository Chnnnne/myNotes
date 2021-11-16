package AcWing.二分;

import java.util.Scanner;

public class P790_数的三次方根 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n = sc.nextDouble();
		double l=-10000,r=10000;
		double eps=1e-8;
		while(r-l>eps) {
			double mid=(l+r)/2;
			if(check(mid,n)) l=mid;
			else r=mid;
		}
		System.out.printf("%.6f",r);
	}//main

	//性质是，小于等于
	private static boolean check(double mid, double n) {
		if(mid*mid*mid<=n)
			return true;
		return false;
	}
}
