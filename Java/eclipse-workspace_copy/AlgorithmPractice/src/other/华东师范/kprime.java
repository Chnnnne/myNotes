package other.华东师范;

import java.util.Scanner;

public class kprime {
	static int l, k, count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		k = sc.nextInt();
		Get_primTable();
		if (count > k)
			System.out.println("Yes");
		else
			System.out.println("No");
	}// main

	static boolean isHe[] = new boolean[300000020];

	// 获得1-MAXN范围内的所有素数
	private static void Get_primTable() {
		for (int i = 2; i < l + 2 * k; i++) {
			if (!isHe[i]) {
				if (l <= i)
					count++;
				for (int j = i; j < l+2*k; j += i) {
					isHe[j] = true;
				}
			}
		}
	}
}
