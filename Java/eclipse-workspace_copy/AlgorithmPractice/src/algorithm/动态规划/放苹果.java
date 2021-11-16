package algorithm.动态规划;

import java.util.Scanner;

public class 放苹果 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while((t--)!=0) {
			int M=sc.nextInt();
			int N=sc.nextInt();
			int dp[][]=new int[M+2][N+2];//dp[i][j]的含义是 i个苹果放在j个盘子里的放法
			
			//临界条件
			for(int i=0; i<=N ;i++) {
				dp[0][i]=1;
				dp[1][i]=1;
			}
			for(int i=0;i<=M;i++)
				dp[i][1]=1;
			
			//递归方程的迭代实现
			for( int i=2 ; i<=M ; i++ ) {
				for( int j=2 ;j<=N ;j++  ) {
					if(j>i) dp[i][j]=dp[i][i];
					else dp[i][j]=dp[i-j][j]+dp[i][j-1];
				}
			}
			System.out.println(dp[M][N]);
			
		}

	}//main
}
