package algorithm.DFS;

import java.util.Scanner;

public class 马踏棋盘 {
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
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
	    dfs(1,1,1);
	    System.out.println(ans);
	}//main
	
	//解空间是二维数组visited,   cur代表第cur层，cur=n*n时结束
	public static void dfs(int x,int y,int cur) {
		//当前状态不合法
		//当前状态为目标状态
		if(cur==n*n) {
			ans++;
			visited[x][y]=cur;
			prinBoard();
			visited[x][y]=0;
			return;
		}
		//当前状态为中间合法状态
		visited[x][y]=cur;
		for(int i=0;i<8;i++) {
			if(isLegal(x+dir[i][0], y+dir[i][1])&&visited[x+dir[i][0]][y+dir[i][1]]==0)
				dfs(x+dir[i][0], y+dir[i][1], cur+1);
		}
		visited[x][y]=0;
	}
	
	
//	//解空间是二维数组visited,   cur代表第cur层，cur=n*n时结束
//	public static void dfs(int x,int y,int cur) {
//		//当前状态不合法
//		if(!isLegal(x, y)||visited[x][y]!=0) {
//			return;
//		}
//		//当前状态为目标状态
//		if(cur==n*n) {
//			ans++;
//			visited[x][y]=cur;
//			prinBoard();
//			visited[x][y]=0;
//			return;
//		}
//		//当前状态为中间合法状态
//		visited[x][y]=cur;
//		cur++;
//		for(int i=0;i<8;i++)
//			dfs(x+dir[i][0], y+dir[i][1], cur);
//		visited[x][y]=0;
//		
//	}
	
	public static boolean isLegal(int x,int y) {
		if(x<1||x>n||y<1||y>n)
			return false;
		return true;
	}
	public static void prinBoard() {
		System.out.println("第"+ans+"个");
		for (int i =1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
