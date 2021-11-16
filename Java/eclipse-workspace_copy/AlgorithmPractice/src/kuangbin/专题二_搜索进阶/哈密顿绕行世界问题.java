package kuangbin.专题二_搜索进阶;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 哈密顿绕行世界问题 {
	public static final int MAXN = 22;
	static boolean g[][]=new boolean[MAXN][MAXN];
	static boolean[] visited=new boolean[MAXN];
	static int str_fnl=0;
	static int count = 0;
	static ArrayList<Integer> path=new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		
		for(int i = 1;i <= 20;i++) {
			int x=Reader.nextInt();
			int y=Reader.nextInt();
			int z=Reader.nextInt();
			g[i][x]=true;
			g[i][y]=true;
			g[i][z]=true;
		}
		while(true) {
			path.clear();
			Arrays.fill(visited, false);
			count=0;
			str_fnl = Reader.nextInt();
			if(str_fnl==0)
				break;
			dfs(str_fnl,1);//第1步访问 起点
		}

	}//main
	//在第j步，访问第cur个结点
	private static void dfs(int cur, int j) {
		//目标状态
		visited[cur]=true;
		path.add(cur);
		if(j==20) {
				if(g[cur][str_fnl]) {
					System.out.print(++count+": ");
					path.forEach(o1->System.out.print(" "+o1));
					System.out.println(" "+str_fnl);
				}
			visited[cur]=false;
			path.remove(path.size()-1);
			return;
		}
		
		//合法状态
		for(int i=1;i<=20;i++) {
			if(g[cur][i]&&!visited[i])
				dfs(i,j+1);
		}
		visited[cur]=false;
		path.remove(path.size()-1);
	}
	
}
