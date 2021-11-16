package algorithm.动态规划;

import java.util.Scanner;

public class 最长上升子序列 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[]=new int [n+1];
		int dp[]=new int [n+1];//dp[i]的含义是 以a[i]结尾的递增序列长度
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		dp[1]=1;
		for( int i=2 ; i<=n ; i++) {
			int maxlength=0;
			for(int t=1 ;t<=i-1;t++) {
				if(dp[t]>maxlength &&a[i]>a[t]) 
					maxlength=dp[t];
			}
			dp[i]=maxlength+1;
		}
		int max=0;
		for (int i = 1; i <= n; i++) {
			max=Math.max(max, dp[i]);
		}
		System.out.println(max);

	}//main
}
