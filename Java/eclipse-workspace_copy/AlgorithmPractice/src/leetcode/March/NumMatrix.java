package leetcode.March;

public class NumMatrix {
	
	//matrix[i][j]		代表矩阵的一个元素
	//preSum[i+1][j+1]	代表 以matrix[i][j]为右下角的前缀和
	public int preSum[][];
    public NumMatrix(int[][] matrix) {
    	preSum=new int[matrix.length+1][matrix[0].length+1];
    	int m=matrix.length,n=matrix[0].length;
    	for(int i=0;i<m;i++)
    		for(int j=0;j<n;j++) {
    			preSum[i+1][j+1]=preSum[i+1][j]+preSum[i][j+1]-preSum[i][j]+matrix[i][j];
    		}
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	return preSum[row2+1][col2+1]-preSum[row2+1][col1] - preSum[row1][col2+1] +preSum[row1][col1];
    }
}
