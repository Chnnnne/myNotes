package PAT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class P1002_ABforPolynomials {
	public static void main(String[] args) throws IOException {
		//K 一行中的个数， N1指数、aN1系数
		//a[i]=value 代表指数为i的系数为value
		double a[]=new double[1003];
		int K1 = Reader.nextInt();
		int zhi;
		double xi;
		while(K1--!=0) {
			zhi = Reader.nextInt();
			xi = Reader.nextDouble();
			a[zhi]+=xi;
		}
		int K2 = Reader.nextInt();
		while(K2--!=0) {
			zhi = Reader.nextInt();
			xi = Reader.nextDouble();
			a[zhi]+=xi;
		}
		int cnt=0;
		for (int i = 1000; i >= 0; i--) {
			if(a[i]!=0) cnt++;
		}
		System.out.print(cnt);
		for (int i = 1000; i >= 0; i--) {
			if(a[i]!=0) System.out.format(" %d %.1f", i,a[i]);
		}
		
	}//main
}
