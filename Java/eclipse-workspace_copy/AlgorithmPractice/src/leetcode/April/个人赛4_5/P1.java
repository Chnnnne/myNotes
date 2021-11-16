package leetcode.April.个人赛4_5;

import java.util.Arrays;

public class P1 {

	public static void main(String[] args) {
		System.out.println(new P1().purchasePlans(new int[] {2,2,1,9}, 10));
	}// main

	public int purchasePlans(int[] nums, int target) {
		Arrays.sort(nums);
//		System.out.println(Arrays.toString(nums));
		int res = 0;
		int len = nums.length;
		for (int i = 0; i < len; i++) {

			int l = i, r = len - 1;
			while(l<r) {
				int mid = (l+r+1)>>1;
				if(check(mid,i,target,nums)) l = mid;
				else r = mid-1;
			}
//			System.out.println(i+":"+l);
//			if(l==i) continue;
			res=(res+l-i)%1000000007;
		}

		return res;

	}

	private boolean check(int mid, int i, int target, int[] nums) {
		if(nums[mid]<=target-nums[i])
			return true;
		return false;
	}

}
