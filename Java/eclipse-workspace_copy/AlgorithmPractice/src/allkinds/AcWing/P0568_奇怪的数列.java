package allkinds.AcWing;

import java.util.Scanner;

public class P0568_奇怪的数列 {
	public static void main(String[] args) {
		//r-l为奇数时， 则成对，直接 (r-l+1)/2*(-1)^(l-1)
		//r-l为偶数时， 则成对+1, (r-l)/2*(-1)^(l-1)+r∗(−1)^r 
		
		Scanner sc = new Scanner(System.in);
		int q=sc.nextInt();
		int l,r;
		while(q--!=0) {
			l=sc.nextInt();
			r=sc.nextInt();
			if(((r-l)&1)==1) {
				System.out.println((int)((r-l+1)/2*Math.pow(-1, l-1)));
			}else {
				System.out.println((int)((r-l)/2*Math.pow(-1, l-1)+r*Math.pow(-1, r)));
			}
			
			
		}
	}//main
}
