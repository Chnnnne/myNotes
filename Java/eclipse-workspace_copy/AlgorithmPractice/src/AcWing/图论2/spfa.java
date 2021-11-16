package AcWing.图论2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class spfa {

	public static final int INF = 0x3f3f3f3f;
	public static final int MAXN = 100010;
	static int n, m;
	static int h[] = new int[MAXN], e[] = new int[MAXN], ne[] = new int[MAXN], w[] = new int[MAXN], idx = 0;
	static int dist[] = new int[MAXN];
	static boolean st[] = new boolean[MAXN];

	public static void main(String[] args) {
		CreateGraph();
		int ans = spfa();
		if (ans == -1)
			System.out.println("impossible");
		else
			System.out.println(ans);
	}// main

	// 谁被更新了，谁才有权去更新别人
	// 把更新了的点加入一个队列，st维护队列的不重复性
	private static int spfa() {
		Arrays.fill(dist, INF);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		dist[1] = 0;
		queue.offer(1);
		st[1] = true;
		while (!queue.isEmpty()) {
			Integer t = queue.poll();
			st[t] = false;

			for (int i = h[t]; i != -1; i = ne[i]) {// 循环每一条边
				int j = e[i];
				if (dist[t] + w[i] < dist[j]) {
					dist[j] = dist[t] + w[i];
					if (!st[j]) {
						queue.offer(j);
						st[j] = true;
					}
				}
			}
		}
		if (dist[n] == INF)
			return -1;
		else
			return dist[n];

	}

	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		Arrays.fill(h, -1);
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			add(a, b, w);
		}
	}

	private static void add(int a, int b, int w2) {
		e[idx] = b;
		w[idx] = w2;
		ne[idx] = h[a];
		h[a] = idx++;
	}
}
