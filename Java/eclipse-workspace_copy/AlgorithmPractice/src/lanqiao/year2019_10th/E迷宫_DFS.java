package lanqiao.year2019_10th;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * 这提示错误思路，贪心的DFS虽然能字典序最小，但是不能保证路径最短
 */
public class E迷宫_DFS {

	public static final int MAXN = 60;
	static int g[][] = new int[MAXN][MAXN];
	static boolean st[][] = new boolean[MAXN][MAXN];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 30; i++) {
			String str = sc.next();
			for (int j = 1; j <= 50; j++) {
				g[i][j] = str.charAt(j - 1) - '0';
			}
		}

		dfs(1, 1);
	}// main

	static int dirx[] = { 1, 0, 0, -1 };
	static int diry[] = { 0, -1, 1, 0 };
	static Character dirc[] = { 'D', 'L', 'R', 'U' };
	static ArrayList<Character> path = new ArrayList<Character>();
	static boolean flag = true;
	private static void dfs(int x, int y) {
		if(!flag) {
			return;
		}
		st[x][y] = true;
		if (x == 30 && y == 50) {
			System.out.println("Got it!");
			System.out.println(path.size());
			for(Character c:path) {
				System.out.print(c);
			}
			flag = false;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dirx[i];
			int ny = y + diry[i];
			if (nx >= 1 && nx <= 30 && ny >= 1 && ny <= 50 && !st[nx][ny] && g[nx][ny] == 0) {
				path.add(dirc[i]);
				dfs(nx, ny);
				path.remove(path.size() - 1);
			}
		}

	}
}
