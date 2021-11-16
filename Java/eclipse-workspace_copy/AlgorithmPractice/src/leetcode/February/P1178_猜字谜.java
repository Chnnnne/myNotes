package leetcode.February;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class P1178_猜字谜 {
	public static void main(String[] args) {
		new P1178_猜字谜().findNumOfValidWords(new String[] {"aaaa","asas","able","ability","actt","actor","access"},
				new String[] {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"});
	}//main
	
	
	
	
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (String puzzle : puzzles) {
            int total = 0;
	            /* 枚举子集方法一
	            // for (int choose = 0; choose < (1 << 6); ++choose) {
	            //     int mask = 0;
	            //     for (int i = 0; i < 6; ++i) {
	            //         if ((choose & (1 << i)) != 0) {
	            //             mask |= (1 << (puzzle.charAt(i + 1) - 'a'));
	            //         }
	            //     }
	            //     mask |= (1 << (puzzle.charAt(0) - 'a'));
	            //     if (frequency.containsKey(mask)) {
	            //         total += frequency.get(mask);
	            //     }
	             }*/
            // 枚举子集方法二
            int mask = 0;
            for (int i = 1; i < 7; ++i) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            int subset = mask;//subset是子集， 是mask后六位的子集，第一位还要手动加上
            do {
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if (frequency.containsKey(s)) {
                    total += frequency.get(s);
                }
                subset = (subset - 1) & mask;
            } while (subset != mask);
            
            ans.add(total);
        }
        return ans;
    }
	

	
	//puzzles是谜面           words是谜底， 谜底数组中每一个都可以作为谜面的谜底
//    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
//    	//对每个谜面，依次遍历每个谜底，看谜底是否可以作为该谜面的谜底
//    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
//    	for (int i = 0; i < puzzles.length;i++) {
//    		arrayList.add(i, 0);
//			for(int j = 0; j < words.length; j++) {
//				if(puzzles[i].contains(words[j]) &&words[j].contains(puzzles[i].charAt(0)+""))
//					arrayList.set(i, 1+arrayList.get(i));
//			}
//		}
//    	System.out.println(arrayList);
//    	
//    	return null;
//    }
}
