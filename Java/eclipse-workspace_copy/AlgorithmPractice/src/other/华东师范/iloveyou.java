package other.华东师范;

import java.util.Scanner;

public class iloveyou {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next(); 
		char[] carry1 = str1.toCharArray(); int len1 = str1.length(); int idx1 = 0;
		String str2 = sc.next(); 
		char[] carry2 = str2.toCharArray();int len2 = str2.length(); int idx2 = 0;
		for(idx1 = 0 ; idx1 < len1 ;idx1++) {
			if(carry1[idx1] == carry2[idx2]) {
				idx2++;
				if(idx2==len2)break;
			}
		}
		if(idx2 == len2) System.out.println("Yes");
		else System.out.println("No");
	}//main
}
