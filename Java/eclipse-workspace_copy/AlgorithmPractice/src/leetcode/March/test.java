package leetcode.March;

import java.util.Deque;
import java.util.LinkedList;

public class test {
	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<String>();
		stack.push("111");
		stack.push("222");
		stack.push("333");
		System.out.println(stack.peek());//栈顶
		System.out.println(stack.getFirst());//最右边的，最上面(外边)的
		System.out.println(stack.getLast());//最左边的，最下面(里面)的
		
		
		System.out.println();
		Deque<String> queue= new LinkedList<>();
		queue.offer("111");
		queue.offer("222");
		queue.offer("333");
		System.out.println(queue.peek());//队首
		System.out.println(queue.getFirst());
		System.out.println(queue.getLast());
	}//main
}
