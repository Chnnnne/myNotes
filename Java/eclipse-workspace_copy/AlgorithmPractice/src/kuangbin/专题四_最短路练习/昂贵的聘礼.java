package kuangbin.专题四_最短路练习;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 昂贵的聘礼 {

	public static final int INF = 0x3f3f3f3f;
	public static final int MAXN = 110;
	public static final int MAXM = 10010;
	static int M, N;
	static int level[] = new int[MAXN];
	static int h[] = new int[MAXN], e[] = new int[MAXM], ne[] = new int[MAXM], w[] = new int[MAXM], idx = 0;

	static int dist[] = new int[MAXN];
	static boolean st[] = new boolean[MAXN];

	public static void main(String[] args) {
		CreateGraph();
		int ans = INF;
		for (int i = level[1] - M; i <= level[1]; i++) { //等级范围 肯定是要包含1点的 不然你连1都无法购买 
			//可以和[i, i + k]区间的人交易
			Spfa(i, i + M);
			ans = Math.min(dist[1], ans); 
		}
		System.out.println(ans);
	}// main

	private static void Spfa(int left,int right) {
		Arrays.fill(st, false);
		Arrays.fill(dist, INF);
		LinkedList<Integer> queue = new LinkedList<Integer>();

		dist[0] = 0;
		st[0] = true;
		queue.offer(0);
		while (!queue.isEmpty()) {
			Integer t = queue.poll();
			st[t] = false;

			for (int i = h[t]; i != -1; i = ne[i]) {
				int j = e[i];// 弧头

				if (dist[t] + w[i] < dist[j]&&(left<=level[j]&&level[j]<=right)) {
					dist[j] = dist[t] + w[i];
					if(!st[j]) {
						st[j] = true;
						queue.offer(j);
					}
				}
			}

		}
	}

	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		Arrays.fill(h, -1);
		M = sc.nextInt();
		N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			int prize = sc.nextInt();
			level[i] = sc.nextInt();
			add(0, i, prize);
			int m = sc.nextInt();
			for (int j = 0; j < m; j++) {
				int b = sc.nextInt();
				int w = sc.nextInt();
				add(b, i, w);
			}
		}

	}
	private static void add(int a, int b, int w2) {
		e[idx] = b;
		w[idx] = w2;
		ne[idx] = h[a];
		h[a] = idx++;
	}
}
