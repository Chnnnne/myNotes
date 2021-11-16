package AcWing.搜索;

import java.util.Arrays;

import java.util.Scanner;
import java.util.TreeSet;


public class P843_n皇后问题 {
	static int n;
	static final int MAXN=20;
	static char g[][]=new char[MAXN+1][MAXN+1];//棋盘
	static boolean row[]=new boolean[MAXN];
	static boolean col[]=new boolean[MAXN];
	static boolean mdg[]=new boolean[MAXN*2];
	static boolean udg[]=new boolean[MAXN*2];
	static int s=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++) {
				g[i][j]='.';
			}
		dfs(1,1,1);
	}//main
	
	
	//第cur步访问(x,y)
	static void dfs(int cur,int x,int y) {
		//目标状态
		if(cur>n*n) {
			if(s==n) {
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++) {
						System.out.print(g[i][j]);
					}
					System.out.println();
				}
				System.out.println();
			}
			return;
		}
		
		//合法状态
		int nextx=x;
		int nexty=y;
		if(nexty==n) {
			nextx++;
			nexty=1;
		}
		else {
			nexty++;
		}
		//选上
		if(!row[x]&&!col[y]&&!mdg[y-x+MAXN]&&!udg[x+y]) {
			s++;
			g[x][y]='Q';
			row[x]=true;
			col[y]=true;
			mdg[y-x+MAXN]=true;
			udg[x+y]=true;
			dfs(cur+1, nextx, nexty);
			s--;
			g[x][y]='.';
			row[x]=false;
			col[y]=false;
			mdg[y-x+MAXN]=false;
			udg[x+y]=false;
		}
		//不选
		dfs(cur+1, nextx, nexty);
	}
}
