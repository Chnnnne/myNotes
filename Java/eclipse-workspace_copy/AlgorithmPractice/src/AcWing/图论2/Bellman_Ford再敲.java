package AcWing.图论2;

import java.util.Arrays;
import java.util.Scanner;

class edge {
	int a, b, w;

	public edge(int a, int b, int w) {
		super();
		this.a = a;
		this.b = b;
		this.w = w;
	}
}

public class Bellman_Ford再敲 {
	public static final int MAXN = 510;
	public static final int MAXM = 10010;
	public static final int INF = 0x3f3f3f3f;
	static int n, m, k;
	static edge edges[] = new edge[MAXM];
	static int dist[] = new int[MAXN];
	static int backup[] = new int[MAXN];

	public static void main(String[] args) {
		CreateGraph();
		int ans = BellmanFord();
		if (ans == -1)
			System.out.println("impossible");
		else
			System.out.println(ans);

	}// main

	private static int BellmanFord() {
		Arrays.fill(dist, INF);
		dist[1] = 0;
		for (int i = 0; i < k; i++) {
			System.arraycopy(dist, 0, backup, 0, dist.length);
			for (int j = 0; j < m; j++) {
				int a = edges[j].a;
				int b = edges[j].b;
				int w = edges[j].w;
				dist[b] = Math.min(dist[b], backup[a] + w);
			}
		}
		if (dist[n] > INF / 2)
			return -1;
		else
			return dist[n];
	}

	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			edges[i] = new edge(a, b, w);
		}
	}
}
