package lanqiao.year2019_10th;

import java.util.Arrays;
import java.util.Scanner;


public class 圣武士 {

	public static final int MAXN = 300010;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- != 0) {
			int a[] = new int[MAXN];
			int presum[] = new int[MAXN];
			int n = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				a[i] = sc.nextInt();
				presum[i] = presum[i - 1] + a[i];
			}
			Arrays.sort(presum, 1, n);
			int max = -1;
			for (int i = 1; i <= n; i++) {
				max=Math.max(max, presum[i]-presum[i-1]);
			}
			System.out.println(max);

		}

	}// main
}
