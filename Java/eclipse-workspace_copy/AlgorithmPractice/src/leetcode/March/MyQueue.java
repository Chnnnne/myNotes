package leetcode.March;

import java.util.Stack;

class MyQueue {
	static Stack<Integer> s1;
	static Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
    	s1=new Stack<Integer>();
    	s2=new Stack<Integer>();
    }
    //两个栈实现
    /** Push element x to the back of queue. */
    public void push(int x) {
    	//直接push到栈2中
    	s2.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	//查看栈1是否为空，不空直接pop，否则把栈2都pop，然后push到栈1中
    	if(!s1.isEmpty())
    		return s1.pop();
    	else {
			while(!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			return s1.pop();
		}
    }
    
    /** Get the front element. */
    public int peek() {
    	//查看栈1是否为空，不空直接peek，否则把栈2都pop，然后push到栈1中
       	if(!s1.isEmpty())
    		return s1.peek();
    	else {
			while(!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			return s1.peek();
		}
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	//栈12都空才空
    	return s1.isEmpty()&&s2.empty();
    }
    public static void main(String[] args) {
    	MyQueue obj = new MyQueue();
    	  
    	 boolean param_4 = obj.empty();
    	 System.out.println(param_4);

	}//main
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */