package AcWing.搜索2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;



public class n皇后 {
	public static final int MAXN = 20;
	static int n;
	static int s;
	static char g[][]=new char[MAXN][MAXN];
	static boolean row[]=new boolean[MAXN];
	static boolean col[]=new boolean[MAXN];
	static boolean mdg[]=new boolean[MAXN+MAXN];
	static boolean udg[]=new boolean[MAXN+MAXN];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		init();
		dfs(1, 1, 1);
	}//main
	
	
	
	static void init() {
		Arrays.fill(row, false);
		Arrays.fill(col, false);
		Arrays.fill(mdg, false);
		Arrays.fill(udg, false);
		for(int i=0;i<MAXN;i++) {
			for(int j=0;j<MAXN;j++) {
				g[i][j]='.';
			}
		}
		s=0;
	}



	//解空间是填写一个二维数组g[][]，类似二叉树 第cur步访问第(x,y)
	static void dfs(int x,int y,int cur) {
		//目标状态
		if(cur>n*n) {
			if(s==n) {
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=n;j++)
					{
						System.out.print(g[i][j]);
					}
					System.out.println();
				}
				System.out.println();
			}
			return;
		}
		
		//合法状态
		int nextx=x,nexty=y;
		if(nexty==n) {
			nexty=1; nextx++;
		}
		else nexty++;
		
		//1选第cur个位置(x,y)作为皇后
		if(!row[x]&&!col[y]&&!mdg[y-x+MAXN]&&!udg[x+y]) {
			s++;g[x][y]='Q';row[x]=true;col[y]=true; mdg[y-x+MAXN]=true; udg[x+y]=true;
			dfs(nextx, nexty, cur+1);
			s--;g[x][y]='.';row[x]=false;col[y]=false; mdg[y-x+MAXN]=false; udg[x+y]=false;
			
		}
		
		//2不选第cur个位置(x,y)作为皇后
		dfs(nextx, nexty, cur+1);
		
	}
	
	
	
}
