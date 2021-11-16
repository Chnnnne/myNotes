package algorithm.数据结构.图论;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;


class mynode{
	int val=-1,in=0;
	mynode next=null;
	public mynode(int val) {
		super();
		this.val = val;
	}
}

public class 拓扑排序 {
	static final int MAXN=20;
	static int n;
	static int m;
	static int count=0;
	static mynode []head=new mynode[MAXN];
	
	public static void main(String[] args) {
		CreateGraph();
		System.out.println("\n展示图:");
		for (int i = 0; i < n; i++) {
			System.out.print("顶点"+i+" "+"入度是"+head[i].in+"   ");
			mynode temp=head[i].next;
			while(temp!=null) {
				System.out.print(temp.val+" ");
				temp=temp.next;
			}
			System.out.println();
		}
		
		TuoPu();
	}//main
	
	
	private static void TuoPu() {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		//S1:初始化,in=0的入栈
		for(int i=0;i<n;i++) {
			if(head[i].in==0) stack.push(i);
		}
		while(!stack.isEmpty()) {
			//S2:不断删除in为0的节点
			Integer pop = stack.pop();
			System.out.print(pop+" ");
			count++;
			
			//S3:更新
			mynode temp=head[pop].next;
			while(temp!=null) {
				if(--head[temp.val].in==0) {
					stack.push(temp.val);
				}
				temp=temp.next;
			}
		}
		if(count<n) System.out.println("Cycle detected");
		else System.out.println("there is no cycle");
	}


	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the num of vertex and edges");
		n = sc.nextInt();//顶点数
		m = sc.nextInt();//边数
		System.out.println("enter the edges");
		
		for(int i=0;i<n;i++) {
			head[i]=new mynode(i);
		}
		//有向图
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();//弧尾
			int y = sc.nextInt();//弧头
			mynode ver = new mynode(y);//头插法
			ver.next=head[x].next;
			head[x].next=ver;
			head[y].in++;//弧头入度加一
		}
	}
}
