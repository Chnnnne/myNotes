package AcWing.前缀和_差分;

import java.io.IOException;

public class P795前缀和 {
	public static void main(String[] args) throws IOException {
		int n = Reader.nextInt();//n个数
		int m = Reader.nextInt();//m个询问
		int a[]=new int[n+1];
		int presum[]=new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = Reader.nextInt();
			presum[i]=presum[i-1]+a[i];
		}
		while(m--!=0) {
			int l = Reader.nextInt();
			int r = Reader.nextInt();
			System.out.println(presum[r]-presum[l-1]);
		}
	}//main
}
