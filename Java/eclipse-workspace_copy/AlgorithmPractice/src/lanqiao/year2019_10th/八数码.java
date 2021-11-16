package lanqiao.year2019_10th;

import java.beans.Visibility;
import java.util.Arrays;
import java.util.HashSet;


public class 八数码 {

	static int g[][] = new int[10][10];
	static boolean st[] = new boolean[10];
	static int path=0;
	static HashSet<Integer> res = new HashSet<Integer>();
	public static void main(String[] args) {
		g[1][2] = 1;g[2][1] = 1;
		g[1][3] = 1;g[3][1] = 1;
		g[2][4] = 1;g[4][2] = 1;
		g[3][4] = 1;g[4][3] = 1;
		g[4][5] = 1;g[5][4] = 1;
		g[4][6] = 1;g[6][4] = 1;
		g[5][7] = 1;g[7][5] = 1;
		g[6][7] = 1;g[7][6] = 1;
		g[2][5] = 1;g[5][2] = 1;
		g[3][6] = 1;g[6][3] = 1;
		for (int i = 1; i <= 7; i++) {
			Arrays.fill(st, false);
			path = 0;
			dfs(i);
		}
		System.out.println(res.size());

	}// main
	
	//访问第i个结点
	private static void dfs(int i) {
		st[i] = true;
		path=path|(1<<i);
		res.add(path);
		for(int j=1;j<=7;j++) {
			if(!st[j]&&g[i][j]==1) dfs(j);
		}
		st[i] = false;
		path=path-(1<<i);
	}
}
