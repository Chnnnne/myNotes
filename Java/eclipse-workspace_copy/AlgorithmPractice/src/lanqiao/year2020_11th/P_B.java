package lanqiao.year2020_11th;

public class P_B {
	public static void main(String[] args) {
		int count=0;
		for(int i=1;i<=2020;i++) {
			for(int j=1;j<=2020;j++) {
				if(gcd(i, j)==1)
					count++;
			}
		}
		System.out.println(count);
	}//main
	
	static int gcd(int a, int b) {
		if(b==0) return a;
		else return gcd(b, a%b);
	}
}
