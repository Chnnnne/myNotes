package leetcode.March.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class 面试题16_19_水域大小 {
	public static void main(String[] args) {
		

	}//main
	
	
	
    public int[] pondSizes(int[][] land) {
    	int m = land.length;
    	int n = land[0].length;
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	for (int i=0; i<m; i++) {
    		for(int j=0; j<n; j++) {
    			if(land[i][j]==0) {
    				count=0;
    				dfs(i,j,land);
    				al.add(count);
    			}
    		}
    	}
    	int[] array = al.stream().mapToInt(o1->Integer.valueOf(o1)).toArray();
    	Arrays.sort(array);
    	return array;
    }


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
//    //保证进入的都是合法的
//	private void dfs(int i, int j, int[][] land) {
//		land[i][j]=1;
//		count++;
//		for(int m=0;m<8;m++) {
//			int x=i+dir[m][0];
//			int y=j+dir[m][1];
//			if(isLegal(x, y, land))
//				dfs(x, y, land);
//		}
//	}
	private void dfs(int i, int j, int[][] land) {
		if(isLegal(i,j,land)) {
			land[i][j]=1;
			count++;
			for(int m=0;m<8;m++) {
				dfs(i+dir[m][0], j+dir[m][1], land);
			}
		}
	}


	private boolean isLegal(int i, int j, int[][] land) {
		if(i<0||i>land.length-1||j<0||j>land[0].length-1)
			return false;
		if(land[i][j]!=0)
			return false;
		return true;
	}
}
