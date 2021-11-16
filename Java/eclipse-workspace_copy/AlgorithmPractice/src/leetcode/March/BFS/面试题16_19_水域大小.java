package leetcode.March.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


class point{
	int x,y;

	public point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class 面试题16_19_水域大小 {
    static int[][]dir=new int[][] {
    	{0,1},
    	{1,1},
    	{1,0},
    	{1,-1},
    	{0,-1},
    	{-1,-1},
    	{-1,0},
    	{-1,1}
    };
    static int count=0;

    public int[] pondSizes(int[][] land) {
    	int m = land.length;
    	int n = land[0].length;
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(land[i][j]==0) {
    				al.add(bfs(i,j,land));
    			}
    		}
    	}
    	int[] array = al.stream().mapToInt(Integer::valueOf).toArray();
    	Arrays.sort(array);
    	return array;
    }

	private int bfs(int i, int j, int[][] land) {
		LinkedList<point> queue = new LinkedList<point>();
		int count=0;
		land[i][j]=1;
		count++;
		queue.offer(new point(i, j));
		while(!queue.isEmpty()) {
			point temp = queue.poll();
			for(int w=0;w<8;w++) {
				int nextx=temp.x+dir[w][0];
				int nexty=temp.y+dir[w][1];
				if(isLegal(nextx, nexty, land))
				{
					land[nextx][nexty]=1;
					count++;
					queue.offer(new point(nextx, nexty));
				}
			}
		}
		return count;
	}

	private boolean isLegal(int i, int j, int[][] land) {
		if(i<0||i>land.length-1||j<0||j>land[0].length-1)
			return false;
		if(land[i][j]!=0)
			return false;
		return true;
	}
}
