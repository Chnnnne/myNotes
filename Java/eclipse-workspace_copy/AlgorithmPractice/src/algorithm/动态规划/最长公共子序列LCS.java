package algorithm.动态规划;

import java.util.Scanner;

public class 最长公共子序列LCS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();	str1="0"+str1; 
		String str2 = sc.next();	str2="0"+str2;
		int [][] dp=new int [str1.length()+2][str2.length()+2];
		
		for(int i=1 ; i<=str1.length()-1;i++ )
			for(int j=1 ; j<=str2.length()-1 ; j++) {
				if(str1.charAt(i)==str2.charAt(j))
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		System.out.println(dp[str1.length()-1][str2.length()-1]);
		
	}//main
}
