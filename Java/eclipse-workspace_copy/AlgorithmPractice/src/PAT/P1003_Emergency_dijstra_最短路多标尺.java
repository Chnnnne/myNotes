package PAT;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class P1003_Emergency_dijstra_最短路多标尺 {

	public static final int INF = 0x3f3f3f3f;
	public static final int MAXN = 510;

	static int n, m, c1, c2;
	static int g[][] = new int[MAXN][MAXN];
	static int weight[] = new int[MAXN];
	static int dist[] = new int[MAXN];
	static boolean st[] = new boolean[MAXN];
	static int w[] = new int[MAXN];
	static int nums[] = new int[MAXN];

	public static void main(String[] args) throws IOException {
		CreateGraph();
		Dijkstra();
	}// main

	private static void Dijkstra() {
		Arrays.fill(st, false);
		Arrays.fill(dist, INF);
		Arrays.fill(w, 0);
		Arrays.fill(nums, 0);

		dist[c1] = 0;
		w[c1] = weight[c1];
		nums[c1] = 1;

		for (int i = 0; i < n; i++) {
			// Scan
			int t = -1;
			for (int j = 0; j < n; j++) {
				if (!st[j] && (t == -1 || dist[j] < dist[t]))
					t = j;
			}
			// Add
			st[t] = true;

			// Update
			for (int j = 0; j < n; j++) {
				if (!st[j]) {
					if (dist[t] + g[t][j] < dist[j]) {
						dist[j] = dist[t] + g[t][j];
						nums[j] = nums[t];
						w[j] = w[t] + weight[j];
					} else if (dist[t] + g[t][j] == dist[j]) {
						nums[j] = nums[j] + nums[t];
						if (w[j] < w[t] + weight[j])
							w[j] = w[t] + weight[j];
					}
				}
			}

		}
		
		System.out.println(nums[c2]+" "+w[c2]);
		
	}

	private static void CreateGraph() throws IOException {
//		Scanner sc = new Scanner(System.in);
		n = Reader.nextInt();
		m = Reader.nextInt();
		c1 = Reader.nextInt();
		c2 = Reader.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					g[i][j] = 0;
				else
					g[i][j] = INF;
			}
		}
		for (int i = 0; i < n; i++) {
			weight[i] = Reader.nextInt();
		}
		for (int i = 0; i < m; i++) {
			int a = Reader.nextInt();
			int b = Reader.nextInt();
			int wet = Reader.nextInt();
			g[a][b] = g[b][a] = Math.min(g[a][b], wet);
		}
	}
}
