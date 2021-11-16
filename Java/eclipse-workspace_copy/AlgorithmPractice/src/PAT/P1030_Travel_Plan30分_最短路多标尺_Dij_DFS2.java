package PAT;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class P1030_Travel_Plan30分_最短路多标尺_Dij_DFS2 {

	public static final int INF = 0x3f3f3f3f;
	public static final int MAXN = 510;
	static int N, M, S, D;
	static int g[][] = new int[MAXN][MAXN];
	static int cost[][] = new int[MAXN][MAXN];
	static int dist[] = new int[MAXN];
	static boolean st[] = new boolean[MAXN];
	static int c[] = new int[MAXN];
//	static int pre[] = new int[MAXN];
	static ArrayList<ArrayList<Integer>> pre = new ArrayList<ArrayList<Integer>>();

	static ArrayList<Integer> TempPath = new ArrayList<Integer>();
	static ArrayList<Integer> BestPath;
	static int Tempcost = 0;
	static int Bestcost = INF;

	public static void main(String[] args) throws IOException {
		CreateGraph();
		Dijkstra();
		// Print the Path
//		PrinPath_DFS(D);
		System.out.println(dist[D] + " " + c[D]);
	}// main

	// 访问pre树
	static void DFS(int v) {
		if(v==S) {
			TempPath.add(v);
			Tempcost= 0;
			for(int i=TempPath.size()-1;i>0;i--) {
				int id=TempPath.get(i);
				int Nextid=TempPath.get(i-1);
				Tempcost+=cost[id][Nextid];
			}
			if(Tempcost<Bestcost) {
				Bestcost = Tempcost;
				BestPath = new ArrayList<Integer>(TempPath);
			}
			TempPath.remove(TempPath.size()-1);
			return;
		}
		
		//递归式合法情况
		TempPath.add(v);
		for(Integer i:pre.get(v)) {
			DFS(i);
		}
		TempPath.remove(TempPath.size()-1);
		
		
		
		
	}

	// dfs访问第i个结点
//	private static void PrinPath_DFS(int i) {
//		//递归终止
//		if(i==S) {
//			System.out.print(i+" ");
//			return;
//		}
//		//递归式
//		PrinPath_DFS(pre[i]);
//		System.out.print(i+" ");
//	}

	private static void Dijkstra() {
		Arrays.fill(st, false);
		Arrays.fill(dist, INF);

		dist[S] = 0;
		for (int i = 0; i < N; i++) {
			// Scan
			int t = -1;
			for (int j = 0; j < N; j++) {
				if (!st[j] && (t == -1 || dist[j] < dist[t]))
					t = j;
			}
			// Add
			st[t] = true;
			// Update
			for (int j = 0; j < N; j++) {
				if (!st[j]) {
					if (dist[t] + g[t][j] < dist[j]) {// 对于由t到j 无连接的情况 非负+INF一定>=INF
						dist[j] = dist[t] + g[t][j];
						pre.get(j).clear();
						pre.get(j).add(t);
					} else if (dist[t] + g[t][j] == dist[j]) {
						pre.get(j).add(t);
					}
				}
			}

		} // for

	}

	private static void CreateGraph() throws IOException {
		N = Reader.nextInt();
		M = Reader.nextInt();
		S = Reader.nextInt();
		D = Reader.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					g[i][i] = 0;
					cost[i][i] = 0;
				} else {
					g[i][j] = INF;
					cost[i][j] = INF;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			int a = Reader.nextInt();
			int b = Reader.nextInt();
			int d = Reader.nextInt();
			int c = Reader.nextInt();
			g[a][b] = g[b][a] = Math.min(g[a][b], d); // 路径长度
			cost[a][b] = cost[b][a] = Math.min(cost[a][b], c); // 路径花费,若前面不对cost初始化那么这一项将会始终为0
		}
	}
}
