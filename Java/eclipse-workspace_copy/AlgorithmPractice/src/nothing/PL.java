package nothing;

import java.util.Scanner;

public class PL {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[]=new int[n];
		int sum=0;
		int max=-1;
		for (int i = 0; i < n; i++) {
			a[i]=sc.nextInt();
			if(a[i]>max) max=a[i];
			sum+=a[i];
		}
		if(sum-max>max) System.out.println("Yes");
		else {
			 System.out.println("No");
		}
		

	}//main
}
