package leetcode.February;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class P1438_绝对差不超过限制的最长连续子数组 {
	public static void main(String[] args) {
		int res = new P1438_绝对差不超过限制的最长连续子数组().longestSubarray(new int[] {2,2,2,4,4,2,5,5,5,5,5,2}, 2);
		System.out.println(res);

	}//main
    public int longestSubarray(int[] nums, int limit) {
    	int N=nums.length;//数组的边界
    	int left=0,right=0;//窗口的左右指针
    	//需要有一个数据结构 ，可以根据窗口长度(left right)变化而变化的max min
    	TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
    	//key:数组每一项的值 —— value：出现的次数
    	int res=0;//保存满足一定条件的窗口的长度的最大值
    	while(right<N)
    	{
    		//右边界向右探索，并更新窗口条件
    		if(treeMap.containsKey(nums[right])) {
    			treeMap.put(nums[right], treeMap.get(nums[right])+1);
    		}else {
				treeMap.put(nums[right], 1);
			}
    		
    		//查看窗口条件，是否满足要求，不满足则不断调整左边界，满足则不需调整
    		while(treeMap.lastKey()-treeMap.firstKey()>limit) {
    			if(treeMap.get(nums[left])>1) {
    				treeMap.put(nums[left], treeMap.get(nums[left])-1);
    			}else {
    				treeMap.remove(nums[left]);
    			}
    			left++;
    		}
    		
    		//此时左右端点组成的窗口满足条件，求敞口长度最大值
    		res=Math.max(res, right-left+1);
    		//右端点扩展
    		right++;
    	}
    	
    	return res;
    }
	
}
