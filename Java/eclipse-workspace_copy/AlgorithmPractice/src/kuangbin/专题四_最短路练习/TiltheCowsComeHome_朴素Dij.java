package kuangbin.专题四_最短路练习;

import java.util.Arrays;
import java.util.Scanner;

public class TiltheCowsComeHome_朴素Dij {
	public static final int MAXN = 1010;
	public static final int MAXM = 2010;
	public static final int INF = Integer.MAX_VALUE/3;
	
	static int m,n;
	static int g[][]=new int[MAXN][MAXN];
	static int dist[]=new int[MAXN];
	static boolean st[]=new boolean[MAXN];
	
	public static void main(String[] args) {
		CreateGraph();
		int ans = disktra();
		System.out.println(ans);

	}//main

	private static int disktra() {
		Arrays.fill(dist, INF);
		Arrays.fill(st, false);
		
		dist[1]=0;
		for(int i=0;i<n;i++) {
			int t=-1;
			for(int j=1;j<=n;j++) {
				if(!st[j]&&(t==-1||dist[j]<dist[t])) {
					t=j;
				}
			}
			
			st[t]=true;
			
			for(int j=1;j<=n;j++) {
				if(!st[j]&&dist[t]+g[t][j]<dist[j]) {
					dist[j]=dist[t]+g[t][j];
				}
			}
		}
		
		
		return dist[n];
	}

	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if(i==j) g[i][j]=0;
				else g[i][j]=INF;
			}
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			g[a][b]=Math.min(g[a][b], w);
			g[b][a]=Math.min(g[b][a], w);
		}
	}
}
