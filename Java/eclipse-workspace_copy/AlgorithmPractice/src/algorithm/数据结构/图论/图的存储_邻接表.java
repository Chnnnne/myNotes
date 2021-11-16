package algorithm.数据结构.图论;

import java.util.Scanner;

class node{
	int val=-1;
	node next=null;
	public node(int val) {
		super();
		this.val = val;
	}
	@Override
	public String toString() {
		return "   [val=" + val + "]    ";
	}
	
}

public class 图的存储_邻接表 {
	static final int MAXN=20;
	static int n;
	static int m;
	static node []graph=new node[MAXN];
	public static void main(String[] args) {
		CreateGraph();
		
		//输出
		for (int i = 0; i < n; i++) {
			node temp=graph[i];
			System.out.println("第"+i+"个结点的链表:");
			while(temp!=null) {
				System.out.println(temp);
				temp=temp.next;
			}
		}
		
	}//main
	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();//顶点数
		m = sc.nextInt();//边数
		
		
		for(int i=0;i<n;i++) {
			graph[i]=new node(i);
		}
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			node ver = new node(y);//头插法
			ver.next=graph[x].next;
			graph[x].next=ver;
		}
	}
	
	
}
