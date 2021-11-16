package leetcode.March;

import java.util.Deque;
import java.util.LinkedList;

public class P0739_单调栈_每日温度 {
	public static void main(String[] args) {
		

	}//main
	/*
	 题目的意思就是对T数组中的每个元素，找出其在T数组中下一个比它大的元素。暴力方法太笨要n^2
	按照思考方式得：要找出后面第一个比前面大的元素，因此在处理时，要通过现在的元素处理到前面的元素
	单调栈(递减栈，存放的是index)让该题到了O(n)
	栈里的元素是待处理的，也即待找到比它大的元素的下标
	单调栈的操作方法：
	①当待处理元素遇到空栈时直接入栈
	②当待处理元素小于栈顶元素时入栈,这些元素都是没找到比它大的元素
	③当待处理元素大于栈顶元素时，出栈栈顶元素，得到差值，因为
	 
	 */
	public int[] dailyTemperatures(int[] T) {
    	int len=T.length;
        int[] res = new int[len];
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i = 0;i < len;i++) {
        	while(!stack.isEmpty()&&T[i]>T[stack.peek()]) {
        		res[stack.peek()]=i-stack.pop();
        	}
        	stack.push(i);
        }
        return res;
    }
//    public int[] dailyTemperatures(int[] T) {
//    	int len=T.length;
//        int[] res = new int[len];
//        Deque<Integer> stack = new LinkedList<Integer>();
//        for(int i = 0; i < len; i++) {
//            while(!stack.isEmpty() && T[i] > T[stack.peek()]) {
//                res[stack.peek()] = i - stack.pop();
//            }
//            stack.push(i);
//        }
//        return res;
//    }
}
