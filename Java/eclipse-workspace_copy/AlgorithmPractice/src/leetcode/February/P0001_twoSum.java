package leetcode.February;

import java.util.HashMap;

public class P0001_twoSum {
	public static void main(String[] args) {
		
	}
   public int[] twoSum(int[] nums, int target) {
	   int []ans=new int[2];
	   for (int i = 0; i < nums.length; i++) {
		   for (int j = i+1; j < nums.length; j++) {
				if(nums[i]+nums[j]==target) {
					ans[0]=i;
					ans[1]=j;
					return ans;
				}
			}
		}
	   return null;
   }
   public int[] twoSum1(int[] nums, int target) {
	   int []ans=new int[2];
	   HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
	   for (int i = 0; i < nums.length; i++) {
		   if(hm.containsKey(target-nums[i])) {
			   ans[0]=hm.get(target-nums[i]);
			   ans[1]=i;
			   return ans;
		   }
		   hm.put(nums[i], i);
	   }
	   
	   return null;
   }
}
