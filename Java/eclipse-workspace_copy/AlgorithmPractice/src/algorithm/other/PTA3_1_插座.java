package algorithm.other;

import java.util.Scanner;

public class PTA3_1_插座 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		System.out.println((int)(Math.ceil((N-1)*1.0/(K-1))));
	}//main
}
