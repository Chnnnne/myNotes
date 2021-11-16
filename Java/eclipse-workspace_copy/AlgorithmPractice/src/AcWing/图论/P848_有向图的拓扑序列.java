package AcWing.图论;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


class node{
	int val=-1;
	int in=0;
	node next=null;
	public node(int val) {
		super();
		this.val = val;
	}
}

public class P848_有向图的拓扑序列 {
	public static final int MAXN = 100010;
	static int n,m;
	static int count=0;
	static node head[]=new node[MAXN];
	public static void main(String[] args) {
		CreateGraph();
		TuoPu();
	}//main
	private static void TuoPu() {
		ArrayList<Integer> res = new ArrayList<Integer>();
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			if(head[i].in==0) stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			Integer pop = stack.pop();
			count++;
			res.add(pop);
			//删除pop节点之后，更新入度
			node temp=head[pop].next;
			while(temp!=null) {
				if(--head[temp.val].in==0) 
					stack.push(temp.val);;
				temp=temp.next;
			}
		}
		if(count==n) {
			for(int i=0;i<n-1;i++) {
				System.out.print(res.get(i)+" ");
			}
			System.out.print(res.get(n-1));
		}
		else System.out.println(-1);
	}
	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			head[i]= new node(i);
		}
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			node ver = new node(y);
			ver.next=head[x].next;
			head[x].next=ver;
			head[y].in++;
		}
	}
}
