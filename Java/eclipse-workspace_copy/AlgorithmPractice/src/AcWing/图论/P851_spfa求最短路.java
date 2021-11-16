package AcWing.图论;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class P851_spfa求最短路 {
	public static final int INF = Integer.MAX_VALUE/2;
	public static final int MAXN = 150010;
	static int n,m;
	static int h[]=new int[MAXN],e[]=new int[MAXN],ne[]=new int[MAXN],w[]=new int[MAXN],idx=0;
	static int dist[]=new int[MAXN];
	static boolean st[]=new boolean[MAXN];//某个点是否被访问过
	
	
	public static void main(String[] args) {
		CreateGraph();
		int ans=spfa();
		if(ans==-1) System.out.println("impossible");
		else System.out.println(ans);
	}//main

	private static int spfa() {
		Arrays.fill(dist, INF);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		dist[1]=0;
		queue.offer(1);
		st[1]=true;//进队的都是更新了距离的节点号，设为true
		
		while(!queue.isEmpty()) {
			Integer t = queue.poll();
			st[t]=false;
			
			for(int i=h[t];i!=-1;i=ne[i]) {
				int j = e[i];
				if(dist[t]+w[i]<dist[j] ) {
					dist[j]=dist[t]+w[i];
					if(!st[j]) {
						queue.offer(j);
						st[j]=true;
					}
				}
			}
		}
		
		if(dist[n]==INF) return -1;
		return dist[n];
	}


	private static void add(int a, int b, int weight) {
		e[idx]=b;
		w[idx]=weight;
		ne[idx]=h[a];
		h[a]=idx++;
	}
	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		Arrays.fill(h, -1);
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int weight = sc.nextInt();
			add(a,b,weight);//用邻接表 有重边也没事，算法会考虑
		}
	}
}