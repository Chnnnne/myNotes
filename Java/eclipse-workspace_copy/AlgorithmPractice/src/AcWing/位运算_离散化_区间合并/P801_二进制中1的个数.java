package AcWing.位运算_离散化_区间合并;

import java.util.Scanner;

public class P801_二进制中1的个数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			int res=0;
			while(num!=0) {
				num=num-lowbit(num);
				res++;
			}
			System.out.print(res+" ");
		}
	}

	private static int lowbit(int num) {
		return num&-num;
	}//main
}
