package leetcode.February;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P0832_翻转图像 {
	public static void main(String[] args) {
		int[][] array = new P0832_翻转图像().flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}});
		for (int i = 0; i < array.length; i++) {
			for(int j = 0; j<array[i].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}

	}//main
	
	
	public int[][] flipAndInvertImage(int[][] A) {
		int temp=0;
		int row=A.length,col=A[0].length;
		for (int i = 0; i < row; i++) {
			for(int j = 0 ;j < (col+1)/2; j++) {//col=6, col+1/2=3 j=012    //col=5 col+1/2=3 j=0 1 2
				temp=A[i][j]^1;
				A[i][j]=A[i][col-j-1]^1;
				A[i][col-j-1]=temp;
			}
		}
			
		return A;
    }
}
