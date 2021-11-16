package 算法笔记.数学;

class fra {
	int up, down;
}

public class fraction {

	public static void main(String[] args) {

	}// main

	// 给定一个分数，将其化简
	static fra reduction(fra result) {
		if (result.down < 0) {
			result.up = -result.up;
			result.down = -result.down;
		}
		if (result.up == 0)
			result.down = 1;
		else {
			int d = gcd(Math.abs(result.up), Math.abs(result.down));
			result.up /= d;
			result.down /= d;
		}

		return result;
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

}
