package AcWing.二分;

public class leetcode_P0069_x的平方根 {
	public static void main(String[] args) {
		

	}//main
	
    public int mySqrt(int x) {
    	int l=0,r=x;
    	while(l<r) {
    		int mid=(l+r+1)>>1;
    		if(mid*mid<=x) l=mid;
    		else r=mid-1;
    	}
    	return l;
    }
}
