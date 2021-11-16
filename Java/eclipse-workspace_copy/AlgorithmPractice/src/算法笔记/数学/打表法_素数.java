package 算法笔记.数学;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class 打表法_素数 {

//	int prime[]=new int [] {,,};

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> al = new ArrayList<Integer>();
		int num = 10010;
		int count = 0;
		for (int i = 2; i < 100000000; i++) {
			if (isPrime(i)) {
				al.add(i);
				count++;
				if (count >= num) {
					System.out.println("finsh!");
					break;
				}
			}
		}
		FileOutputStream fos = new FileOutputStream("C:\\Users\\95266\\Desktop\\test.txt");
		fos.write("{".getBytes() );
		for (int i = 0; i < al.size() - 1; i++) {
			byte[] bytes = (al.get(i)+",").getBytes();
			fos.write(bytes);
		}
		byte[] bs = (al.get(al.size()-1)+"};").getBytes();
		fos.write(bs);
		fos.close();
	}// main

	private static boolean isPrime(int n) {
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
