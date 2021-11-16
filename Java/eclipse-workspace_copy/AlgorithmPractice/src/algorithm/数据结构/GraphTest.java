package algorithm.数据结构;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/*
8 7
0 1
0 2
1 3
1 4
3 5
4 5
6 7
 */
public class GraphTest {
	public static void main(String[] args) {
		int graph[][]=CreateGraph();
		int visited[]=new int[graph.length];
//由于图可能是非连通图，因此使用循环，一次循环完成一个连通子图的DFS遍历或BFS遍历
		System.out.println("DFS");
		for(int i=0;i<graph.length;i++) {
			if(visited[i]==0)
				DFS(i,graph,visited);
		}
		System.out.println(Arrays.toString(visited));
		System.out.println("BFS");
		Arrays.fill(visited, 0);
		for(int i=0;i<graph.length;i++) {
			if(visited[i]==0)
				BFS(i,graph,visited);
		}
	}//main

	//以前
	static void BFS(int i, int[][] graph, int[] visited) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[i]=1;
		queue.offer(i);
		while(!queue.isEmpty()) {
			Integer poll= queue.poll();
			System.out.println("我访问了节点"+poll);
			for(int j=0;j<graph.length;j++) {
				if(visited[j]==0&&graph[poll][j]==1) {
					visited[j]=1;
					queue.offer(j);
				}
			}
		}
	}

	//注意以前做的DFS题是得到树的所有解(因此需要遍历每一条路径,也即设置visit取消visit)，
	//现在遍历一个图，只需要访问到这个点就行了，因此回溯时，不需要取消visit
	static int step=1;
	static void DFS(int i, int[][] graph, int[] visited) {
		System.out.println("我现在访问结点"+i+"了");
		visited[i]=step;
		step++;
		for(int j=0;j<graph.length;j++) {
			if(visited[j]==0&&graph[i][j]!=0)//连通且没被访问过
				DFS(j, graph, visited);
		}
	}
	
	
	


	/*
	 * 创建无向图，邻接矩阵表示法
	 */
	static int[][] CreateGraph() {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();//顶点的数量
		int m=sc.nextInt();//边的数量
		int graph[][]=new int[n][n];
		for(int i= 0;i<m;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			graph[x][y]=1;
			graph[y][x]=1;
		}
		return graph;
	}
}
