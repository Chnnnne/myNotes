package leetcode.February;

public class P0896_单调数列 {
	public static void main(String[] args) {
		boolean monotonic = new P0896_单调数列().isMonotonic(new int[] {1,3,2});
		System.out.println(monotonic);

	}//main
	
    public boolean isMonotonic(int[] A) {
    	//
    	boolean up=false;
    	boolean down=false;
    	int i=1;
    	for ( i = 1; i < A.length; i++) {
			if(A[i-1]<A[i]) up=true;
			if(A[i-1]>A[i]) down=true;
			if(up&&down) break;
		}
    	
    	if(i==A.length)
    		return true;
    	return false;
    }
}
