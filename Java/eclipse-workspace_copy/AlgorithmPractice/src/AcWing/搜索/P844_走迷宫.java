package AcWing.搜索;

import java.util.LinkedList;
import java.util.Scanner;

import javafx.util.Pair;

class point{
	int x,y;
	
	public point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		point other = (point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}

public class P844_走迷宫 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int g[][] = new int[n+1][m+1];
		int d[][] = new int[n+1][m+1];
		point pre[][] = new point[10009][10009];
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				g[i][j]=sc.nextInt();
			}
		}
		
		//01  10 0-1 -10
		int dirx[]=new int[] {0,1,0,-1};
		int diry[]=new int[] {1,0,-1,0};
		
		
		LinkedList<point> queue = new LinkedList<point>();
		d[1][1]=1;
		pre[1][1]=new point(-1, -1);
		queue.offer(new point(1,1));
		
		while(!queue.isEmpty()) {
			point head = queue.poll();
			
			for(int i=0;i<4;i++) {
				int x=head.x+dirx[i];
				int y=head.y+diry[i];
				if(x>=1&&x<=n&&y>=1&&y<=m&&d[x][y]==0&&g[x][y]==0) {
					pre[x][y]=head;
					d[x][y]=d[head.x][head.y]+1;//先visit标记
					queue.offer(new point(x, y));//再入栈
				}
			}
		}
		System.out.println(d[n][m]-1);
		int x=n,y=m;
		while(!(x==-1&&y==-1)) {
			System.out.println(x+" "+y);
			point temp=pre[x][y];
			x=temp.x;
			y=temp.y;
		}
		
		
	}//main
}
