package AcWing.图论;

import java.util.Arrays;
import java.util.Scanner;

public class P858_Prim算法求最小生成树 {
	public static final int INF = 0x3f3f3f3f;
	public static final int MAXN = 510;
	static int n,m;
	static int g[][]= new int[MAXN][MAXN];
	static int dist[]=new int[MAXN];
	static boolean st[]=new boolean[MAXN];
	
	public static void main(String[] args) {
		CreateGraph();
		int ans=Prim();
		if(ans==INF) System.out.println("impossible");
		else System.out.println(ans);

	}//main

	private static int Prim() {
		Arrays.fill(dist, INF);
		Arrays.fill(st, false);
		int res=0;
		for(int i=1;i<=n;i++) {
			//Scan 从未选集合中，找到到已选集合中最近的那个点
			int t=-1;
			for(int j=1;j<=n;j++) {
				if(!st[j]&&(t==-1||dist[j]<dist[t])) {
					t=j;
				}
			}
			
			//Add
			st[t]=true;
			if(i!=1&&dist[t]==INF) return INF;
			if(i!=1) res+=dist[t];
			
			//Update
			for(int j=1;j<=n;j++) {
				if(!st[j]&&dist[j]>g[t][j])
					//如果改成dist[j]=min(dist[j],g[t][j])的话注意：不会影响最终答案，因为
					//对于已加入点，即使dist被更新了，但是它已经设置成 st 为true了，不会影响Scan
					dist[j]=g[t][j];
			}
		}
		
		return res;
	}

	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if(i==j) g[i][j]=0;
				else g[i][j] = INF;
			}
		}
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			g[a][b]=g[b][a]=Math.min(g[a][b], w);
		}
	}
}
