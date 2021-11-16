package algorithm.DFS;

import java.util.Scanner;


//给定一个图(由节点组成),然后判断能用几种颜色把它填满(相邻的区域不能一样的颜色)
public class 图着色问题 {


	public static final int MAXN = 30;//图的最大节点数
	
	static boolean Graph[][]=new boolean[MAXN+1][MAXN+1];
	static int flag[]=new int[MAXN+1];//flag[i]的值value 代表第i个结点涂的是第value色
	static boolean CanDraw=false;
	
	static int n,m;//n个结点 m条边
	static int Min;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//n个结点 m条边
		n=sc.nextInt();
		m=sc.nextInt();
		CreateGraph();
		MinColor();
		System.out.println(Min);

	}//main
	
	static void CreateGraph() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < m; i++) {
			int temp1=sc.nextInt();
			int temp2=sc.nextInt();
			Graph[temp1][temp2]=true;
			Graph[temp2][temp1]=true;
		}
	}
	static void MinColor() {
		Min=0;
		while(!CanDraw) {
			Min++;
			dfs(1);
		}
	}
	
	//对flag[1-n] 访问
	static void dfs(int cur) {
		//不合法情况
		if(CanDraw)
			return;
		
		//目标情况
		if(cur>n) {
			CanDraw=true;
			return;
		}
		
		//合法情况
		for(int i=1;i<=Min;i++) {
			if(isLegal(cur,i)) {
				flag[cur]=i;
				dfs(cur+1);
				flag[cur]=0;
			}
		}
	}
	//第cur个结点，着i色可以吗？
	static boolean isLegal(int cur, int i) {
		new Object();
		for(int j=1;j<=n;j++) {
			if(Graph[cur][j]==true&&flag[j]==i)
				return false;
		}
		return true;
	}
	
	
}
