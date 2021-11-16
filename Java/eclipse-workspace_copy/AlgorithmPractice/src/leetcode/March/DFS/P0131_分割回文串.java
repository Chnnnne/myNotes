package leetcode.March.DFS;

import java.util.ArrayList;
import java.util.List;

public class P0131_分割回文串 {
	static	String str="aab";
	/*
	 * 判断一个子串是否是回文，朴素的方法是O(n)
	 * 因此当判断一个字符串中的一些子串是否是回文时，需要O(n^3)
	 * 使用dp思想，dp之后，在判断是否回文就变成O(1)了
	 * 此题需要多次的判断子串是否是回文，因此可以用dp的方法
	 * dp[i][j]=true的含义是i-j代表的子串是否是回文串
	 * 递推公式
	 * - dp[i][i]=true;
	 * - dp[i][i+1]=(arr[i]==arr[i+1])
	 * - dp[i][j]=(dp[i+1][j-1])&&(arr[i]==arr[j])
	 * 
	*/
	static boolean dp[][]=new boolean[str.length()][str.length()];
	public static void main(String[] args) {
		int len=str.length();
		char[] charArray = str.toCharArray();
		for(int i=1;i<=len;i++) {//子串长度
			for(int j=0;j<=len-i;j++) {//起始下标
				int tem=j+i-1;//终点下标
				if(i==1) dp[j][j]=true;
				if(i==2&&charArray[j]==charArray[tem]) dp[j][j+1]=true;
				if(i>2)	dp[j][tem]=(dp[j+1][tem-1])&&(charArray[j]==charArray[tem]);
			}
		}
		dfs(0);
		System.out.println(res);
		
	}//main
	static List<List<String>> res = new ArrayList<List<String>>();
	static ArrayList<String> temp = new ArrayList<String>();
	
    static void dfs(int curStart) {
    	//目标状态
    	if(curStart==str.length()) {
    		res.add(new ArrayList<String>(temp));//拷贝 注意堆栈关系
    		return;
    	}
    	
    	//合法状态
    	for(int i=curStart;i<str.length();i++) {
    		if(HuiWen(curStart,i)) {
    			temp.add(str.substring(curStart, i+1));
    			dfs(i+1);
    			temp.remove(temp.size()-1);
    		}
    	}
    }

	static boolean HuiWen(int curStart, int i) {
//		for(int left=curStart,right=i;left<right;left++,right--) {
//			if(str.charAt(left)!=str.charAt(right)) {
//				return false;
//			}
//		}
//		if(dp[curStart][i])
//			return true;
//		return false;
		return dp[curStart][i];
	}
}
