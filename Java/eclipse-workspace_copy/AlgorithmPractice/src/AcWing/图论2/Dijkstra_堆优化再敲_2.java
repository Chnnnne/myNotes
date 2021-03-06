package AcWing.图论2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra_堆优化再敲_2 {
	public static final int INF = 0x3f3f3f3f;
	public static final int MAXN = 150010;
	static int n, m;
	static int e[] = new int[MAXN], ne[] = new int[MAXN], h[] = new int[MAXN], w[] = new int[MAXN], idx = 0;
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
		PriorityQueue<distance> heap = new PriorityQueue<distance>((o1, o2) -> o1.dis - o2.dis);

		dist[start] = 0;
		heap.offer(new distance(0, start));

		while (!heap.isEmpty()) {
			// Scan
			distance poll = heap.poll();
			int dis = poll.dis;
			int idx = poll.idx;
			if (st[idx])
				continue;
			// Add
			st[idx] = true;
			// Update
			for(int k = h[idx] ; k!=-1;k=ne[k] ) {
				int j = e[k];
				if(dist[idx]+w[k] < dist[j]) {
					dist[j] = dist[idx]+w[k];
					heap.offer(new distance(dist[j], j));
				}
			}
		}
		if(dist[n] == INF) return -1;
		else return dist[n];
	}

	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		Arrays.fill(h, -1);
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			add(x, y, w);
		}
	}

	private static void add(int a, int b, int w2) {
		e[idx] = b;
		w[idx] = w2;
		ne[idx] = h[a];
		h[a] = idx++;
	}

}
