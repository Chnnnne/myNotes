package algorithm.递归与分治;

import java.util.Scanner;

public class PTA_谁没有完成实验 {
	public static void main(String[] args) {
		int stu[]=new int[1000002];
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		for (int i = 0; i < N; i++) {
			stu[sc.nextInt()]++;
		}
		int M=sc.nextInt();
		for (int i = 0; i < M; i++) {
			int n=sc.nextInt();
			if(stu[n]==0)
				System.out.println("NO");
			else {
				System.out.println("YES");
			}
		}

	}//main
}
