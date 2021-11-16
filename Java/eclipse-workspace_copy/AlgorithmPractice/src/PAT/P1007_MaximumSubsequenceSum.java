package PAT;

import java.io.IOException;

public class P1007_MaximumSubsequenceSum {
	public static void main(String[] args) throws IOException {
		int K = Reader.nextInt();
		int dp[]=new int[K+1];
		int a[]=new int[K+1];
		int left[]=new int[K+1];
		for(int i=1;i<=K;i++) {
			a[i]=Reader.nextInt();
			if(dp[i-1]>0) {
				dp[i]=dp[i-1]+a[i];
				left[i]=left[i-1];
			}
			else {
				dp[i]=a[i];
				left[i]=i;
			}
			
		}
		int max=-2100000000;
		int right=0;
		for(int i=1;i<=K;i++) {
			if(dp[i]>max) {
				max=dp[i];
				right=i;
			}
		}
		if(max<0)
			System.out.println(0+" "+a[1]+" "+a[K]);
		else
//			System.out.println(max+" "+(left[right]-1)+" "+(right-1));
		System.out.println(max+" "+a[left[right]]+" "+a[right]);
	}//main

}
