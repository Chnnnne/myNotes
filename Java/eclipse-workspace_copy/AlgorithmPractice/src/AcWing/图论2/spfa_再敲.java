package AcWing.图论2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class spfa_再敲 {
	public static final int INF = 0x3f3f3f3f;
	public static final int MAXN = 100010;
	static int n, m;
	static int e[] = new int[MAXN], h[] = new int[MAXN], w[] = new int[MAXN], ne[] = new int[MAXN], idx = 0;
	static int dist[] = new int[MAXN];
	static boolean st[] = new boolean[MAXN];

	public static void main(String[] args) {
		CreateGraph();
		int ans = Spfa(1);
		if (ans == -1)
			System.out.println("impossible");
		else
			System.out.println(ans);

	}// main

	private static int Spfa(int start) {
		Arrays.fill(st, false);
		Arrays.fill(dist, INF);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		dist[start] = 0;
		queue.offer(start);
		st[start] = true;
		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			st[poll] = false;
			for (int i = h[poll]; i != -1; i = ne[i]) {
				int j = e[i];
				if (dist[poll] + w[i] < dist[j]) {
					dist[j] = dist[poll] + w[i];
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
		Arrays.fill(h, -1);
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
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
