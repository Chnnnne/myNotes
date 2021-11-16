package leetcode.March.DFS;

import java.util.ArrayList;
import java.util.List;

public class P0131_分割回文串_提交LeetCode {
//	public static void main(String[] args) {
//		dfs(0,"aab");
//		System.out.println(res);
//
//	}//main
	
	
	
	
	List<List<String>> res = new ArrayList<List<String>>();
	ArrayList<String> temp = new ArrayList<String>();
	boolean dp[][]=new boolean[1000][1000];
    public List<List<String>> partition(String s) {
    	int len=s.length();
		char[] charArray = s.toCharArray();
		for(int i=1;i<=len;i++) {//子串长度
			for(int j=0;j<=len-i;j++) {//起始下标
				int tem=j+i-1;//终点下标
				if(i==1) dp[j][j]=true;
				if(i==2&&charArray[j]==charArray[tem]) dp[j][j+1]=true;
				if(i>2)	dp[j][tem]=(dp[j+1][tem-1])&&(charArray[j]==charArray[tem]);
			}
		}
    	dfs(0, s);
    	return res;
    }
	
    void dfs(int curStart,String str) {
    	//目标状态
    	if(curStart==str.length()) {
    		res.add(new ArrayList<String>(temp));//拷贝 注意堆栈关系
    		return;
    	}
    	
    	//合法状态
    	for(int i=curStart;i<str.length();i++) {
    		if(HuiWen(str,curStart,i)) {
    			temp.add(str.substring(curStart, i+1));
    			dfs(i+1,str);
    			temp.remove(temp.size()-1);
    		}
    	}
    }

	boolean HuiWen(String str, int curStart, int i) {
		return dp[curStart][i];
	}
    
//  public List<List<String>> partition(String s) {
//	
//	
//	
//	return res;
//}
}
