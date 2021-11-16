package leetcode.February;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Set;

import javafx.util.Pair;


class number{
	int count=1;
	int left=2100000000;
	int right=-2100000000;
	@Override
	public String toString() {
		return "number [count=" + count + ", left=" + left + ", right=" + right + "]";
	}
	
}

public class P0697_数组的度 {
	public static void main(String[] args) {
		//给定数组（非负），求和该数组的度一致的子数组的最小长度
		//数组的度定义为 数组中出现频率最高的数字的频率
		//->求每个字符的出现频率 以及出现的最左和最右的index，求有最高频率的字母组中，长度最短的那一个
		new P0697_数组的度().findShortestSubArray( new int[]{1,2,2,3,1,4,2});
		
	}//main
    public int findShortestSubArray(int[] nums) {
    	HashMap<Integer,number> hashMap = new HashMap<Integer,number>();
    	for (int i = 0; i < nums.length; i++) {
    		if(hashMap.containsKey(nums[i])) {
    			hashMap.get(nums[i]).count++;
    		}
    		else {
				hashMap.put(nums[i], new number());
			}
    		if(i>hashMap.get(nums[i]).right)
    			hashMap.get(nums[i]).right=i;
    		if(i<hashMap.get(nums[i]).left)
    			hashMap.get(nums[i]).left=i;
    		
		}
    	Set<Map.Entry<Integer,number>> entrySet = hashMap.entrySet();
    	int Maxdu=0;
    	int Minlength=2100000000;
    	for (Map.Entry<Integer, number> entry : entrySet) {
			if(entry.getValue().count>Maxdu) {
				Maxdu=entry.getValue().count;
				Minlength=entry.getValue().right-entry.getValue().left+1;
			}
			if(entry.getValue().count==Maxdu) {
				int len=entry.getValue().right-entry.getValue().left+1;
				if(len<Minlength)
					Minlength=len;
			}
		}
    	
    	return Minlength;
    }
}
