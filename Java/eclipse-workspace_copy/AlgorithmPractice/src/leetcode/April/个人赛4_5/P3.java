package leetcode.April.个人赛4_5;

import java.util.PriorityQueue;

public class P3 {

	public static void main(String[] args) {
		System.out.println(new P3().magicTower(new int[] { 0,0,0,-1,1 }));
	}// main

	public int magicTower(int[] nums) {
		int len = nums.length;
		int sum = 1;
		int desum = 0;
		int cnt = 0;
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();
		// i是小扣当前的闯关层数，
		for (int i = 0; i < len; i++) {
			// 对于负数 先入队
			if (nums[i] < 0)
				pqueue.offer(nums[i]);
			sum += nums[i];
			// 如果当前和小于0，那么一直出队最小的（也即调整顺序），然后更新sum 直到sum>0
			if (sum <= 0) {
				cnt++;
				Integer poll = pqueue.poll();
				sum -= poll;
				desum += poll;
			}
		}
		if (sum + desum > 0)
			return cnt;
		else
			return -1;

	}
}
