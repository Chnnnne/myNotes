package algorithm.数论;

public class lcm {
	public static void main(String[] args) {
		System.out.println(getLcm(4, 6));

	}//main
	static int getLcm(int a,int b) {
		return a*b/getGcd1(a, b);
	}
	
	static int getGcd1(int a, int b) {
		int c;
		while(b!=0) {
			c=a%b;
			a=b;
			b=c;
		}
		return a;
	}
}
