package AcWing.图论;

import java.util.Arrays;
import java.util.Scanner;

public class P861_二分图的最大匹配_匈牙利算法 {
	public static final int MAXN = 510;
	public static final int MAXM = 100010;

	static int n1, n2, m;
	static int h[] = new int[MAXN], e[] = new int[MAXM], ne[] = new int[MAXM], idx = 0;
	static int match[] = new int[MAXN]; // 表示每个妹子当前的归属
	static boolean st[] = new boolean[MAXN]; // 记录妹子是否被访问过

	public static void main(String[] args) {
		CreateGraph();

		int res = 0;
		for (int i = 1; i <= n1; i++) {
			Arrays.fill(st, false);
			if (find(i))
				res++;
		}

		System.out.println(res);

	}// main

	/*
	 * 对于当前男生x ,看是否能找到匹配的妹子,如果能的话就返回true,并更新各个match
	 */
	private static boolean find(int x) {
		// 枚举男生x心仪的妹子列表j
		for (int i = h[x]; i != -1; i = ne[i]) {
			int j = e[i];	
			if (!st[j]) {	//如果妹子被访问过了，就不再访问了
				st[j] = true;
				if (match[j] == 0 || find(match[j])) {
					//如果妹子j没有找到男朋友，或者其男朋友match[j]可以另寻他人的话，那么男生x就可以和j配对了
					match[j] = x;
					return true;
				}
			}
		}
		return false;
	}

	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		m = sc.nextInt();
		Arrays.fill(h, -1);
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			add(a, b);
		}
	}

	private static void add(int a, int b) {
		e[idx] = b;
		ne[idx] = h[a];
		h[a] = idx++;
	}

}
