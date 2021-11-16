package leetcode.March;

import java.util.Arrays;

public class P0132_分割回文串2_动态规划 {

	public static void main(String[] args) {
		System.out.println();

	}//main
	
	//给定一个字符串，切几下将其成为都是回文串的子串，问最少切几次
	//动态规划的思想
	//设 f[i]表示字符串的前缀 s[0..i]的最少分割次数
	//递归方程:
	//f[i]=min(f[j])+1，其中j<i且 s[j...i]是回文串
	//f[i]=0;//本身就是回文
	
	//再动态规划求子串的回文
	//boolean dp[i][j]代表str[i..j]是否是回文

	public int minCut(String s) {
    	int len=s.length();
    	int f[]=new int[len];
    	char[] charArray = s.toCharArray();
    	Arrays.fill(f, Integer.MAX_VALUE);
    	boolean dp[][]=new boolean[len][len];
    	
    	for(int i=1;i<=len;i++)
    		for(int j=0;j+i-1<=len-1;j++) {
    			int tem=j+i-1;
    			if(i==1) dp[j][j]=true;
    			if(i==2) dp[j][j+1]=charArray[j]==charArray[j+1];
    			if(i>2) dp[j][tem]=(dp[j+1][tem-1])&&(charArray[j]==charArray[tem]);
    		}
    	
    	
    	
    	for(int i=0;i<len;i++) {
    		if(dp[0][i]) f[i]=0;
    		for(int j=0;j<i;j++) {
    			if(dp[j+1][i]) f[i]=Math.min(f[i], f[j]+1);
    		}
    		
    	}
    	
    	
    	return f[len-1];
    }
}
