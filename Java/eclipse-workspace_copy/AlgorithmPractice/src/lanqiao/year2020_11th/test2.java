package lanqiao.year2020_11th;

import java.util.Scanner;

public class test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char c[] = {'a','b','c','d','e','f','g'};
		String a[] = new String[128];
		for(int i = 1;i<128;i++) {
			a[i] = sc.nextLine();
		}
		for(int i = 1;i<128;i++) {
			for(int j = 0;j<a[i].length();j++) {
				if(a[i].charAt(j)=='1') {
					System.out.print(c[j]);
				}
			}
			System.out.println();
		}
		
	}

}
