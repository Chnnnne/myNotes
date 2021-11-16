package AcWing.图论;

import java.util.Arrays;
import java.util.Scanner;

class edge implements Comparable<edge>{
	int a,b,w;

	public edge(int a, int b, int w) {
		super();
		this.a = a;
		this.b = b;
		this.w = w;
	}

	@Override
	public int compareTo(edge o) {
		return this.w-o.w;
	}
	
}

public class P853_有边数限制的最短路 {
	public static final int INF = Integer.MAX_VALUE/2;
	public static final int MAXN = 510;
	public static final int MAXM = 10010;
	static int n,m,k;//n个顶点  m条边   不超过k条边
	static edge edges[]=new edge[MAXM];
	static int dist[]=new int[MAXN],backup[]=new int[MAXN];//备份数组
	
	
	public static void main(String[] args) {
		CreateGraph();
		int ans=bellman_ford();
		if(ans==-1) System.out.println("impossible");
		else System.out.println(ans);
	}//main


	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			edges[i]=new edge(a, b, w);
		}
	}


	private static int bellman_ford() {
		Arrays.fill(dist, INF);
		dist[1]=0;
		
		//经过不超过k条边，因此是k次迭代
		for(int i=0;i<k;i++) {
			//防止串联，因此备份
			System.arraycopy(dist, 0, backup, 0, dist.length);
			for(int j = 0;j < m; j ++) {
				int a = edges[j].a;
				int b = edges[j].b;
				int w = edges[j].w;
				dist[b]=Math.min(dist[b], backup[a]+w);
			}
		}
		if(dist[n] > INF/2) return -1;
		else return dist[n];
	}
}
