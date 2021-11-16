package leetcode.March.并查集;

import java.util.Arrays;


public class 模板尝试 {
	static int []parent=new int[10];
	static int []rank=new int[10];
	public static void main(String[] args) {
		Arrays.fill(parent, -1);//初始化parent 树
		Arrays.fill(rank, 0);//初始化rank数组
		int [][]edges=new int[][] {//图
			{0,1},
			{1,2},
			{1,3},
			{2,4},
			{3,4},
			{2,5},
		};
		for (int i = 0; i < 6; i++) {
			int x=edges[i][0];
			int y=edges[i][1];
			if(!union(x, y)) {
				System.out.println("Cycle detected!");
				System.out.println(Arrays.toString(rank));
				System.out.println(Arrays.toString(parent));
				return;
			}
		}
		System.out.println("No cycles");
	}//main
	
	
	/*
	  union函数， 作用是把 x y节点代表的集合合并起来 。
	  false 说明合并失败，发现环了！  true说明合并成功
	 */
	static boolean union(int x, int y) {
		int root_x=find_root(x);
		int root_y=find_root(y);
		if(root_x==root_y)
			return false;
		else {
//			parent[root_x]=root_y; 
			if(rank[root_x]>rank[root_y]) {
				parent[root_y]=root_x;
			}
			else if(rank[root_x]<rank[root_y]) {
				parent[root_x]=root_y;
			}else {
				parent[x]=y;
				rank[root_y]++;
			}
			return true;
		}
	}

	static int find_root(int x) {
		int temp=x;
		while(parent[temp]!=-1) {
			temp=parent[temp];
		}
		return temp;
	}
}
