package leetcode.March;

public class NumArray {
	int sums[];
    public NumArray(int[] nums) {
    	sums=new int[nums.length+1];
    	//nums[i]代表第i+1个数
    	//sums[i]代表第i个数的前缀和
    	for (int i = 0; i < nums.length; i++) {
			sums[i+1]=sums[i]+nums[i];
		}
    	
    }
    
    public int sumRange(int i, int j) {
    	return sums[j+1]-sums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
