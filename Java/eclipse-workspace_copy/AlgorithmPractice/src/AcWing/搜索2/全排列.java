package AcWing.搜索2;

import java.util.Arrays;
import java.util.Scanner;


public class 全排列 {
	public static final int MAXN = 20;
	static int n;
	static boolean[] visited=new boolean[MAXN];
	static int[] flag=new int[MAXN];
	
	
	
	public static void main(String[] args) {
		init();
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		dfs(1);
	}//main
			
	
	static void init() {
		Arrays.fill(visited, false);
		Arrays.fill(flag, 0);
	}


	static void dfs(int cur) {
		//目标状态
		if(cur>n) {
			for(int i=1;i<=n;i++) {
				System.out.print(flag[i]);
			}
			System.out.println();
			return;
		}
		
		
		//合法状态
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				flag[cur]=i;
				visited[i]=true;
				dfs(cur+1);
				flag[cur]=0;
				visited[i]=false;
			}
		}
	}
}
