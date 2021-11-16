package 算法笔记.数学;

public class 素数表的获得_素数筛 {
	/*
	 * 素数筛的思想：从小到大枚举每一个数， 是素数的话（没有被前边的素数筛掉），就把它加入到素数表然后筛去它的所有倍数
	 * 合数的话(被前面的素数筛掉了)，直接跳过。 用一个bool数组来确定是否是素
	 */
	// 获得1-200之内的所有素数存到一个表中
	public static final int MAXN = 210;

	public static void main(String[] args) {
		Get_primTable();
		for (int i = 0; i < pnum; i++) {
			System.out.print(" "+ primTable[i]);
		}
	}// main

	static int primTable[] = new int[MAXN], pnum = 0;
	static boolean isHe[] = new boolean[MAXN+10];
	//获得1-MAXN范围内的所有素数
	private static void Get_primTable() {
		for(int i = 2; i <= MAXN; i++) {
			if(!isHe[i]) {
				primTable[pnum++] = i;
				for(int j = i; j <= MAXN; j+=i) {
					isHe[j] = true;
				}
			}
		}
	}

}
