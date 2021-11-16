package AcWing.图论;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class P859_Kruskal算法求最小生成树 {
	public static final int MAXN = 100010; 
	public static final int MAXM = 200010;
	static int m,n;
	
	static edge edges[]=new edge[MAXM];
	static int parent[]=new int[MAXN];
	static int rank[]=new int[MAXN];
	public static void main(String[] args) throws IOException {
		CreateGraph();
		int ans = Kruskal();
		if(ans == -1) System.out.println("impossible");
		else System.out.println(ans);

	}//main
	private static int Kruskal() {
		int res=0,cnt=0;
		for(int i = 0; i < m; i++) {
			int a = edges[i].a;
			int b = edges[i].b;
			int w = edges[i].w;
			int root_a = find_root(a);
			int root_b = find_root(b);
			if(root_a != root_b) {
				cnt++;
				res += w;
				if(rank[root_a]>rank[root_b])
				{
					parent[root_b]=root_a;
				}
				else if (rank[root_a]<rank[root_b]) {
					parent[root_a]=root_b;
				}else {
					parent[root_a]=root_b;
					rank[root_b]++;
				}
			}
		}
		if(cnt<n-1) return -1;
		return res;
	}
	private static int find_root(int a) {
		while(parent[a] != -1) {
			a = parent[a];
		}
		return a;
	}
	private static void CreateGraph() throws IOException {
		n = Reader.nextInt();
		m = Reader.nextInt();
		for (int i = 0; i < m; i++) {
			int a = Reader.nextInt();
			int b = Reader.nextInt();
			int w = Reader.nextInt();
			edges[i] = new edge(a, b, w);
		}
		Arrays.sort(edges, 0, m);
		Arrays.fill(parent, -1);
	}
}
