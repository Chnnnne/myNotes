package practice01;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class demo02 {
	

	public static void main(String args[]) {
	LinkedList<String> ll = new LinkedList<String>();
	ll.add("111");
	ll.add("222");
	ll.add("333");
	ll.add("444");
	ArrayList<String> al = new ArrayList<String>();
	al.add("111");
	al.add("222");
	al.add("333");
	al.add("444");
	System.out.println(al.indexOf("111"));
}
}
