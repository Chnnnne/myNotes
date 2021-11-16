package AcWing.二分;

import java.io.IOException;

public class POJ2456_CowAggressive {
	public static void main(String[] args) throws IOException {
		int N = Reader.nextInt();
		int C = Reader.nextInt();
		int []a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i]=Reader.nextInt();
		}
		
		int l=0,r=999;
		while(l<r) {
			int mid=(l+r+1)>>1;
			if(check(mid,C,a)) l=mid;
			else r=mid-1;
		}
		System.out.println(l);
	}//main

	//判断 最小距离为mid ，选C个是否可行
	private static boolean check(int mid, int c, int[] a) {
		int num=1;
		int last=a[0];
		for (int i = 1; i < a.length; i++) {
			if(a[i]-last>=mid) {
				last=a[i];
				num++;
			}
		}
		if(num>=c)
			return true;
		return false;

	}
	
}
