package AcWing.双指针;

import java.util.Iterator;
import java.util.Scanner;

public class P2816_双数组双指针 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//短
		int m = sc.nextInt();//长
		int a[]=new int[n];
		int b[]=new int[m];
		for (int i = 0; i < n; i++) {
			a[i]=sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			b[i]=sc.nextInt();
		}
		
		int i=0,j=0;
		while(i<n&&j<m) {
			if(a[i]==b[j]) i++;
			j++;
		}
		if(i==n) System.out.println("Yes");
		else System.out.println("No");

	}//main
}
