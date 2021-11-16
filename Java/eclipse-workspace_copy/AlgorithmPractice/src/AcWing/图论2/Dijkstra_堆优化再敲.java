package AcWing.图论2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class distance {
	int dis, idx;

	public distance(int dis, int idx) {
		super();
		this.dis = dis;
		this.idx = idx;
	}
}

public class Dijkstra_堆优化再敲 {

	public static final int INF = 0x3f3f3f3f;
	public static final int MAXN = 150010;
	static int n, m;
	static int e[] = new int[MAXN], h[] = new int[MAXN], ne[] = new int[MAXN], w[] = new int[MAXN], idx = 0;
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

		PriorityQueue<distance> heap = new PriorityQueue<distance>((o1, o2) -> o1.dis - o2.dis);
		dist[1] = 0;
		heap.offer(new distance(0, 1));

		while (!heap.isEmpty()) {
			// scan
			distance poll = heap.poll();
			int distance = poll.dis;
			int index = poll.idx;
			if (st[index])
				continue;
			// Add
			st[index] = true;
			// Update
			for (int i = h[index]; i != -1; i = ne[i]) {
				int j = e[i];
				if (!st[j] && distance + w[i] < dist[j]) {
					dist[j] = distance + w[i];
					heap.offer(new distance(dist[j], j));
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
