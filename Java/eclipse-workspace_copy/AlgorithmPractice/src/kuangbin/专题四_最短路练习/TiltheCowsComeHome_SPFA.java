package kuangbin.专题四_最短路练习;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class TiltheCowsComeHome_SPFA {
	public static final int MAXN = 5000;
	public static final int INF = Integer.MAX_VALUE/3;
	static int n,m;
	
	static int h[]=new int[MAXN],e[]=new int[MAXN]
			,ne[]=new int[MAXN],w[]=new int[MAXN],idx=0;
	static int dist[]=new int[MAXN];
	static boolean st[]=new boolean[MAXN];
	
	public static void main(String[] args)  {
		CreateGraph();
		int ans=spfa();
		System.out.println(ans);

	}//main

	private static int spfa() {
		Arrays.fill(dist, INF);
		Arrays.fill(st, false);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		dist[1]=0;
		queue.offer(1);
		st[1]=true;
		while(!queue.isEmpty()) {
			Integer t = queue.poll();//变小了的a出栈
			st[t]=false;
			
			for(int i=h[t];i!=-1;i=ne[i]) {
				int j = e[i];
				if(dist[t]+w[i]<dist[j])
				{
					dist[j]=dist[t]+w[i];
					if(!st[j]) {
						queue.offer(j);
						st[j]=true;
					}
				}
			}
		}
		return dist[n];
	}

	private static void CreateGraph()  {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		Arrays.fill(h, -1);
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			add(a,b,w);
			add(b,a,w);
		}
	}

	private static void add(int a, int b, int w2) {
		e[idx]=b;
		w[idx]=w2;
		ne[idx]=h[a];
		h[a]=idx++;
	}
}
