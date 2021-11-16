package AcWing.搜索;

public class 真图_leetcode_P0547_省份数量 {

	private boolean[] visited;
	int n;
    public int findCircleNum(int[][] isConnected) {
    	n=isConnected.length;
    	visited=new boolean[n];
    	int ans=0;
    	for(int i=0;i<n;i++) {
    		if(!visited[i]) {
				ans++;
    			dfs(i,isConnected);
    		}
    	}
    	return ans;
    }

	private void dfs(int i, int[][] isConnected) {
		//访问第i节点，并且递归访问连通的
		visited[i]=true;
		for(int j=0;j<n;j++) {
			//相连，没被访问过，非自环
			if(isConnected[i][j]==1&&!visited[j]&&i!=j) {
				dfs(j, isConnected);
			}
		}
	}
}
