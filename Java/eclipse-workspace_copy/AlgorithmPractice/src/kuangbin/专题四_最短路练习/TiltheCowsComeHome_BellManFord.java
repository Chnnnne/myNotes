package kuangbin.专题四_最短路练习;


import java.util.Arrays;
import java.util.Scanner;

class edge{
	int a,b,w;

	public edge(int a, int b, int w) {
		super();
		this.a = a;
		this.b = b;
		this.w = w;
	}
}

public class TiltheCowsComeHome_BellManFord {
	public static final int MAXN = 5000;
	public static final int INF = Integer.MAX_VALUE/2;
	
	static int n,m;
	static edge edges[]=new edge[MAXN];
	static int dist[]=new int[MAXN];
	static int backup[]=new int[MAXN];
	
	public static void main(String[] args)  {
		CreateGraph();
		int ans = BellManFord();
		System.out.println(ans);
	}//main

	private static int BellManFord() {
		Arrays.fill(dist, INF);
		dist[1]=0;
		
		for(int i=0;i<n;i++) {
			System.arraycopy(dist, 0, backup, 0, dist.length-1);
			for(int j=0;j<m*2;j++) {
				int a=edges[j].a;
				int b=edges[j].b;
				int w=edges[j].w;
				dist[b]=Math.min(dist[b], backup[a]+w);
			}
		}
		
		return dist[n];
	}

	private static void CreateGraph()  {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		for (int i = 0; i < m*2; i++) {
			int a =sc.nextInt();
			int b =sc.nextInt();
			int w =sc.nextInt();
			edges[i]=new edge(a, b, w);
			edges[++i]=new edge(b, a, w);
		}
	}
}
