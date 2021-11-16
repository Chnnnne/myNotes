package AcWing.图论;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;



public class P847_图中点的层次 {

	
	public static final int MAXN = 100010;
	static int n,m;
	static int h[]=new int[MAXN],e[]=new int[MAXN],ne[]=new int[MAXN],idx=0;
	static int step[]=new int[MAXN];//step[i]=value代表第i个结点是在第value步遍历到的
	static boolean visited[]=new boolean[MAXN];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		Arrays.fill(h, -1);
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			Add(a, b);
		}
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[1]=true;
		step[1]=0;
		queue.offer(1);
		while(!queue.isEmpty()) {
			Integer poll = queue.poll();
			
			if(poll==n) {
				System.out.println(step[poll]);
				return;
			}
			
			int s=step[poll]+1;
			for(int j=h[poll];j!=-1;j=ne[j]) {
				if(!visited[e[j]]) {
					visited[e[j]]=true;
					step[e[j]]=s;
					queue.offer(e[j]);
				}
			}
		}
		System.out.println(-1);
		
	}//main
	
	static void Add(int a,int b) {
		e[idx]=b;
		ne[idx]=h[a];
		h[a]=idx++;
	}
}
