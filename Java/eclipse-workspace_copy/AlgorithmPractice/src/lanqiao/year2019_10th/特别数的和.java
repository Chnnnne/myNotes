package lanqiao.year2019_10th;

import java.util.Scanner;

public class 特别数的和 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			String str = i+"";
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j)=='2'||str.charAt(j)=='0'||str.charAt(j)=='1'||str.charAt(j)=='9') {
					sum+=i;
					break;
				}
			}
		}
		System.out.println(sum);

	}// main
}
