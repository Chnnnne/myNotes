package algorithm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class PTA3_5_统计英文单词个数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> hm = new HashMap<String,Integer>();
		int T=sc.nextInt();
		while((T--)!=0) {
			hm.clear();
			int n=sc.nextInt();
			String word;
			for (int i = 0; i < n; i++) {
				word=sc.next();
				if(hm.containsKey(word)) {
					hm.put(word, hm.get(word)+1);				
				}else {
					hm.put(word, 1);
				}
			}
			ArrayList<String> al = new ArrayList<>(hm.keySet());
			Collections.sort(al);
			for (String string : al) {
				System.out.println(string+" "+hm.get(string));
			}
			
			
		}

	}//main
}
