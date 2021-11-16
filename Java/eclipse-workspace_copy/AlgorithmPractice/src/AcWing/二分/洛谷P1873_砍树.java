package AcWing.二分;

import java.io.IOException;
import java.util.Scanner;

public class 洛谷P1873_砍树 {
	public static void main(String[] args) throws IOException {
		int N=Reader.nextInt();//树木的个数
		int M=Reader.nextInt();//需要的木材长度
		int a[]=new int[N];
		long sum=0;
		for (int i = 0; i < N; i++) {
			a[i]=Reader.nextInt();
		}
		int l=0,r=1000000000;
		while(l<r) {
			int mid=(l+r+1)>>1;
			if(check(mid,a,M)) l=mid;
			else r=mid-1;
		}
		System.out.println(l);

	}//main
	//判断砍mid高度 是否满足高度大于等于M
	private static boolean check(int mid, int[] a, int m) {
		long sum=0;
		int len=a.length;
		for(int i=0;i<len;i++) {
			if(a[i]>mid)
				sum+=a[i]-mid;
		}
		if(sum>=m)
			return true;
		return false;
	}
}
