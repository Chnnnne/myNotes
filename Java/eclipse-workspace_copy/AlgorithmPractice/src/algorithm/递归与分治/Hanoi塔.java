package algorithm.递归与分治;

public class Hanoi塔 {
	
	public static void main(String[] args) {
		Hanoi(3, 'a', 'b', 'c');
	}//main
	public static void Hanoi(int n,char A,char B,char C) {
		if(n>=1) {
			Hanoi(n-1, A, C, B);
			System.out.println("将圆盘"+n+"从"+A+"移动到"+C);
			Hanoi(n-1, B, A, C);
		}
	}
}
