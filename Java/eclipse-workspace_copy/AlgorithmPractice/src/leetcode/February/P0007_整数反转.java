package leetcode.February;

import java.util.Arrays;

public class P0007_整数反转 {
	public static void main(String[] args) {
//		int a=-123;
//		String str=a+"";
//		StringBuffer reverse = new StringBuffer(str).reverse();
//		System.out.println(reverse);
		
		System.out.println(new P0007_整数反转().reverse(1000000012));
	}//main
    public int reverse(int x) {
    	boolean flag=false;
    	if(x<0)
    	{
    		flag=true;
    		x=-x;
    	}
    	 String str = new StringBuffer(x+"").reverse().toString();
    	if(flag)
    		str="-"+str;
    	int parseInt = 0;
		try {
    		parseInt = Integer.parseInt(str);
    	}catch (Exception e) {
    		parseInt=0;
		}finally {
			return parseInt;
		}
    	
    }
}
