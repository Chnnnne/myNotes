package AcWing.图论;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class P852_spfa判断负环 {

	public static final int MAXN = 2010;
	public static final int MAXM = 10010;
	public static final int INF = 0x3f3f3f3f;
	
	static int m,n;
	static int h[]=new int[MAXM],e[]=new int[MAXM],ne[]=new int[MAXM],w[]=new int[MAXM],idx=0;
	static int dist[]=new int[MAXN],cnt[]=new int[MAXN];
	static boolean st[]=new boolean[MAXN];
	public static void main(String[] args) {
		CreateGraph();
		if(spfa()) System.out.println("Yes");
		else System.out.println("No");

	}//main
	private static boolean spfa() {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i = 1; i <= n;i ++) {
			queue.offer(i);
			st[i]=true;
		}
		
		while(!queue.isEmpty()) {
			Integer t = queue.poll();
			st[t]=false;
			
			
			for(int i=h[t];i!=-1;i=ne[i]) {
				int j=e[i];
				if(dist[t]+w[i]<dist[j]) {
					dist[j]=dist[t]+w[i];
					cnt[j]=cnt[t]+1;
					if(cnt[j]>=n) return true;
					if(!st[j]) {
						st[j]=true;
						queue.offer(j);
					}
				}
			}
		}
		
		return false;
	}
	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		Arrays.fill(h, -1);
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int we = sc.nextInt();
			add(a,b,we);
		}
	}
	private static void add(int a, int b, int we) {
		e[idx]=b;
		w[idx]=we;
		ne[idx]=h[a];
		h[a]=idx++;
	}
}
