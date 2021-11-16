package AcWing.双指针;

import java.util.Arrays;

public class leetcode_P1004 {
	//寻找一个最长的子区间，区间满足 0的个数小于等于K
	public static void main(String[] args) {
		System.out.println(new leetcode_P1004().longestOnes(
				new int[] {0,0,0,0}, 0));

	}//main
    public int longestOnes(int[] A, int K) {
    	int N=A.length;
    	int presum[]=new int[N+1];//前缀和数组,记录0的个数  presum[i]代表 截止到index i-1位置0的个数
    	for(int i=1;i<=N;i++) {
    		presum[i]=presum[i-1]+(A[i-1]==0?1:0);//
    	}
    	System.out.println(Arrays.toString(presum));
    	int res=0;
    	for(int left=0,right=0;right<N;right++) {
    		while(left<right&&presum[right+1]-presum[left]>K) {
    			left++;
    		}
    		if(right==left&&A[right]==0)
    			continue;
    		res=Math.max(res, right-left+1);
    	}
    	return res;
    }
}
