package algorithm.递归与分治;

import java.util.Scanner;

public class 全排列 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		perm(str.toCharArray(), 0, str.length());

	}//main
	public static void perm(char []arr,int k,int m) {
		if (k==m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}
		else {
			for(int i=k; i<m; i++)
		     {
				char temp=arr[i];
				arr[i]=arr[k];
				arr[k]=temp;
		         perm(arr,  k+1,   m);
		         temp=arr[k];
		         arr[k]=arr[i];
		         arr[i]=temp;
		     }
		}
		
	}
}
