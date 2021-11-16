package AcWing.二分;

public class leetcode_P74_搜索二维矩阵 {
	public static void main(String[] args) {
		System.out.println(new leetcode_P74_搜索二维矩阵().
				searchMatrix(new int[][] {{1,1}}, 0));

	}//main
	
	public boolean searchMatrix(int[][] matrix, int target) {
		//l r 为二维拉成1维后的index
		int m=matrix.length;
		int n=matrix[0].length;
		int l=0,r=m*n-1;
		while(l<r) {
			int mid=(l+r+1)>>1;
		//check检验的是，是否小于等于target
			if(check(mid,matrix,target)) l=mid;
			else r=mid-1;
		}
		if(matrix[l/matrix[0].length][l%matrix[0].length]!=target) return false;
		else return true;
    }
	
	private boolean check(int mid, int[][] matrix, int target) {
		if(matrix[mid/matrix[0].length][mid%matrix[0].length]<=target)
			return true;
		return false;
	}
}
