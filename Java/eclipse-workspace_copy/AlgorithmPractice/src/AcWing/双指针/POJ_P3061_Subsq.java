package AcWing.双指针;

import java.io.IOException;

public class POJ_P3061_Subsq {
	public static void main(String[] args) throws IOException {
		int T = Reader.nextInt();
		while(T--!=0) {
			int N=Reader.nextInt();
			int S=Reader.nextInt();
			int allSum=0;
			int a[]=new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = Reader.nextInt();
				allSum+=a[i];
			}
			if(allSum<S) System.out.println(0);
			else {
				int l=0,r=0;//r在左主动，l在右从动。都向右移动
				int sum=0;
				int res=N;
				while(r<N) {
					while(l<N&&sum<S) {
						sum+=a[l];
						l++;
					}
					if(sum<S) break;
					res=Math.min(res, l-r);
					sum-=a[r];
					r++;
				}
				System.out.println(res);
				
			}
		}
	}//main
}
