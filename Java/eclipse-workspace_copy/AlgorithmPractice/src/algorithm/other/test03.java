package algorithm.other;

import java.util.ArrayList;
import java.util.HashMap;


public class test03 {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		System.out.println(al);
		//al.get(1)+=2;编译失败
		
		
		hm.put("wangchen",1 );
		hm.put("lihua",2 );
		hm.put("xiaohong",3 );
//		hm.get("wangchen")++;
		System.out.println(hm);
	}//main
}
