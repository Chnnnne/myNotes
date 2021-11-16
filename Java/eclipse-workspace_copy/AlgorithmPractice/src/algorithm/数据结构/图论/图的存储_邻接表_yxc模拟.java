package algorithm.数据结构.图论;

import java.util.Arrays;
import java.util.Scanner;


public class 图的存储_邻接表_yxc模拟 {
	
	public static final int MAXN = 50;
	static int n,m;
	static int h[]=new int [MAXN],e[]=new int [MAXN],ne[]=new int [MAXN],idx=0;
	public static void main(String[] args) {
		CreateGraph();
		System.out.println("\n\n输出图");
		for (int i = 0; i < n; i++) {
			System.out.print("顶点"+i+":  ");
			int temp=h[i];
			while(temp!=-1) {
				System.out.print(e[temp]+" ");
				temp=ne[temp];
			}
			System.out.println();
		}
	}
	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the num of vertex and edges!");
		n = sc.nextInt();//顶点数量
		m = sc.nextInt();//边的数量
		
		Arrays.fill(h, -1);
		
		System.out.println("enter the edges!");
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			Add(x,y);
			Add(y,x);
		}
		
	}//main
	
	/*
	 	需要有顶点数组，弧节点
	 	idx弧节点索引
		e数组存的是弧节点
		ne存的是弧节点的链接关系
		h存的是头结点数组
	 */
	private static void Add(int a, int b) {
		e[idx]=b;//弧节点,一个弧节点就能代表一个边了，因为他要和头结点绑定呢
		ne[idx]=h[a];	//弧节点的下一个节点
		h[a]=idx++;
	}
}
