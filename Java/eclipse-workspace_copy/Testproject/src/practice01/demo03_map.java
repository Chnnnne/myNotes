package practice01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;


import java.util.Set;



public class demo03_map {
	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer,String>();
		hm.put(1, "wangchen");
		hm.put(2, "xiaoming");      
		hm.put(3, "xiaohua");
		hm.put(1, "wangchenchen");
		
		ArrayList<String> al = new ArrayList<String>();
		Collections.addAll(al, "aaa","bbb","ccc");
		al.forEach(str->System.out.println(str));
		
		Set<Entry<Integer,String>> entrySet = hm.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			System.out.print(entry.getKey()+" "+entry.getValue());
			
		}
		System.out.println();
//		Comparator<T>
		
		Set<Integer> ks=hm.keySet();
		for(Integer i:ks) {
			System.out.print(i+" "+hm.get(i));
		}
		System.out.println();
		hm.forEach((ing,str)->System.out.println(" "+ing+" "+str));
	}
}
