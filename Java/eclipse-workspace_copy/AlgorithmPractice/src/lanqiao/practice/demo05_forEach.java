package lanqiao.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;


public class demo05_forEach {
	public static void main(String[] args) {
		demo05_forEach obj = new demo05_forEach();
		obj.test2();
		
		
	}//main
	public void test1() {
		ArrayList<String> al = new ArrayList<String>();
		Collections.addAll(al, "aaa","bbb","ccc","ddd");
		System.out.println("初始化：\t"+al);
		
		Collections.shuffle(al);
		System.out.println("打乱后\t"+al);
		
		Collections.sort(al);
		System.out.println("默认排序后（升序）"+al);
		
		Collections.sort(al, (o1,o2)-> o2.charAt(0)-o1.charAt(0) );
		System.out.println("使用lambda排后:"+al);
		
		//消费每一个
		al.forEach(s1->{
			char c=s1.charAt(s1.length()-1);
			System.out.println(s1+c);
		});
	}
	
	public void test2() {
		HashMap<String, Integer> hm = new HashMap<String,Integer>();
		hm.put("wangchen", 99);
		hm.put("lisi", 90);
		hm.put("zhangsan", 65);
		Set<Entry<String, Integer>> es = hm.entrySet();
		for (Entry<String, Integer> entry : es) {
			System.out.println(entry.getKey()+" ： "+entry.getValue());
		}
		System.out.println();
		
		//消费每一个键值对
		hm.forEach((str,intg)->{
			System.out.println(str+intg);
		});
		
	}
}
