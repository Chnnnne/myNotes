package AcWing.图论;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


class distance{
	int dis=-1;
	int index=-1;
	public distance(int dis, int index) {
		super();
		this.dis = dis;
		this.index = index;
	}
}

public class P850_Dijkstra求最短路2 {
	public static final int INF = Integer.MAX_VALUE/2;
	public static final int MAXN = 150010;
	static int n,m;
	static int h[]=new int[MAXN],e[]=new int[MAXN]
	,ne[]=new int[MAXN],w[]=new int[MAXN],
	idx=0;
	static int dist[]=new int[MAXN];
	static boolean st[]=new boolean[MAXN];
	
	
	public static void main(String[] args) {
		CreateGraph();
		int ans=Dijstra();
		System.out.println(ans);
	}//main

	private static int Dijstra() {
		//S1：初始化
		Arrays.fill(dist, INF);
		Arrays.fill(st, false);
		PriorityQueue<distance> heap = new PriorityQueue<distance>((o1,o2)->o1.dis-o2.dis);
		heap.offer(new distance(0, 1));
		dist[1]=0;
		//S2：
		//朴素的做法是：n次循环，每次循环找到一个顶点加入到集合中，for里干的事是Scan Add Update
		//堆优化的做法是：对堆进行循环  做的也是Scan Add Update,只不过Scan 改变了
		while(!heap.isEmpty()) {
			distance t = heap.poll();//O1的时间里找到了到V1最小距离的点,注意判定这个距离是不是有效的
			int TempIdx=t.index,TempDis=t.dis;
			//在堆中，中途会加入到某点很多不是最短的距离，这些到Vn的距离不是最短的，（因此是无效的）
			//但是有可能与其他点相比，它可能不是最短的，因此它会弹出栈，因此要根据visit跳过它。
			if(st[TempIdx]) continue;
			
			st[TempIdx]=true;//加入到已选点集合
			for(int i=h[TempIdx];i!=-1;i=ne[i]) {//O(mlogn)
				int j=e[i];
				if(!st[j]&&TempDis+w[i]<dist[j]) {
					dist[j]=TempDis+w[i];
					heap.offer(new distance(dist[j], j));
				}
			}
			
		}
		
		if(dist[n]==INF) return -1;//非连通
		else return dist[n];
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
