package AcWing.图论;

import java.util.Arrays;
import java.util.Scanner;


public class P849_Dijkstra求最短路1 {
	public static final int MAXN = 510;
	public static final int INF = Integer.MAX_VALUE/2;
	
	static int n,m;
	static int g[][]=new int[MAXN][MAXN];		
	static int dist[]=new int[MAXN];			//其他点到V1的距离
	static boolean st[]=new boolean[MAXN];	//记录某点是否已加入已选点集合
	
	public static void main(String[] args) {
		CreateGraph();
		int ans=Dijkstra();
		System.out.println(ans);
	}//main
	
	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i==j) g[i][j]=0;
				else g[i][j]=INF;
			}
		}
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			g[x][y]=Math.min(g[x][y], w); //处理重边，
		}
	}

	private static int Dijkstra() {
		//S1初始化
		Arrays.fill(dist, INF);
		Arrays.fill(st, false);
		
		dist[1]=0;
		//S2:n次循环,每次循环加入一个点
		for(int i=0;i<n;i++) {
			//Scan
			int t=-1;
			for(int j=1;j<=n;j++) 
				if(!st[j] && (t==-1||dist[j]<dist[t]))
					t=j;
			//Add
			st[t]=true;
			//Update
			for(int j=1;j<=n;j++) {
				if(!st[j] && dist[t]+g[t][j]<dist[j])
					dist[j]=dist[t]+g[t][j];
			}
		}
		
		if(dist[n]==INF)//从V1到Vn不存在最短路径(也即非连通)
			return -1;
		else 
			return dist[n];
	}
}
