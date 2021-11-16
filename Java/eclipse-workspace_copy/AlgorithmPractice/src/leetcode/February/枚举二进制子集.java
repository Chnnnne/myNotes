package leetcode.February;

import java.math.BigInteger;

public class 枚举二进制子集 {
	public static void main(String[] args) {
		int x=0b1001;
		for (int i=x;i!=0;i=(i-1)&x)
	    {
	        System.out.printf(new BigInteger(i+"",10).toString(2)); 
	    }
		System.out.println("以上不包含0，以下包含0");
		
		int k=0b1010;
	    int sub = k;
	    do {
	        sub = (sub - 1) & k;
	        System.out.println(new BigInteger(sub+"",10).toString(2));
	    } while(sub != k);

	}//main
}
