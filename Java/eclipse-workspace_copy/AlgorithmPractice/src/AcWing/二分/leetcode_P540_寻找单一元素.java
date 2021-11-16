package AcWing.二分;

public class leetcode_P540_寻找单一元素 {
	public static void main(String[] args) {
		

	}//main
	
    public int singleNonDuplicate(int[] nums) {
    	
    	int l=-1,r=nums.length;
    	while(l<r) {
    		int mid=(l+r+1)>>1;
    		if(check(mid,nums)) l=mid;
    		else r=mid-1;
    	}
    	
    	return nums[l+1];
    }

    //判断nums[mid]是否处于单一元素的左边
	private boolean check(int mid, int[] nums) {
		if(mid%2==0) {
			if(mid==nums.length-1)
				return false;
			if(nums[mid]==nums[mid+1])
				return true;
			else
				return false;
		}
		else {
			if(nums[mid]==nums[mid-1])
				return true;
			else
				return false;
		}
	}
}
