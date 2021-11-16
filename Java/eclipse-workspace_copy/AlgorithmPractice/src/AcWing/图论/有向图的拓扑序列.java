package AcWing.图论;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class 有向图的拓扑序列 {
	static final int MAXN = 100010;
	static int n,m;
	static int h[]=new int[MAXN],e[]=new int[MAXN],
			ne[]=new int[MAXN],in[]=new int[MAXN]
					,idx=0,count=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		Arrays.fill(h, -1);
		for (int i = 0; i < m; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			Add(x,y);
			in[y]++;
		}
		
		//bfs寻找拓扑序列
		ArrayList<Integer> al = new ArrayList<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		//入度为0的点进队
		for (int i = 1; i <= n; i++) {
			if(in[i]==0) queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			//出队并输出入度为0的点，并执行删除操作
			Integer poll = queue.poll();
			al.add(poll);
			count++;
			for(int j=h[poll];j!=-1;j=ne[j]) {
				if((--in[e[j]])==0) {
					queue.offer(e[j]);
				}
			}
		}
		if(count==n) {
			al.forEach(i->System.out.print(i+" "));
		}else {
			System.out.println(-1);
		}
		
	}//main
	private static void Add(int x, int y) {
		e[idx]=y;
		ne[idx]=h[x];
		h[x]=idx++;
	}
}
