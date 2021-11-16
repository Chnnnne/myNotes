package AcWing.双指针;


public class leetcode_P0209 {
	public static void main(String[] args) {
		

	}//main
	
    public int minSubArrayLen(int target, int[] nums) {
    	 int N=nums.length;
         int allSum=0;
         for(int i=0;i<N;i++){
             allSum+=nums[i];
         }
         if(allSum<target) return 0;
         int l=0,r=0; //l 是左端点(主动) r是右端点(从动)
         int sum=0;
         int res=N;
         while(r<N) {
        	 sum+=nums[r];
         	while(sum>=target&&l<r) {
         		sum-=nums[l];
         		l++;
         		res=Math.min(res, r-l+2);
         	}
         	r++;
         }
         return res;
    }
}
