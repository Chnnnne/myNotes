package algorithm.递归与分治;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PTA_输油管道 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int y[]=new int[n+1];
		int nothing;
		for (int i = 1; i <= n; i++) {
			nothing=sc.nextInt();
			y[i]=sc.nextInt();
		}
		Arrays.sort(y, 1, n);
		int it=y[(1+n)/2];
		int res=0;
		for (int i = 1; i <= n; i++) {
			res+=Math.abs(y[i]-it);
		}
		System.out.println(res);
		
	}//main
}
