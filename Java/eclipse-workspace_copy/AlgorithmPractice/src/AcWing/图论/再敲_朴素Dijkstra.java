package AcWing.图论;

import java.util.Arrays;
import java.util.Scanner;


/*
 * 稠密图，无负边
 */
public class 再敲_朴素Dijkstra {

	
	public static final int MAXN = 500;
	public static final int INF = Integer.MAX_VALUE/3;
	
	static int n,m;
	static int g[][]=new int[MAXN][MAXN];
	static int dist[]=new int[MAXN];
	static boolean[] st=new boolean[MAXN];
	
	public static void main(String[] args) {
		CreateGraph();
		int ans=Dijkstra();
		if(ans==-1) System.out.println("impossible");
		else System.out.println(ans);
	}//main

	private static int Dijkstra() {
		Arrays.fill(dist, INF);
		Arrays.fill(st, false);
		
		dist[1]=0;
		for(int i=0; i < n;i++) {
			int t=-1;
			for(int j=1;j <= n;j ++) {
				if(!st[j]&&(t==-1||dist[j]<dist[t]))
					t=j;
			}
			
			st[t]=true;
			
			for(int j=1;j<=n;j++) {
				if(!st[j]&&dist[t]+g[t][j]<dist[j]) {
					dist[j]=dist[t]+g[t][j];
				}
			}
		}
		
		if(dist[n]==INF) return -1;
		else return dist[n];
	}

	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if(i==j) g[i][i]=0;
				else g[i][j]=INF;
			}
		}
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			g[a][b]=Math.min(g[a][b], w);
		}
	}
}
