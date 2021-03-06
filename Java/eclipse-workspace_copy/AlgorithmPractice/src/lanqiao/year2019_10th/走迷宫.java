package lanqiao.year2019_10th;

import java.util.Scanner;


import lanqiao.练习系统.nothing;

class point {
	int x, y;

	public point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		point other = (point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "point [x=" + x + ", y=" + y + "]";
	}

}

public class 走迷宫 {
	public static final int MAXN = 100;

	static int n, m;
	static int g[][] = new int[MAXN][MAXN];
	static int dist[][] = new int[MAXN][MAXN];
	point pre[][] = new point[10009][10009];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			char[] charArray = str.toCharArray();
			for (int j = 0; j < m; j++) {
				g[i][j]=charArray[j]-'0';
			}

		}

	}// main
}
