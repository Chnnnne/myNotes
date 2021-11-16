package PAT.BasicLevel;

import java.util.ArrayList;
import java.util.Scanner;

public class P1013_数素数 {

	public static final int MAXN = 10000010;
	static int m, n;
	static boolean isHe[] = new boolean[MAXN];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		ArrayList<Integer> primeList = FindPrime(1000000);
		int num = 0;
		for(int i =0 ;i<primeList.size();i++) {
			if ((i+1)% 10 == 0 && i==primeList.size()-1)
				System.out.print(" "+primeList.get(i));
			else if ((i+1)% 10 == 0 ) {
				System.out.println(" "+primeList.get(i));
			}
			else if((i+1) % 10 == 1)
				System.out.print(primeList.get(i));
			else
				System.out.print(" "+ primeList.get(i));
		}
//		for (Integer integer : primeList) {
//			num++;
//			if (num % 10 == 0)
//				System.out.println(integer);
//			else if(num % 10 == 1)
//				System.out.print(integer);
//			else
//				System.out.print(" "+ integer);
//		}
	}// main

	private static ArrayList<Integer> FindPrime(int x) {
		int count = 0;
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 2; i <= x; i++) {
			if (!isHe[i]) {
				count++;
				if (count >= m)
					res.add(i);
				if (count >= n)
					break;
				for (int j = i + i; j <= x; j += i) {
					isHe[j] = true;
				}
			}
		}
		return res;
	}
}
