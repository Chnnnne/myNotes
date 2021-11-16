package AcWing.二分;

public class leetcode_53_缺失的数 {
	public static void main(String[] args) {
		System.out.println(new leetcode_53_缺失的数().missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));

	}//main
	
	//寻找nums中缺失的那一个
    public int missingNumber(int[] nums) {
    	int l=0,r=nums.length;
    	while(l<r) {
    		int mid=(l+r+1)>>1;
    		if(check(mid,nums)) l=mid;
    		else r=mid-1;
    	}
    	return l+1;
    }

	private boolean check(int mid, int[] nums) {
		if(nums[mid]==mid)
			return true;
		return false;
	}
}
