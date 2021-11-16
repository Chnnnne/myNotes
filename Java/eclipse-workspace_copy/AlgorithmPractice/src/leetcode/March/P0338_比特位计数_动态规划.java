package leetcode.March;

import java.util.Arrays;



public class P0338_比特位计数_动态规划 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new P0338_比特位计数_动态规划().countBits(5)));

	}//main
	

    public int[] countBits(int num) {
    	int dp[]=new int[num+1];
    	for(int i = 1 ; i <= num; i++) {
    		dp[i]=(i&1)==0? dp[i/2]:dp[i-1]+1;
    	}
    	return dp;
    }
	
	
	
	
	
	
	
	
	
	
	
	
//    public int[] countBits(int num) {
//    	int ret[]=new int[num+1];
//    	for (int i = 0; i <= num; i++) {
//			ret[i]=new Integer(i).bitCount(i);
//		}
//    	return ret;
//    }
}
