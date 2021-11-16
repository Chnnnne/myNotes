package lanqiao.练习系统;

import java.util.Scanner;

public class nothing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int l = 0, r = 199;
		while (l < r) {
			int mid = (l+r+1)>>1;
			if(check(mid,x)) l =mid;
			else r=mid-1;
		}
		System.out.println(l);
	}// main

	private static boolean check(int mid, int x) {
		if(mid*4+6<=x) return true;
		return false;
	}
}
