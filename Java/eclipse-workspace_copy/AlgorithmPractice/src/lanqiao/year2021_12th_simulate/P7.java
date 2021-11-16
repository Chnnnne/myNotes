package lanqiao.year2021_12th_simulate;

import java.util.Scanner;

public class P7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] charArray = str.toCharArray();
		int length = str.length();
		int num = length/3;
		int one = length%3;
		if(one==0)
			one=3;
		for (int i = 0; i < length; i++) {
			if(one==0) {
				System.out.print(",");
			}
			one=(one-1)%3;
			System.out.print(charArray[i]);
		}
	}//main
}
