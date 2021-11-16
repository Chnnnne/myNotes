package AcWing.搜索;

import java.util.ArrayList;
import java.util.List;

public class leetcode_P0131分割子串 {
	public static void main(String[] args) {
		

	}//main
	
	//题意:给定一个字符串，求将s分割成回文子串的所有方案
	
	public List<List<String>> partition(String s) {
		char[] charArray = s.toCharArray();
		int len=s.length();
		boolean [][]dp=new boolean[len][len];
		for(int hwlenth=1;hwlenth<=len;hwlenth++) {
			for(int i=0;i+hwlenth-1<len;i++) {
				int t=i+hwlenth-1;
				if(hwlenth==1)dp[i][t]=true;
				if(hwlenth==2)dp[i][t]= (charArray[i]==charArray[t]);
				if(hwlenth>2) dp[i][t]= (dp[i+1][t-1]&&charArray[i]==charArray[t]);
			}
		}
		
		dfs(0,len,dp,s);
		return res;
	}
	List<List<String>> res = new ArrayList<List<String>>();
	ArrayList<String> temp = new ArrayList<String>();
	
	//访问第curStart位置
	void dfs(int curStart, int len, boolean[][] dp, String s) {
		//目标状态
		if(curStart>=len) {
			res.add(new ArrayList<>(temp));
			return;
		}
		
		
		for(int i=curStart;i<len;i++) {
			if(dp[curStart][i]) {
				temp.add(s.substring(curStart, i+1));
				dfs(i+1, len, dp, s);
				temp.remove(temp.size()-1);
			}
		}
		
	}
		
}
