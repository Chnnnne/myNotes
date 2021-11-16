package leetcode.March.并查集;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * 原因：挺麻烦的
 * 1. 判断两点是否在一个集合中
 * 
 */
public class 为啥不用HashSet {
	static ArrayList<HashSet<Integer>> al = new ArrayList<HashSet<Integer>>();
	public static void main(String[] args) {
		int [][]edges=new int[][] {			
			{0,1},
			{1,2},
			{1,3},
			{2,4},
			{3,4},
			{2,5}
			};
		for (int i = 0; i < edges.length; i++) {
			int x=edges[i][0];
			int y=edges[i][1];
			if(union(x,y)) {
				continue;
			}
			else {
				System.out.println("合并失败，找到环了！");
			}
		}

	}//main

	private static boolean union(int x, int y) {
		HashSet<Integer> xHashSet;
		HashSet<Integer> yHashSet;
		for(HashSet<Integer> set:al) {
//			if(set.contains(x)&&set.contains(y)) {
//				return false;//在一个集合中，找到环了
//			}
			if(set.contains(x))
				xHashSet=set;
			if(set.contains(y))
				yHashSet=set;
//			if(xHashSet==yHashSet) {
//				
//			}
		}
		
		
		return false;
	}
}
