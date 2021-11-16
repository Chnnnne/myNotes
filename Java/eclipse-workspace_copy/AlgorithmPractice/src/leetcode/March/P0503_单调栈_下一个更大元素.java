package leetcode.March;

import java.util.Arrays;
import java.util.LinkedList;

public class P0503_单调栈_下一个更大元素 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				new P0503_单调栈_下一个更大元素().
				nextGreaterElements(new int[] {1,2,1})));
	}//main
	
	//题意：对nums数组中，对每一个nums[i]寻找比nums[i]大的第一个元素的值
	public int[] nextGreaterElements(int[] nums) {
		int len=nums.length;
		int ans[]=new int[len];//ans[i]存储比nums[i]大的元素
		Arrays.fill(ans, -1);
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for(int i = 0;i < len*2-1 ;i++) {
			while(!stack.isEmpty()&&nums[i%len]>nums[stack.peek()])
			{
				ans[stack.pop()]=nums[i%len];
			}
			stack.push(i%len);
		}
		return ans;
	}
	
	
	
	
	
	public int[] nextGreaterElements1(int[] nums) {
		int m=nums.length;
		int nextGreater[]=new int[m];//nextGreater[i]存储比nums[i]大的元素
		boolean flag=false;
		for(int i=0;i<m;i++)
		{
			flag=false;
			for(int j=(i+1)%m;j!=i;j=(j+1)%m) {
				if(nums[j]>nums[i]) {
					nextGreater[i]=nums[j];
					flag=true;
					break;
				}
			}
			if(!flag)
				nextGreater[i]=-1;
		}
		
		return nextGreater;
	}
}
