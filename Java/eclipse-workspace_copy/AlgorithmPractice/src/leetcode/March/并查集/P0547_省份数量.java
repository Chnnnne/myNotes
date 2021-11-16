package leetcode.March.并查集;

import java.util.Arrays;

public class P0547_省份数量 {
	
	
	public static void main(String[] args) {
		System.out.println(new P0547_省份数量().findCircleNum(new int[][] 
				{{1,1,0},
			{1,1,0},
			{0,0,1}}));

	}//main
	
	//给定一个图，判断有几个连通分量（判断有几片岛屿）
    public int findCircleNum(int[][] isConnected) {
    	int m=isConnected.length;
    	int []parent=new int[m];//树
    	int []rank=new int[m];
    	Arrays.fill(parent, -1);
    	Arrays.fill(rank, 0);
    	//此时parent都为 -1 也即结点都是孤立的
    	//下面开始使用并查集算法
    	//结点index是 0-m
    	for(int i=0;i<m;i++)
    		for(int j=0;j<m;j++) {
    			if(isConnected[i][j]==1) {
    				union(i,j,parent,rank);
    			}
    		}
    	int count=0;
    	for(int i=0;i<m;i++) {
    		if(parent[i]==-1) {
    			count++;
    		}
    	}
    	return count;
    }

	void union(int i, int j, int[] parent, int[] rank) {
		int root_i=find_root(i,parent);
		int root_j=find_root(j,parent);
		if(root_i==root_j) {//根节点相同，无需合并，已经在一颗树上了
			return;
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
