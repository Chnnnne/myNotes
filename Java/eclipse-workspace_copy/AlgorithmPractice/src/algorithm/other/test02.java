package algorithm.other;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class test02 {
	public static void main(String[] args) {
		TreeMap<String,Integer> treeMap = new TreeMap<String,Integer>((o1,o2)->o2.compareTo(o1));
		treeMap.put("aaa", 25);
		treeMap.put("zzz", 2);
		treeMap.put("bbb", 5);
		treeMap.put("yyy", 250);
		treeMap.put("ccc", 19);
		treeMap.put("xxx", 17);
		Set<Entry<String,Integer>> entrySet = treeMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey());
		}
	}//main
}
