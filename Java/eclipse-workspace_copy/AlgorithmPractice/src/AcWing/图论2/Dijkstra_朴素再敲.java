package AcWing.图论2;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra_朴素再敲 {
	public static final int INF = 0x3f3f3f3f;
	public static final int MAXN = 510;
	public static final int MAXM = 100010;
	static int m, n;
	static int g[][] = new int[MAXN][MAXN];
	static int dist[] = new int[MAXN];
	static boolean st[] = new boolean[MAXN];

	public static void main(String[] args) {
		CreateGraph();
		int ans = dij();
		System.out.println(ans);
	}// main

	private static int dij() {
		Arrays.fill(dist, INF);
		Arrays.fill(st, false);

		dist[1] = 0;
		for (int i = 0; i < n; i++) {
			int t = -1;
			for (int j = 1; j <= n; j++) {
				if (!st[j] && (t == -1 || dist[t] > dist[j]))
					t = j;
			}

			st[t] = true;

			for (int j = 1; j <= n; j++) {
				if (!st[j] && dist[t] + g[t][j] < dist[j])
					dist[j] = dist[t] + g[t][j];
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
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == j)
					g[i][i] = 0;
				else
					g[i][j] = INF;
			}
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			g[a][b] = Math.min(g[a][b], w);
		}
	}
}
