package leetcode.February;

import java.util.Arrays;

public class P0867_转置矩阵 {
	public static void main(String[] args) {
		int[][] transpose = new P0867_转置矩阵().transpose(new int[][]{{1,2,3},{4,5,6}});
		for (int i = 0; i < transpose.length; i++) {
			System.out.println(Arrays.toString(transpose[i]));
		}
		
	}//main
	
    public int[][] transpose(int[][] matrix) {
    	int [][]ret=new int[matrix[0].length][matrix.length];
    	//matrix的每一行 变成 ret的 每一列
    	for (int i = 0; i < matrix.length; i++) {
			for(int j = 0; j<matrix[0].length; j++) {
				ret[j][i]=matrix[i][j];
			}
		}
    	
    	
    	return ret;
    }
}
