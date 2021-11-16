package leetcode.February;

import java.util.Arrays;

import javax.swing.text.html.CSS;

public class P0395_至少有K个重复字符的最长子串 {
	
	public static void main(String[] args) {
		

	}//main
	
	
	
	//s仅有小写字母组成， 求s的最长子串长度 (子串满足每一个字符出现的次数都不小于k)
    public int longestSubstring(String s, int k) {
    	//滑动窗口升级版,外加条件，窗口中字符的种类数不得超过p
    	
    	int n=s.length();
    	//左右指针
    	int left=0,right=0;
    	//辅助窗口变量
    	int kind=0,satsum=0,cnt []=new int[26];//kind字符种类数,msatsum是满足大于k的字符种类数数
    	//没设置这个条件(kind)之前，左右移动指针会造成窗口不满足条件
    	//设了这个条件(kind)之后
    	int ret=0;
    	for(int p=1;p<=26;p++) {
    		Arrays.fill(cnt, 0);
    		left=0;right=0;kind=0;satsum=0;
    		while(right<n) {
    			int u=s.charAt(right)-'a';
    			cnt[u]++;
    			if(cnt[u]==1) kind++;
    			if(cnt[u]==k) satsum++;
    			
    			while(kind > p) {
    				int t=s.charAt(left++)-'a';
    				cnt[t]--;
    				if(cnt[t]==0) kind--;
    				if(cnt[t]==k-1) satsum--;
    			}
    			
    			if(kind==satsum) ret=Math.max(ret, right-left+1);
    			right++;
    		}
    		
    	}
    	return ret;
    }
}
