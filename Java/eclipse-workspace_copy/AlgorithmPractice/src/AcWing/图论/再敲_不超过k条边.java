package AcWing.图论;

import java.util.Arrays;
import java.util.Scanner;

public class 再敲_不超过k条边 {
	static final int INF =Integer.MAX_VALUE/3;
	static final int MAXN=510;
	static final int MAXM=10010;
	
	static int n,m,k;
	static edge edges[]=new edge[MAXN];
	static int dist[]=new int[MAXN],
			backup[]=new int [MAXN];
	
	
	public static void main(String[] args) {
		CreatGraph();
		int ans=Bellman_Ford();
		if(ans==-1) System.out.println("impossible");
		else System.out.println(ans);

	}//main


	private static int Bellman_Ford() {
		Arrays.fill(dist, INF);
		dist[1]=0;
		
		for(int i=0;i<k;i++) {
			System.arraycopy(dist, 0, backup, 0, dist.length);
			for(int j=0;j<m;j++) {
				int a = edges[j].a;
				int b = edges[j].b;
				int w = edges[j].w;
				dist[b]=Math.min(dist[b], backup[a]+w);
			}
		}
		if(dist[n]>INF/2) return -1;
		else return dist[n];
		
	}


	private static void CreatGraph() {
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
}
