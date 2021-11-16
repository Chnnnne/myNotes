package algorithm.数据结构.图论;

import java.math.BigDecimal;
import java.util.Scanner;


/*

6 9
0 1 1
0 2 12
1 2 9
1 3 3
2 3 4
2 4 5
4 3 13
3 5 15
4 5 4
*/
/*
模板思路:
Dijkstra是求单源最短路算法，也即从v0到其他各点的最短路
三个数组 visited,dist,parent 
主要的三个步骤是 Scan Add Update
Scan:寻找当前未选数组到V0中最短的那一个顶点k
Add:将该点k加入到已入选数组中
Update:途径k点到其他顶点的距离是否
*/
public class ShortestPath_Dijkstra {
	
	public static final int MAXN = 20;
	public static final int INF = Integer.MAX_VALUE-1000;//加法可能存在溢出
	static int n,m;//顶点的数量 和 边的数量
	static int graph[][]=new int[MAXN][MAXN];
	
	public static void main(String[] args) {
		CreateGraph();
		Dijkstra();
	}//main
	
	private static void Dijkstra() {
		//S1:定义变量
		boolean visited[]=new boolean[MAXN];//决定某点是否入选已选点集合 
		int dist[]=new int[MAXN];		//从V0到某点的最短距离
		int parent[]=new int [MAXN];	//到某点的最短路径中，该点的上一个结点
		//S2:初始化
		for (int i = 0; i < n; i++) {
			visited[i]=false;
			dist[i]=INF;
			parent[i]=-1;
		}
		//S3:加入v0
		dist[0]=0;
		visited[0]=true;
		for (int i = 1; i < n; i++) {
			dist[i]=graph[0][i];
			parent[i]=0;
		}
		
		//S4:n-1次循环，每次找到一个从v0到某个vertex的最短路径
		for(int i = 1; i <= n-1; i++) {
			//S4.1:寻找当前某个未入选的点，该点到v0的距离最短
			int min=INF/2;
			int k=-1;
			for (int j = 0; j < n; j++) {
				if(!visited[j]&&dist[j]<min) {
					min=dist[j];
					k=j;
				}
			}
			
			//S4.2:把找到的该点加入到已选点的集合中取
			visited[k]=true;
			System.out.println(k+"加入到已选点集合!");
			
			//S4.3:更新通过该点到其他未入选点的距离，看是否更小
			for (int j = 0; j < n; j++) {
				if(!visited[j]&&min+graph[k][j]<dist[j]) {
					dist[j]=min+graph[k][j];
					parent[j]=k;
				}
			}
		}
		
		
		
		
		//查询
		for (int i = 0; i < n; i++) {
			System.out.println("从v0顶点到"+i+"顶点的最短距离是"+dist[i]);
		}
		System.out.println("the vertex in the path from 0 to 5:");
		PrinLastOne(5,parent);	
	}

	private static void PrinLastOne(int i, int[] parent) {
		if(parent[i]!=-1)
			PrinLastOne(parent[i], parent);
		System.out.print(i+" ");
	}

	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the num of vertex and edges!");
		n = sc.nextInt();//顶点数量
		m = sc.nextInt();//边的数量
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) graph[i][j]=0;
				else
					graph[i][j]=INF;
			}
		}
		System.out.println("enter the edges and weight");
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int weight = sc.nextInt();
			graph[x][y]=weight;
			graph[y][x]=weight;
		}
	}
}
