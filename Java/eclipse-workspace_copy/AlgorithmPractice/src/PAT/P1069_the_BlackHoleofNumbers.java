package PAT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P1069_the_BlackHoleofNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (true) {
			Integer a[] = ToArray(n);
			Arrays.sort(a);
			int min = ToNumber(a);
			Arrays.sort(a, (o1, o2) -> o2 - o1);
			int max = ToNumber(a);
			System.out.printf("%04d - %04d = %04d\n", max, min, max - min);
			if (max - min == 0 || max - min == 6174)
				break;
			n=max-min;
		}
	}// main

	private static int ToNumber(Integer[] a) {
		int res = 0;
		for (int i = 0; i < a.length; i++) {
			res = res * 10 + a[i];
		}
		return res;
	}

	private static Integer[] ToArray(int n) {
		Integer[] res = new Integer[4];
		for (int i = 0; i < 4; i++) {
			res[3 - i] = n % 10;
			n = n / 10;
		}
		return res;
	}
}
