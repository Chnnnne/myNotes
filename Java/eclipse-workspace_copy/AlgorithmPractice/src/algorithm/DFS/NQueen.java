package algorithm.DFS;

import java.util.Scanner;

public class NQueen {
	public static final int MAXN = 50;//棋盘最大值
	static int n=0;//棋盘大小，动态输入的
	static int []pos=new int[MAXN+1];//记录n皇后的位置
	static int ans=0;
	
	//辅助变量
	static boolean visitedCol[]=new boolean[MAXN+MAXN+1];
	static boolean visitedZhu[]=new boolean[MAXN+MAXN+1];
	static boolean visitedFu[]=new boolean[MAXN+MAXN+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		dfs(1);
		System.out.println("共有"+ans+"种");

	}//main
	//访问新状态的 新增参量，也即访问pos的第cur个位置
	public static void dfs(int cur) {
		//不合法情况
		
		//目标状态(若是第n个位置是最终新增的话，会在此步多很多,来判断哪一列为空，因此把第n+1个位置作为最终)
		if(cur>n) {
			PrinBoard();
			ans++;
			return;
		}
		
		//非目标状态,进入下一层
		for (int i = 1; i <= n; i++) {
			if(!visitedCol[i]&&!visitedZhu[cur-i+MAXN]&&!visitedFu[cur+i]) {
				pos[cur]=i;
				visitedCol[i]=true;
				visitedZhu[i]=true;
				visitedFu[i]=true;
				dfs(cur+1);
				pos[cur]=0;
				visitedCol[i]=false;
				visitedZhu[i]=false;
				visitedFu[i]=false;
			}
			
		}
	}
	private static void PrinBoard() {
		System.out.println("第"+ans+"种");
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(pos[i]==j)
					System.out.print("X ");
				else
					System.out.print("O ");
			}
			System.out.println();
		}
		
	}
}
