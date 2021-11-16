package AcWing.搜索;

import java.util.Scanner;

public class 马踏棋盘2 {
	static int MAXN=50;//棋盘长度最大值
	static int visited[][]=new int [MAXN+1][MAXN+1];
	
	static int n=0;//实际棋盘的长度，需要输入确定
	static int ans=0;//解的个数
	
	static int dir[][]=new int[][]{
		{1,2},
		{2,1},
		{2,-1},
		{1,-2},
		{-1,-2},
		{-2,-1},
		{-2,1},
		{-1,2}
		};
	
	public static void main(String[] args) {
		n = new Scanner(System.in).nextInt();
		dfs(1,1,1);
		System.out.println(ans/8);
	}//main
	
	static void dfs(int x,int y,int cur) {
		//目标情况
		//注意每个填满状态都进入了8次
		if(cur>n*n) {
			ans++;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					System.out.print(visited[i][j]+" ");
				}
				System.out.println();
			}
			return;
		}
		//非法情况
		if(!isLegal(x, y))
			return;
		visited[x][y]=cur;
		for(int i=0;i<8;i++) {
			dfs(x+dir[i][0], y+dir[i][1], cur+1);
		}
		visited[x][y]=0;
		
		
		
		
	}
	
	static boolean isLegal(int nextx, int nexty) {
		if(nextx<=0||nextx>n||nexty<=0||nexty>n)
			return false;
		if(visited[nextx][nexty]!=0)
			return false;
		return true;
	}
}
