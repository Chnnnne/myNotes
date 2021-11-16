package AcWing.图论;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 再敲_堆优化Dijkstra {
	
	public static final int INF = Integer.MAX_VALUE/3;
	public static final int MAXN = 150010;
	
	static int n,m;
	static int h[]=new int[MAXN],e[]=new int[MAXN],ne[]=new int[MAXN],w[]=new int[MAXN],idx=0;
	static int dist[]=new int[MAXN];
	static boolean st[]=new boolean[MAXN];
	
	public static void main(String[] args) {
		CreateGraph();
		int ans=Dijstra_heap();
		if(ans==-1) System.out.println("impossible");
		else System.out.println(ans);
	}//main

	private static int Dijstra_heap() {
		Arrays.fill(dist, INF);
		Arrays.fill(st, false);
		PriorityQueue<distance> heap = new PriorityQueue<distance>((o1,o2)->o1.dis-o2.dis);
		
		dist[1]=0;
		heap.offer(new distance(0, 1));
		
		while(!heap.isEmpty()) {
			//Scan
			distance t = heap.poll();
			int TempDis = t.dis, TempIdx = t.index;
			if(st[TempIdx]) continue;
			//Add
			st[TempIdx]=true;
			//Update
			for(int i = h[TempIdx] ; i!=-1;i=ne[i] ) {
				int j = e[i];
				if(!st[j]&&TempDis+w[i]<dist[j]) {
					dist[j]=TempDis+w[i];
					heap.offer(new distance(dist[j], j));
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
		Arrays.fill(h, -1);
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			add(a,b,w);
		}
	}

	private static void add(int a, int b, int w2) {
		e[idx]=b;
		w[idx]=w2;
		ne[idx]=h[a];
		h[a]=idx++;
	}
}
