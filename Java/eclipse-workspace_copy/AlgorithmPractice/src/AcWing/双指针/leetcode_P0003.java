package AcWing.双指针;

import java.util.HashSet;

public class leetcode_P0003 {
	public static void main(String[] args) {
		

	}//main
	 public int lengthOfLongestSubstring(String s) {
		 int N=s.length();
		 char[] charArray = s.toCharArray();
		 int left=0,right=0;
		 HashSet<Character> hs = new HashSet<Character>();
		 Character flag=null;
		 int res=0;
		 while(right<N) {
			 if(hs.contains(charArray[right]))
				 flag=charArray[right];
			 else {
				hs.add(charArray[right]);
			}
			 
			 while(left<right&&flag!=null) {
				 if(charArray[left]==flag)
					 flag=null;
				 else 
					 hs.remove(charArray[left]);
				 left++;
			 }
			 
			 res=Math.max(res, right-left+1);
			 right++;
		 }
		 
		 return res;
     }
}
