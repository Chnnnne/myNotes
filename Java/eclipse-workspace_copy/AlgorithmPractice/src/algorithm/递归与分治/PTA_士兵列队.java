package algorithm.递归与分治;

import java.util.Arrays;
import java.util.Scanner;

public class PTA_士兵列队 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int sum=0;
		int x[]=new int [n+1];
		int y[]=new int [n+1];
		for (int i = 1; i <= n; i++) {
			x[i]=sc.nextInt();
			y[i]=sc.nextInt();
		}
		//分析可得，x[i]与y[i]的无关性，因此可以单独分析
		//对于y[i]，需要求得 ym，使得 abs(y[i]-ym)之和最小
		//对于x[i]，需要求得xm，使得abs(x[i]-(xm+i-1))之和最小，也即abs(x[i]-i+1-(xm))，因此可以提前完成前面的算数工作
		Arrays.sort(x,1,n);
		Arrays.sort(y,1,n);
		
		for (int i = 1; i <= n; i++) {
			x[i]=x[i]-i+1;
		}
		int xm=x[(1+n)/2];
		int ym=y[(1+n)/2];
		Arrays.sort(x,1,n);//由于x可能重叠，导致-i+1后的x数组，不是顺序的，因此需要再次排序
		for (int i = 1; i <= n; i++) {
			sum+=Math.abs(x[i]-xm);
			sum+=Math.abs(y[i]-ym);
		}
		System.out.println(sum);
		
	}//main
}
