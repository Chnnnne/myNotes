package leetcode.April;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;


public class P781_森林中的兔子 {
	public static void main(String[] args) {
		System.out.println(new P781_森林中的兔子().numRabbits(new int[] {1,1,2}));

	}//main
	
    public int numRabbits(int[] answers) {
    	int sum = 0;
    	int N = answers.length;
    	HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
    	for(int i = 0; i < N; i++) {
    		hm.put(answers[i], hm.getOrDefault(answers[i], 0)+1 );
    	}
    	Set<Entry<Integer,Integer>> entrySet = hm.entrySet();
    	for (Entry<Integer, Integer> entry : entrySet) {
    		int size = entry.getKey()+1;
			sum+=(entry.getValue()-1)/size*(size)+size;
		}
		return sum;
    }
}
