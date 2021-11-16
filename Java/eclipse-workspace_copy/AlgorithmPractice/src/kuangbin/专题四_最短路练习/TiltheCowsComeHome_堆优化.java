package kuangbin.专题四_最短路练习;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


class distance{
	int dis=0;
	int index=0;
	public distance(int dis, int index) {
		super();
		this.dis = dis;
		this.index = index;
	}
}

public class TiltheCowsComeHome_堆优化 {
	public static final int MAXN = 1010;
	public static final int MAXM = 2010;
	public static final int INF = Integer.MAX_VALUE/3;
	static int n,m;
	
	static int h[]=new int[MAXN],e[]=new int[MAXM]
			,ne[]=new int[MAXN],w[]=new int[MAXN],idx=0;
	
	static int dist[]=new int[MAXN];
	static boolean st[]=new boolean[MAXN]; 
	public static void main(String[] args) {
		CreateGraph();
		int ans=Dijkstra();
		System.out.println(ans);
	}//main
	
	
	private static int Dijkstra() {
		Arrays.fill(dist, INF);
		PriorityQueue<distance> heap = new PriorityQueue<distance>((o1,o2)->o1.dis-o2.dis);
		
		heap.offer(new distance(0, 1));
		dist[1]=0;
		while(!heap.isEmpty()) {
			//Scan
			distance t = heap.poll();
			int TempDis=t.dis,TempIdx=t.index;
			
			if(st[TempIdx]) continue;
			//Add
			st[TempIdx]=true;
			//Update 途径TempIdx
			for(int i=h[TempIdx];i!=-1;i=ne[i]) {
				int j=e[i];
				if(!st[j]&&dist[TempIdx]+w[i]<dist[j]) {
					dist[j]=dist[TempIdx]+w[i];
					heap.offer(new distance(dist[j], j));
				}
			}
		}
		
		return dist[n];
	}


	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		Arrays.fill(h, -1);
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int wet = sc.nextInt();
			add(a,b,wet);
			add(b,a,wet);
		}
	}
	
	private static void add(int a, int b, int wet) {
		e[idx]=b;
		w[idx]=wet;
		ne[idx]=h[a];
		h[a]=idx++;
	}
}
