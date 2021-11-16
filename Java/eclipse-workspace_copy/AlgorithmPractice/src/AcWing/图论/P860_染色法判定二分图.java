package AcWing.图论;

import java.util.Arrays;
import java.util.Scanner;

public class P860_染色法判定二分图 {

	public static final int MAXN = 100010;
	public static final int MAXM = 200010;
	
	static int n,m;
	static int e[]=new int[MAXM],h[]=new int[MAXN],ne[]=new int[MAXM],idx=0;
	static int color[]=new int[MAXN];
	static boolean flag = true;
	
	public static void main(String[] args) {
		CreateGraph();
		for(int i = 1; i <= n; i++ ) {
			if(flag) {
				if(color[i]==0) {
					dfs(i,1);
				}
			}else {
				break;
			}
		}
		if(!flag) System.out.println("No");
		else System.out.println("Yes");
	}//main

	private static void dfs(int idx, int c) {
		if(!flag) return;
		color[idx] = c;
		
		for(int i = h[idx]; i != -1 ; i = ne[i]) {
			int j = e[i];
			if(color[j] == 0)
				dfs(j, 3-c);
			else if(color[j] == c)
				flag = false;
		}
	}

	private static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		Arrays.fill(h, -1);
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			add(a, b);
			add(b, a);
		}
	}

	private static void add(int a, int b) {
		e[idx] = b;
		ne[idx] = h[a];
		h[a] = idx++;
	}
}
