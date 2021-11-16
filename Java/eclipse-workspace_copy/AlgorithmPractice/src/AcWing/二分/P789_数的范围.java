package AcWing.二分;

import java.util.Scanner;


public class P789_数的范围 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int q=sc.nextInt();
		int a[]=new int[n];
		for (int i = 0; i < n; i++) {
			a[i]=sc.nextInt();
		}
		for (int i = 0; i < q; i++) {
			int x=sc.nextInt();
			
			//下面开始求x出现的第一个位置
			//二分求满足大于等于x性质的左边界
			int l=0,r=n-1;
			while(l<r) {
				int mid=(l+r)>>1;
				if(check1(mid,x,a)) r=mid;//求的是index，比的是值
				else l=mid+1;
			}
			System.out.println(l);
			if(a[l]!=x) System.out.println("-1 -1");
			else {
				System.out.print(l+" ");
				
				//下面开始求x出现的最后一个位置
				//二分求满足小于等于x性质的右边界
				l=0; r=n-1;
				while(l<r) {
					int mid=(l+r+1)>>1;
					if(check2(mid, x,a)) l=mid;
					else r=mid-1;
				}
				System.out.println(l);
			}
			
		}

	}//main

	private static boolean check2(int mid, int x, int[] a) {
		if(a[mid]<=x)
			return true;
		return false;
	}

	private static boolean check1(int mid, int x, int[] a) {
		if(a[mid]>=x)
			return true;
		return false;
	}
}
