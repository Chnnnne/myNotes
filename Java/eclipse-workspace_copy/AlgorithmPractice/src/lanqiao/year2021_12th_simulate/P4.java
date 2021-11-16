package lanqiao.year2021_12th_simulate;

import java.util.Scanner;

public class P4 {
	public static void main(String[] args) {
		int a[]=new int[1000000];
		Scanner sc = new Scanner(System.in);
		int p=sc.nextInt();
		int v=sc.nextInt();
		a[1]=v;
		int i;
		for(i=2;;i++) {
			a[i]=p%a[i-1];
			if(a[i]<=0)break;
		}
		i--;
		System.out.println(i);

	}//main
}
