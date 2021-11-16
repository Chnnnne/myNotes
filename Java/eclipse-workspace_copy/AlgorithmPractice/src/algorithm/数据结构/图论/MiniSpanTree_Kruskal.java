package algorithm.数据结构.图论;

import java.util.Arrays;
import java.util.Scanner;



class edge{
	int begin,end,weight;

	public edge(int begin, int end, int weight) {
		super();
		this.begin = begin;
		this.end = end;
		this.weight = weight;
	}
	
}

//
public class MiniSpanTree_Kruskal {
	
	public static final int MAXN = 20;
	static int n=0,m=0,cost=0;
	static edge edges[]=new edge[MAXN];
	static int parent[]=new int[MAXN];
	
	public static void main(String[] args) {
		CreateGraph();
		Kruskal();
		System.out.println("all cost:"+cost);
	}//main
	
	private static void Kruskal() {
		Arrays.fill(parent, -1);
		//遍历所有的边
		for (int i = 0; i < m; i++) {
			
			int root_be = Find(edges[i].begin);	//顶点begin所在的树(集合)的根x 
			int root_en = Find(edges[i].end);		//顶点end所在的树(集合)的根y
			
			//两点处于不同的集合中（连通分量）则合并之，（该边入选）
			if(root_be!=root_en) {
				parent[root_be]=root_en;
				System.out.println(edges[i].begin+"->"+edges[i].end);
				cost+=edges[i].weight;
			}
		}
	}

	private static int Find(int x) {
		int root_x=x;
		while(parent[root_x]!=-1) {
			root_x=parent[root_x];
		}
		return root_x;
	}

	//采用边集数组结构
	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the num of vertex and edges");
		n = sc.nextInt();
		m = sc.nextInt();
		System.out.println("enter the begin, end and weight");
		for (int i = 0; i < m; i++) {
			int begin = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();
			edges[i]=new edge(begin, end, weight); 
		}
		Arrays.sort(edges, 0, m, (o1,o2)->o1.weight-o2.weight);
	}
}
