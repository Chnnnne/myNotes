package AcWing.搜索;

import java.util.LinkedList;

class stu{
	String name;
	int age;
	public stu(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
}

public class test {
	public static void main(String[] args) {
//		LinkedList<stu> queue = new LinkedList<stu>();
//		stu stu1 = new stu("lihua", 20);
//		queue.offer(stu1);
//		stu1.name="zhangsan";
//		System.out.println(stu1.name);
//		System.out.println(queue.poll().name);//进队的是引用，而非复制！！！！！！
		LinkedList<String> queue = new LinkedList<String>();
		String str1 = new String("wwwww");
		queue.offer(str1);
		
	}//main
}
