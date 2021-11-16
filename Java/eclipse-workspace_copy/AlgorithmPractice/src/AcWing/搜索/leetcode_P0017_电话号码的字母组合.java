package AcWing.搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_P0017_电话号码的字母组合 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new 
				leetcode_P0017_电话号码的字母组合().
				numtowords(0, "9")));

	}//main
	
	StringBuilder sb = new StringBuilder();
	ArrayList<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
    	if (digits.isEmpty()) {
    		return res;
		}
    	int len=digits.length();
    	dfs(0,len,digits);
    	return res;
    }
	private void dfs(int cur, int len, String digits) {
		if(cur>=len) {
			res.add(sb.toString());
			return;
		}
		
		char[] arr = numtowords(cur,digits);
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			dfs(cur+1, len, digits);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	private char[] numtowords(int cur, String digits) {
		char c = digits.charAt(cur);
		switch (c) {
		case '2':
			return new char[] {'a','b','c'};
		case '3':
			return new char[] {'d','e','f'};
		case '4':
			return new char[] {'g','h','i'};
		case '5':
			return new char[] {'j','k','l'};
		case '6':
			return new char[] {'m','n','o'};
		case '7':
			return new char[] {'p','q','r','s'};
		case '8':
			return new char[] {'t','u','v'};
		case '9':
			return new char[] {'w','x','y','z'};
		default:
			return null;
		}
	}
    
}
