package leetcode.February;


public class P0766_托普利兹矩阵 {
	public static void main(String[] args) {
		System.out.println(new P0766_托普利兹矩阵().isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
	}//main
	
    public boolean isToeplitzMatrix(int[][] matrix) {
    	int m=matrix.length;
    	int n=matrix[0].length;
    	for(int i = 1; i < m; i++) {
    		for(int j=1; j< n;j++) {
    			if(matrix[i][j]!=matrix[i-1][j-1]) return false;
    		}
    	}
    	
    	return true;
    }
}

