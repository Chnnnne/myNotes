package lanqiao.练习系统;

import java.util.Scanner;

public class ADV_334_拼图 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		int divn3 = (int) (n%3);
		int divn2 = (int) (n%2);
		int divm3 = (int) (m%3);
		int divm2 = (int) (n%2);
		
		if(divn3==0&&divn2==0&&divm3==0&&divm2==0) {
			
		}else if(divn3==0&&divn2!=0&&divm3!=0&&divm2==0) {
			System.out.println(Math.pow(2, n/3*m/2));
		}else {
			
		}
	}//main
}
