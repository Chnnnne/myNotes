package lanqiao.练习系统;

import java.util.Scanner;

public class ALGO_202 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int R = sc.nextInt();
		
		int dp[]=new int[R+1];
		for(int i=1;i<=R;i++) {
			dp[i]=(i&1)==1?dp[i-1]+1:dp[i/2];
		}
		int sum=0;
		for(int i=L;i<=R;i++) {
			sum+=dp[i];
		}
		System.out.println(sum);
	}//main
}
