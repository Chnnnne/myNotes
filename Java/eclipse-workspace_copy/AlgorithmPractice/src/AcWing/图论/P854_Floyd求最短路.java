package AcWing.图论;

import java.util.Scanner;

public class P854_Floyd求最短路 {
	public static final int INF = Integer.MAX_VALUE/3;
	public static final int MAXN = 210;
	public static final int MAXM = 10010;
	static int n,m,k;
	static int d[][]=new int[MAXN][MAXN];
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		CreateGraph();
		Flod();
		//Query
		while(k--!=0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(d[a][b]>INF/2) System.out.println("impossible");
			else System.out.println(d[a][b]);
		}

	}//main

	private static void Flod() {
		for(int k=1;k<=n;k++)
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					d[i][j]=Math.min(d[i][j], d[i][k]+d[k][j]);
	}

	private static void CreateGraph() {
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		for (int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == j) d[i][j]=0;
				else d[i][j]=INF;
			}
		}
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			d[a][b]=Math.min(d[a][b], w);
		}
	}
}
