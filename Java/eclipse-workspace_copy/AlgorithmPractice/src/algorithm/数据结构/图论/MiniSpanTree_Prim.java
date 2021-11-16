package algorithm.数据结构.图论;

import java.util.Scanner;

public class MiniSpanTree_Prim {
	public static final int MAXN = 20;
	public static final int INF =Integer.MAX_VALUE;
	static int graph[][]=new int[MAXN+1][MAXN+1];
	static int n=0;
	static int m=0;
	static int cost=0;
	
	public static void main(String[] args) {
		CreateGraph();
		Prim();
		System.out.println("all cost:"+cost);
	}//main

	private static void Prim() {
		//S1:定义变量
		int lowcost[]=new int[MAXN];//存放从当前U中顶点到U-V中顶点的最小权值
		int adjvex[]=new int[MAXN];//配合lowcost数组，指定对应的U中的顶点
		//S2:初始化
		lowcost[1]=0;//将第一个顶点加入到U中
		for(int i=2;i<=n;i++) {
			lowcost[i]=graph[1][i];
			adjvex[i]=1;
		}
		
		//S3:开始寻找这n-1条边
		for(int i=1;i<=n-1;i++) {
			
			int min=INF;
			int k=0;
			//S3.1:寻找最小边
			for(int j=1;j<=n;j++) {
				if(lowcost[j]!=0&&lowcost[j]<min) {
					min=lowcost[j];
					k=j;
				}
			}
			//S3.2:k加入到U
			System.out.println(adjvex[k]+"->"+k);
			cost+=min;
			lowcost[k]=0;//k点加入到U
			//S3.3:k点加入到U之后，更新
			for(int j=1;j<=n;j++) {
				if(lowcost[j]!=0&&graph[k][j]<lowcost[j]) {
					lowcost[j]=graph[k][j];
					adjvex[j]=k;
				}
			}
			
			
		}
		
		
	}

	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the num of vertex and edges!");
		n = sc.nextInt();//顶点数量
		m = sc.nextInt();//边的数量
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=n;j++) {
				if(i==j) graph[i][i]=0;
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
	
	
	private static void Prim1() {
		//S1:定义
		int lowcost[]= new int[MAXN];
		int adjvex[]= new int [MAXN];
		//S2:初始化
		lowcost[1]=0;
		for(int i=2;i<n;i++) {
			lowcost[i]=graph[1][i];
			adjvex[i]=1;
		}
		//S3:寻找这n-1条边
		for(int i=1;i<=n-1;i++) {
			int min=INF;
			int k=0;
			//S3.1:寻找最小边
			for(int j=1;j<=n;j++) {
				if(lowcost[j]!=0&&lowcost[j]<min) {
					min=lowcost[j];
					k=j;
				}
			}
			
			//S3.2:k加入到U
			lowcost[k]=0;
			cost+=min;
			System.out.println();
			//S3.3:k加入之后，更新
			for(int j=1;j<=n;j++) {
				if(lowcost[j]!=0&&graph[k][j]<lowcost[j])
				{
					lowcost[j]=graph[k][j];
					adjvex[j]=k;
				}
			}
			
			
		}
		
		
		
		
	}
}
