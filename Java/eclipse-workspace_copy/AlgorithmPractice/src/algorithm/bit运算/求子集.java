package algorithm.bit运算;

import java.math.BigInteger;
import java.util.ArrayList;

public class 求子集 {
	public static void main(String[] args) {
		int k=0b1001;
	    int sub = k;
	    ArrayList<Integer> subset = new ArrayList<Integer>();
	    do {
	    	subset.add(sub);
	        sub = (sub - 1) & k;
	    } while(sub != k);
	}//main
}
