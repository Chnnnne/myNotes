package leetcode.February;

public class P0005_最长回文子串_动态规划 {
	public static void main(String[] args) {
		System.out.println(new P0005_最长回文子串_动态规划().longestPalindrome("ac"));

	}//main
	
    public String longestPalindrome(String s) {
    	int N = s.length();
    	boolean dp[][]=new boolean[N][N];//dp[i][j]的含义是：index from i to j 代表的子串是否回文
    	for(int len = 1; len <= N;len++) {
    		for(int i = 0;i+len-1 < N;i++) {
    			if(len==1) dp[i][i]=true;
    			else if(len==2) dp[i][i+1]=(s.charAt(i)==s.charAt(i+1));
    			else {
    				dp[i][i+len-1]=(dp[i+1][i+len-2]&&s.charAt(i)==s.charAt(i+len-1));
    			}
    		}
    	}
    	//  此处出现错误！不能这样，应该先len后i
//    	for(int i = 0; i < N; i++) {
//    		for(int len =1; len <= N-i;len++ ) {
//    			if(len==1) dp[i][i]=true;
//    			else if(len==2) dp[i][i+1]=(s.charAt(i)==s.charAt(i+1));
//    			else {
//    				dp[i][i+len-1]=(dp[i+1][i+len-2]&&s.charAt(i)==s.charAt(i+len-1));
//    			}
//    		}
//    	}
    	int Maxlen=0;
    	int Maxi=0,Maxj=0;
    	for(int i=0;i<N;i++) {
    		for(int j=i;j<N;j++) {
    			if(dp[i][j]&&j-i+1>Maxlen) {
    				Maxlen=j-i+1;
    				Maxi=i;
    				Maxj=j;
    			}
    		}
    	}
    	//返回字符串中最长的回文子串
    	return s.substring(Maxi, Maxj+1);
    }
}