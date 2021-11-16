package PAT;

import java.io.IOException;
import java.util.Scanner;

public class P1001_ABFormat {
	public static void main(String[] args) throws IOException {
//		int a = Reader.nextInt();
//		int b = Reader.nextInt();
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int i=2100000000;
		while(i!=0) i--;
		System.out.format("%,d", a+b);
	}//main
}
