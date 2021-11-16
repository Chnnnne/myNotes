package AcWing.二分;

import java.util.Arrays;
import java.util.Scanner;


public class 最大平均值 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int []w=new int[n];
		int []v=new int[n];
		for (int i = 0; i < n; i++) {
			w[i]=sc.nextInt();
			v[i]=sc.nextInt();
		}
		
		double l=0,r=999999999;
		double eps=1e-5;
		while(r-l>eps) {
			double mid=(l+r)/2;
			if(check(mid,k,w,v)) l=mid;
			else r=mid;
		}
		System.out.println(l);
	}//main

	//判断 是否 可以选择出来K个物品
	//使得这K个物品的单位价值大于等于mid
	private static boolean check(double mid, int k, int[] w, int[] v) {
		int n=w.length;
		Double y[]=new Double[n];
		for (int i = 0; i < n; i++) {
			y[i]=v[i]-mid*w[i];
		}
		
		Arrays.sort(y, (d1,d2)->(int)Math.signum(d2-d1));;
		double Maxsum=0;
		for (int i = 0; i < k; i++) {
			Maxsum+=y[i];
		}
		return Maxsum>=0;
	}
}
