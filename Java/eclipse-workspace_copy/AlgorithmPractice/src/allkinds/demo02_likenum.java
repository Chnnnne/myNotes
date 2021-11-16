package allkinds;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;

//不要包语句、类名为Main
public class demo02_likenum {
	public static void main(String[] args) {
		int n=new Scanner(System.in).nextInt();
		int sum=0;
		for (int i = 1; i <= n; i++) {
			String str=i+"";
			char[] charArray = str.toCharArray();
			for (int j = 0; j < charArray.length; j++) {
				if(charArray[j]=='2'||charArray[j]=='0'||charArray[j]=='1'||charArray[j]=='9') {
					sum+=i;
					break;
				}
			}
		}
		System.out.println(sum);
	}//main
	
}
