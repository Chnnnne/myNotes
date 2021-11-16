package leetcode.February;

import java.util.Arrays;


public class P1004_最大连续1的个数 {
	public static void main(String[] args) {
		int [] a= {1,1,1,0,0,0,1,1,1,1,0};
		
		int longestOnes = new P1004_最大连续1的个数().longestOnes(a, 2);
		System.out.println(longestOnes);
	}//main
	
	//滑动窗口
	//寻找长度最大的子数组，该数组满足0的个数<=K
	public int longestOnes(int[] A, int K) {
		int N =A.length;//数组长度，用于限制指针终点
		int left=0,right=0;//双指针
		int zeroCount=0;//用于满足窗口条件的变量        可能用于计数、求和
		int res=0;//保存窗口的最大长度
		
		while(right<N)
		{
			if(A[right]==0)
				zeroCount++;
			while(zeroCount>K) {
				if(A[left]==0) zeroCount--;
				left++;
			}
			res=Math.max(res, right-left+1);
			right++;
		}
		return res;
		
	}
	
	
	
    public int longestOnes_02(int[] A, int K) {
    	//A[i]是第i-1个数， zero[i]是截止到第i个，也即A[i-1]已有的零的数目
    	int [] zero=new int[A.length+1];
    	
    	for (int i = 1; i <= A.length; i++) {
			if(A[i-1]==0)
				zero[i]=zero[i-1]+1;
			else
				zero[i]=zero[i-1];
		}
    	int l = 1, r = A.length, mid;
    	while(l+1!=r) 
    	{
    		mid=(l+r)>>1;
    		if(Check(mid,A.length,K,zero)) 
    			l=mid;
    		else 
    			r=mid;
    	}
    	
    	return r-1;
    }
    //true:长度为mid可以满足
    //false:长度为mid不可以满足
    //例：length=6, mid=2, 只需从i=1判断到i=5即可， 	此外，若k>=mid 直接为true
	private boolean Check(int mid, int length, int k, int[] zero) {
		if(k>=mid) return true;
		for(int i=1;i<=length-mid+1;i++) {
			if(zero[i+mid-1]-zero[i-1]<=k)
				return true;
		}
		return false;
	}

	public int longestOnes_01(int[] A, int K) {
    	//A[i]是第i-1个数， zero[i]是截止到第i个，也即A[i-1]已有的零的数目
    	int [] zero=new int[A.length+1];
    	
    	for (int i = 1; i <= A.length; i++) {
    		if(A[i-1]==0)
    			zero[i]=zero[i-1]+1;
    		else
    			zero[i]=zero[i-1];
    	}
    	int Maxlength=0;
    	for( int i = 1;i <= A.length; i++)
    		for(int j = i+K-1;j<= A.length; j++) {
    			if(j-i+1>Maxlength && zero[j]-zero[i-1]<=K )
    				Maxlength=j-i+1;
    		}
    	
    	return Maxlength;
    }
}
