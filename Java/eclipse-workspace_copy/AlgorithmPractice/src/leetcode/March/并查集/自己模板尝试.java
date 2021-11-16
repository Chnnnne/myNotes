package leetcode.March.并查集;

import java.util.Arrays;


public class 自己模板尝试 {
	static int []parent=new int[10];
	public static void main(String[] args) {
		Arrays.fill(parent, -1);//初始化parent 树
		int [][]edges=new int[][] {//图
			{0,1},
			{1,2},
			{1,3},
//			{2,4},
			{3,4},
			{2,5},
		};
		for (int i = 0; i < 5; i++) {//拓展思考：如果5变成6，多了一个{0,0}的话(也即自环)一定是有环的
			int x=edges[i][0];
			int y=edges[i][1];
			int root_x=find_root(x);
			int root_y=find_root(y);
			if(root_x==root_y) {
				System.out.println("cycle detected");
				return;
			}else {
				union(root_x, root_y);
			}
		}
		System.out.println("no cycles");
	}//main
	
	
	/*
	  union函数， 作用是把 x y节点代表的集合合并起来 。
	  false 说明合并失败，发现环了！  true说明合并成功
	 */
	static void union(int x, int y) {
			parent[x]=y;
	}

	static int find_root(int x) {
		int root_x=x;
		while(parent[root_x]!=-1) {
			root_x=parent[root_x];
		}
		return root_x;
	}
}
