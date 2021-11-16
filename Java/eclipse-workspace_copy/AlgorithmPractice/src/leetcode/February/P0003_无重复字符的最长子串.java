package leetcode.February;

import java.util.HashSet;

public class P0003_无重复字符的最长子串 {
	public static void main(String[] args) {
		System.out.println(new P0003_无重复字符的最长子串().lengthOfLongestSubstring(""));

	}//main
    public int lengthOfLongestSubstring(String s) {
    	int N=s.length();
    	int left=0,right=0;
    	HashSet<Character> hashSet = new HashSet<Character>();
    	Character c=null;//存放已经出现重复的字符，left需要移动。为null时，代表此时窗口无重复，left无需移动
    	int res=0;
    	while(right<N)
    	{
    		if(hashSet.contains(s.charAt(right))) {
    			c=s.charAt(right);
    		}else {
    			hashSet.add(s.charAt(right));
    		}
    		
    		while(c!=null) {
    			if(c==s.charAt(left)) c=null;
    			else hashSet.remove(s.charAt(left));
    			left++;
    		}
    		
    		res=Math.max(res, right-left+1);
    		right++;
    	}
    	
    	return res;
    }
}
