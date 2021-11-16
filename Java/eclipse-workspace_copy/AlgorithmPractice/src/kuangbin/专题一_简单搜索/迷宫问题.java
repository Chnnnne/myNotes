package kuangbin.专题一_简单搜索;

import java.util.LinkedList;
import java.util.Scanner;


class point2{
	int x,y;

	public point2(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "point2 [x=" + x + ", y=" + y + "]";
	}
	
}

public class 迷宫问题 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maze[][]=new int[5][5];
		point2 pre[][]=new point2[5][5];
		int dir[][]= {
				{0,1},
				{1,0},
				{0,-1},
				{-1,0}
		};
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				maze[i][j]=sc.nextInt();
			}
		}
		
		LinkedList<point2> queue = new LinkedList<point2>();
		maze[0][0]=1;
		pre[0][0]=null;
		queue.offer(new point2(0,0));
		while(!queue.isEmpty()) {
			point2 qhead = queue.poll();
			int x=qhead.x;
			int y=qhead.y;
			if(x==4&&y==4) {
				break;
			}
			for(int i=0;i<4;i++) {
				int nextx=x+dir[i][0];
				int nexty=y+dir[i][1];
				if(isLegal(nextx,nexty,maze)) {
					maze[nextx][nexty]=1;
					pre[nextx][nexty]=qhead;
					queue.offer(new point2(nextx, nexty));
				}
			}
		}
		prinLastOne(4,4,pre);
//		System.out.println(pre[4][4]);
	}//main

	private static void prinLastOne(int i, int j, point2[][] pre) {
		if(pre[i][j]!=null)
			prinLastOne(pre[i][j].x, pre[i][j].y, pre);
		
			System.out.println("("+i+", "+j+")");
	}

	private static boolean isLegal(int nextx, int nexty, int[][] maze) {
		if(nextx<0||nextx>=5||nexty<0||nexty>=5)
			return false;
		if(maze[nextx][nexty]!=0)
		return false;
		return true;
	}
}
