package AcWing.图论2;

import java.util.Arrays;
import java.util.Scanner;

import algorithm.数论.gcd;

public class Dijkstra_朴素再敲_2 {
	public static final int INF = 0x3f3f3f3f;
	public static final int MAXN = 110;
	public static final int MAXM = 100010;
	static int n, m;
	static int g[][] = new int[MAXN][MAXN];
	static int dist[] = new int[MAXN];
	static boolean st[] = new boolean[MAXN];

	public static void main(String[] args) {
		CreateGraph();
		int ans = Dijkstra(1);
		System.out.println(ans);
	}// main

	private static int Dijkstra(int start) {
		Arrays.fill(st, false);
		Arrays.fill(dist, INF);

		dist[start] = 0;
		for (int i = 1; i <= n; i++) {
			int t = -1;
			// Scan
			for (int j = 1; j <= n; j++) {
				if (!st[j] && (t == -1 || dist[j] < dist[t]))
					t = j;
			}
			// Add
			st[t] = true;
			// Update
			for (int j = 1; j <= n; j++) {
				if (!st[j] && dist[t] + g[t][j] < dist[j]) {
					dist[j] = dist[t] + g[t][j];
				}
			}
		}
		// Finish
		if (dist[n] == INF) return -1;
		else return dist[n];
	}

	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == j)
					g[i][j] = 0;
				else
					g[i][j] = INF;
			}
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			g[x][y] = Math.min(g[x][y], w);
		}
	}
}
