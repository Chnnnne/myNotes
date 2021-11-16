package leetcode.March;

import java.util.Arrays;


public class P0354_俄罗斯套娃_动态规划 {
	public static void main(String[] args) {
		//对w升序排列，然后求h的最长上升序列
		System.out.println(new P0354_俄罗斯套娃_动态规划().maxEnvelopes(
				new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}}
				));
	}//main
	
    public int maxEnvelopes(int[][] envelopes) {
    	int m=envelopes.length;
    	if(m==0) return 0;
    	envelop es[]=new envelop[m+1];
    	int dp[]=new int[m+1];//dp[i]代表 以第i个元素结尾的最长上升子序列的长度
    	
    	for(int i=0;i<m;i++) {
    		es[i+1]=new envelop();
    		es[i+1].w = envelopes[i][0];
    		es[i+1].h = envelopes[i][1];
    	}
    	Arrays.sort(es, 1, m+1, (o1,o2)->o1.w-o2.w);
    	for(int i=1;i<=m;i++)
    		System.out.println(es[i]);
    	dp[1]=1;
    	//下面开始求h的最长上升序列,注意！w不能相同
    	int maxdp=dp[1];
    	for(int i=2 ; i<=m;i++) {
    		int max=0;
    		for(int j=1;j<=i-1;j++) {
    			if(es[i].h>es[j].h&&dp[j]>max&&es[i].w!=es[j].w) {
    				max=dp[j];
    			}
    		}
    		dp[i]=max+1;
    		if(dp[i]>maxdp)
    			maxdp=dp[i];
    	}
    	
    	
    	return maxdp;
    }
}
class envelop{
	int w,h;

	@Override
	public String toString() {
		return "envelop [w=" + w + ", h=" + h + "]";
	}
	
}
