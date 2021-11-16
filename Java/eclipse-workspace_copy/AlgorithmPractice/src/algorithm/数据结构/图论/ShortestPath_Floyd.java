package algorithm.数据结构.图论;

import java.util.Scanner;


public class ShortestPath_Floyd {
	public static final int MAXN = 20;
	public static final int INF = Integer.MAX_VALUE/10;//出现加法，防止溢出
	static int n,m;//点 边
	static int graph[][]=new int[MAXN][MAXN];
	static int d[][]=new int[MAXN][MAXN];		//存两个顶点之间的最短路径长度
	static int p[][]=new int[MAXN][MAXN];		//存两个顶点最短路径，对应的前驱节点
	public static void main(String[] args) {
		CreateGraph();
		Floyd();
	}//main
	
	private static void Floyd() {
		//初始化
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				d[i][j]=graph[i][j];
				p[i][j]=j;		//注意此处
			}
		}
		//三重循环
		for (int k = 0; k < n; k++) {
			for(int v = 0; v < n; v++) {
				for(int w = 0; w < n; w++) {//从v到w途径k结点
					if(d[v][w]>d[v][k]+d[k][w]) { //考虑特殊情况：途径点和起末点相同、
						d[v][w]=d[v][k]+d[k][w];
						p[v][w]=p[v][k];
					}
				}
			}
		}
		
		
		//展示
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(d[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("\n\n");
		System.out.println(0+" "+1+" "+2+" "+3+" "+4+" "+5+"\n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(p[i][j]+" ");
			}
			System.out.println();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("从"+i+"到"+j+"最短路的路径是：");
				int temp=p[i][j];//1
				System.out.print(i+" ");
				while(p[temp][j]!=j) {
					System.out.print(temp+" ");
					temp=p[temp][j];
				}
				System.out.println(temp+" "+j);
			}
		}
		
		
		
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
