package leetcode.March.DFS;

import java.util.ArrayList;
import java.util.List;

public class P0046_全排列 {
	public static void main(String[] args) {
		

	}//main
	
    
    static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
    	List<Integer> temp = new ArrayList<Integer>();
    	boolean flag[]=new boolean [nums.length];
    	dfs(0,nums.length,nums,temp,flag);
    	return res;
    }
    //输出一个组数的全排列，
    //cur 和 temp 
    static void dfs(int cur,int len,int[] nums, List<Integer> temp,boolean[] flag ) {
    	if(cur==len) {
    		res.add(new ArrayList<>(temp));
    		return;
    	}
    	for(int i=0;i<len;i++) {
    		if(!flag[i]) {
    			temp.add(nums[i]);
    			flag[i]=true;
    			dfs(cur+1, len, nums,temp, flag);
    			flag[i]=false;
    			temp.remove(nums[i]);
    		}
    	}
    }

}
