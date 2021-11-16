package lanqiao.year2020_11th;

public class P_C {
	static int a[][] = new int[1000][1000];
	static int res = 1;
	public static void main(String[] args) {
		for (int i = 1; i <= 20; i++) {
			res = res + (i-1)*4;
		}
		System.out.println(res);
	}// main

}
