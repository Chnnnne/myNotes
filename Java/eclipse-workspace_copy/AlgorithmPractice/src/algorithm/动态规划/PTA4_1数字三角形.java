package algorithm.动态规划;

import java.util.Scanner;

public class PTA4_1数字三角形 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int [n+2];
		int dp[][]=new int [2][n+2];
		a[1]=sc.nextInt();
		dp[1][1]=a[1];
		for(int i=2 ; i<=n ; i++)
			for(int j=1 ; j<=i; j++)
			{
				a[j]=sc.nextInt();
				dp[i%2][j]=Math.max(dp[(i-1)%2][j-1], dp[(i-1)%2][j])+a[j];
			}
		
		int max=0;
		for(int i=1;i<=n;i++){
			if(dp[n%2][i]>max) max=dp[n%2][i];
		}
		System.out.println(max);

	}//main
}
