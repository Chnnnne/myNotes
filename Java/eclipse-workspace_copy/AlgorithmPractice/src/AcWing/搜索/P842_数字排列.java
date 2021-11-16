package AcWing.搜索;

import java.util.Arrays;
import java.util.Scanner;

public class P842_数字排列 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		path=new int[n+1];
		visited=new boolean[n+1];
		Arrays.fill(path, 0);
		Arrays.fill(visited, false);
		dfs(1);

	}//main
	static int n;
	static int path[];
	static boolean visited[];
	
	//访问第cur层状态，也即path[cur]
	static void dfs(int cur) {
		//目标状态
		if(cur>n) {
			for(int i = 1;i<=n;i++) {
				System.out.print(path[i]+" ");
			}
			System.out.println();
			return;
		}
		
		
		//合法状态
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				path[cur]=i;
				visited[i]=true;
				dfs(cur+1);
				path[cur]=0;
				visited[i]=false;
			}
		}
	}
}
