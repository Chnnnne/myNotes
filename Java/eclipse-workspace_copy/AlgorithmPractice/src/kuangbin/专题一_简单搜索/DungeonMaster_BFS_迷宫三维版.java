package kuangbin.专题一_简单搜索;

import java.util.LinkedList;
import java.util.Scanner;

//虚拟迷宫以0,0,0为起点
class point1{
	int x,y,z;
	int step;
	public point1(int x, int y, int z, int step) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.step = step;
	}

	
}

public class DungeonMaster_BFS_迷宫三维版 {
	public static final int MAXN = 32;
	static char maze[][][]=new char[MAXN][MAXN][MAXN]; // level - row - col
	static int level,row,col;
	static int dir[][]=new int[][] {
		{0,1,0},//x,y,z
		{1,0,0},
		{0,-1,0},
		{-1,0,0},
		{0,0,1},
		{0,0,-1},
	};
	static point1 start;
	static point1 end;
	static LinkedList<point1> queue = new LinkedList<point1>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			level = sc.nextInt();
			row = sc.nextInt();
			col = sc.nextInt();
			if(level==0) return;
			//注意 i-level j-row  k-col
			for (int i = 0; i < level; i++) {
				for(int j = 0; j < row; j++) {
					char[] charArray = sc.next().toCharArray();
					for( int k = 0; k <col; k++) {
						if(charArray[k]=='S') start=new point1(j, k, i,0);
						maze[i][j][k]=charArray[k];
					}
				}
			}
			bfs();
			
			
		}

	}//main
	private static void bfs() {
			
			maze[start.z][start.x][start.y]='#';
			boolean flag=false;
			queue.offer(start);
			
			while(!queue.isEmpty()) {
				point1 qhead = queue.poll();
				int x=qhead.x;int y=qhead.y;int z=qhead.z;int step=qhead.step;
				if(maze[z][x][y]=='E') {
					end=new point1(x, y, z, step);
					flag=true;
					break;
				}
				for(int i=0;i<6;i++) {
					int nextx=x+dir[i][0];
					int nexty=y+dir[i][1];
					int nextz=z+dir[i][2];
					if(isLegal(nextx,nexty,nextz)) {
						maze[nextz][nextx][nextx]='#';
						queue.offer(new point1(nextx, nexty, nextz, step+1));
					}
				}
			}
			if(flag)
				System.out.println("Escaped in "+end.step+" minute(s).");
			else
				System.out.println("Trapped!");
	}
	private static boolean isLegal(int nextx, int nexty, int nextz) {
		if(nextz>=level||nextz<0||nextx<0||nextx>=row||nexty<0||nexty>=col)
			return false;
		if(maze[nextz][nextx][nexty]=='.'||maze[nextz][nextx][nexty]=='E')
			return true;
		return false;
	}
}
