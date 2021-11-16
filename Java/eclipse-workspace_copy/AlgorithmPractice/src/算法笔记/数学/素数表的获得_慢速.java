package 算法笔记.数学;

public class 素数表的获得_慢速 {

	//题意：获得1-n范围内的所有素数，存到一个素数表中,假如我们想获得两百以内的
	
	// 首先确定两个范围： 想要获得的最大的素数是多少、想要获得的素数表的最大长度是多少
	// 简单化：我们可以把最大素数就作为素数表的长度,也即素数表尽量大一点
	public static final int MAXN = 230;// 最大的素数、素数表的最大长度


	public static void main(String[] args) {
		Get_primeTable();
		//打印素数表
		for (int i = 0; i < pnum; i++) {
			System.out.print(" "+primTable[i]);
		}
	}// main

	
	static int primTable[] = new int[MAXN],pnum = 0;
	
	private static void Get_primeTable() {
		for(int i=2;i<=MAXN;i++) {
			if(isPrime(i)) primTable[pnum++]=i;
		}
	}

	static boolean isPrime(int n) {
		if (n <= 1) return false;
		int sqr = (int) Math.sqrt(n);
		for (int i = 2; i <= sqr; i++) {
			if (n % i == 0)	return false;
		}
		return true;
	}
}
