package AcWing.二分;


public class leetcode_P74_再做 {
	
	public static void main(String[] args) {
		

	}//main
	
	
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
//        if(target<matrix[0][0]||target>matrix[row-1][col-1])
//        	return false;
        
        //二分index
        int l=0,r=row*col-1;
        while(l<r) {
        	int mid=(l+r+1)>>1;
        	if(check(mid,matrix,target)) l=mid;
        	else r=mid-1;
        }
        
    	if(matrix[l/col][l%col]==target) return true;
    	return false;
    }


	private boolean check(int mid, int[][] matrix, int target) {
		int col=matrix[0].length;
		int x=mid/col;
		int y=mid%col;
		if(matrix[x][y]<=target)
			return true;
		return false;
	}
}
