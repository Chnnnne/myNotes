package leetcode.March.DFS;

import java.util.ArrayList;


public class test {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		System.out.println(al);
		fun(al);
		System.out.println(al);
	}

	private static void fun(ArrayList<Integer> al) {
		al.add(4);
		al.add(5);
		al.add(6);
	}//main
}
