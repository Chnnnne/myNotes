package algorithm.动态规划;

import java.util.Scanner;


public class 背包_01背包 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int W =sc.nextInt();
		int w[] = new int[n+3];
		int v[] = new int[n+3];
		int dp[][]= new int[n+3][W+3];
		for( int i=1;i<=n;i++)
			w[i]=sc.nextInt();
		for( int i=1;i<=n;i++)
			v[i]=sc.nextInt();
		for(int i=1;i<=n;i++)
			for(int j=1;j<=W;j++) 
			{
				if(w[i]>j)
				dp[i][j]=dp[i-1][j];
				else
				dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
			}	
		System.out.println(dp[n][W]);

	}//main
}
