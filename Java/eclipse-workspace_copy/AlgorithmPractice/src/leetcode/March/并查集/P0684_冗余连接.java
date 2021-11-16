package leetcode.March.并查集;

import java.util.Arrays;

public class P0684_冗余连接 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new P0684_冗余连接().findRedundantConnection(new int[][]
				{
			{1,2}, {2,3}, {3,4}, {1,4}, {1,5}
				})));

	}//main
    public int[] findRedundantConnection(int[][] edges) {
    	int m=edges.length;
    	int []parent=new int[m];//树
    	int []rank=new int[m];
    	Arrays.fill(parent, -1);
    	Arrays.fill(rank, 0);
    	//此时parent都为 -1 也即结点都是孤立的
    	//下面开始使用并查集算法
    	//结点index是 0-m
    	for(int i=0;i<edges.length;i++) {
    		int x=edges[i][0];
    		int y=edges[i][1];
    		if(!union(x,y,parent,rank)) {
    			return new int[] {x,y};
    		}
    	}
    	return null;
    }
    
    
    //返回false说明合并失败了，也即本来就在一颗树上，找到环了
    boolean union(int i, int j, int[] parent, int[] rank) {
		int root_i=find_root(i,parent);
		int root_j=find_root(j,parent);
		if(root_i==root_j) {//根节点相同，无需合并，已经在一颗树上了
			return false;
		}
		else {//根节点不同，需要合并
			if(rank[root_i]>rank[root_j]) {
				parent[root_j]=root_i;
			}else if (rank[root_i]>rank[root_j]) {
				parent[root_i]=root_j;
			}else {
				parent[root_i]=root_j;
				rank[root_j]++;
			}
			return true;
		}
	}

	int find_root(int i, int[] parent) {
		int temp=i;
		while(parent[temp]!=-1) {
			temp=parent[temp];
		}
		return temp;
	}
	
}
