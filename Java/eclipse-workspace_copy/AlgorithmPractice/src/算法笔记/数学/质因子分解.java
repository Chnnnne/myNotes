package 算法笔记.数学;

import java.util.Scanner;

class factor {
	int x, cnt;// 质因子和其个数

	public factor(int x, int cnt) {
		super();
		this.x = x;
		this.cnt = cnt;
	}
}

public class 质因子分解 {

	public static final int MAXN = 100050;
	static int n;

	static factor fac[] = new factor[11];
	static int fnum = 0;

	/*
	 * 质因子分解思路： 
	 * S1:枚举小于sqrt(n)的所有素数
	 *  然后再判断一下能否整除，能的话就加入该质因子，并循环确定质因子的个数
	 * S2:判断n是否为1，否的话直接加入
	 */
	public static void main(String[] args) {
		get_PrimTable();
		n = new Scanner(System.in).nextInt();
		if(n==1) {
			System.out.println("1=1");
			return;
		}
		System.out.print(n+"=");//先打印！！！因为n会变！！
		int sqrt = (int) Math.sqrt(n);
		for (int i = 0; i < pnum && primTable[i] <= sqrt; i++) {
			if (n % primTable[i] == 0) {
				fac[fnum] = new factor(primTable[i], 0);
				while (n % primTable[i] == 0) {
					fac[fnum].cnt++;
					n /= primTable[i];
				}
				fnum++;
			}
			if (n==1) break;
		}
		if(n != 1) fac[fnum++] = new factor(n, 1);
		
		
		for(int i = 0; i < fnum; i++) {
			if(i > 0 )
				System.out.print('*');
			System.out.print(fac[i].x);
			if(fac[i].cnt > 1) 
				System.out.print("^"+fac[i].cnt);
		}
	}// main

	static int primTable[] = new int[MAXN], pnum = 0;
	static boolean isHe[] = new boolean[MAXN + 10];

	private static void get_PrimTable() {
		for (int i = 2; i < MAXN; i++) {
			if (!isHe[i]) {
				primTable[pnum++] = i;
				for (int j = i; j < MAXN; j += i) {
					isHe[j] = true;
				}
			}
		}
	}

}
