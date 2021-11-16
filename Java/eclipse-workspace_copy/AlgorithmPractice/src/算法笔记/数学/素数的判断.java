package 算法笔记.数学;

public class 素数的判断 {

	public static void main(String[] args) {
		for(int i=0;i<20;i++) {
			if(isPrime(i)) System.out.print(" "+ i);
		}
	}// main

	private static boolean isPrime(int n) {
		if (n <= 1) return false;
		int sqrt = (int) Math.sqrt(n); // 求根号，并下取整
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}
