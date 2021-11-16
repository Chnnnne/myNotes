package leetcode.March.并查集;

import java.util.Arrays;

public class P0547_省份数量_再敲 {

	
	public static void main(String[] args) {
		

	}//main
	
	int parent[];
	int rank[];
	int N;
    public int findCircleNum(int[][] isConnected) {
    	N = isConnected.length;
    	parent = new int[N];
    	rank = new int[N];
    	Arrays.fill(parent, -1);
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(isConnected[i][j] == 1) {
    				Union(i,j);
    			}
    		}
    	}
    	int count = 0;
    	for(int i = 0 ; i < N; i++) {
    		if(parent[i] == -1) count++;
    	}
    	
    	return count;
    }
	private boolean Union(int x, int y) {
		int root_x = find_root(x);
		int root_y = find_root(y);
		if(root_x == root_y) return false;
		
		if(rank[root_x] > rank[root_y]) {
			parent[root_y] = root_x;
		}else if (rank[root_y] > rank[root_x]) {
			parent[root_x] = root_y;
		}else {
			parent[root_x] = root_y;
			rank[root_y]++;
		}
		return true;
	}
	private int find_root(int x) {
		if(parent[x] == -1) return x;
		return find_root(parent[x]);
	}
}
