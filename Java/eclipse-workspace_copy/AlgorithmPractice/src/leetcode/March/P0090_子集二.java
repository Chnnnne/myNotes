package leetcode.March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.sun.source.tree.Tree;

public class P0090_子集二 {
	
	
	public static void main(String[] args) {
		

	}//main
	
	static	List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	res = new ArrayList<List<Integer>> ();
    	int len=nums.length;
    	boolean choose[]=new boolean[len];
    	Arrays.sort(nums);
    	dfs(0,choose,nums);
    	
    	
    	return null;
    }
    //访问第i个位置
	private void dfs(int i, boolean[] choose, int[] nums) {
		//非法情况
		//目标情况
		
		
		
		//合法情况
		if(i==0) {//特判
			
		}
		if(nums[i]==nums[i-1]&&choose[i-1]==true) {
			
		}
		
	}
}
