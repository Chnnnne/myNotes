package AcWing.二分;

import java.io.IOException;

public class POJ1064_分割绳子 {
	public static void main(String[] args) throws IOException {
		int N = Reader.nextInt();
		int K = Reader.nextInt();
		double L[]=new double[N];
		for (int i = 0; i < N; i++) {
			L[i] = Reader.nextDouble();
		}
		double l=0,r=100000;
		double eps=1e-5;
		while(r-l>eps) {
			double mid=(l+r)/2;
			if(check(mid,K,L)) l=mid;
			else r=mid;
		}
		System.out.printf("%.2lf",Math.floor(l*100)/100);

	}//main
	//可以得到K条长度为mid的绳子
	private static boolean check(double mid, int k, double[] len) {
		int length = len.length;
		int count=0;
		for(int i=0;i<length;i++) {
			count+=(int)(len[i]/mid);
		}
		return count>=k;
	}
}
