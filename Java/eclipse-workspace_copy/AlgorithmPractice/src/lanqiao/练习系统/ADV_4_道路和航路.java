package lanqiao.练习系统;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ADV_4_道路和航路 {

	public static final int INF = 0x3f3f3f3f;
	public static final int MAXN = 25010;
	public static final int MAXM = 150010;

	static int n, r, p, s;
	static int dist[] = new int[MAXN];
	static boolean st[] = new boolean[MAXN];

	static int h[] = new int[MAXN], e[] = new int[MAXM], w[] = new int[MAXM], ne[] = new int[MAXM], idx = 0;

	public static void main(String[] args) throws IOException {
		CreateGraph();
		Spfa(s);
	}// main

	private static void CreateGraph() throws IOException {
		n = Reader.nextInt();
		r = Reader.nextInt();
		p = Reader.nextInt();
		s = Reader.nextInt();
		Arrays.fill(h, -1);
		for (int i = 0; i < r; i++) {
			int a = Reader.nextInt();
			int b = Reader.nextInt();
			int w = Reader.nextInt();
			add(a, b, w);
			add(b, a, w);
		}
		for (int i = 0; i < p; i++) {
			int a = Reader.nextInt();
			int b = Reader.nextInt();
			int w = Reader.nextInt();
			add(a, b, w);
		}
	}

	private static void add(int a, int b, int w2) {
		e[idx] = b;
		w[idx] = w2;
		ne[idx] = h[a];
		h[a] = idx++;
	}

	private static void Spfa(int s) {
		Arrays.fill(dist, INF);
		Arrays.fill(st, false);
		LinkedList<Integer> queue = new LinkedList<Integer>();

		dist[s] = 0;
		st[s] = true;
		queue.offer(s);
		while (!queue.isEmpty()) {
			Integer t = queue.poll();
			st[t] = false;

			for (int i = h[t]; i != -1; i = ne[i]) {
				int j = e[i];
				if(dist[t] + w[i] < dist[j]) {
					dist[j] = dist[t] + w[i];
					if(!st[j]) {
						queue.offer(j);
						st[j] =true;
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if(dist[i]==INF) System.out.println("NO PATH");
			else System.out.println(dist[i]);
		}
		
		
	}
}
