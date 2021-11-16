package algorithm.动态规划;

import java.util.Scanner;

public class 最大子段和 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n+3];
		for (int i = 1; i <= n; i++) {
			a[i]=sc.nextInt();
		}
		int dp=0;
		int max=-99999999;
		for (int i = 1; i <= n; i++) {
			if(dp>0)
				dp+=a[i];
			else
				dp=a[i];
			if(dp>max) max=dp;
		}
		if(max<0) System.out.println(0);
		else System.out.println(max);

	}//main
}
