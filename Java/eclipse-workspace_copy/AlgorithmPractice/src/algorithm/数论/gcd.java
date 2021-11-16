package algorithm.数论;

public class gcd {
	public static void main(String[] args) {
		System.out.println(getGcd1(6,4));
		System.out.println(getGcd2(6,4));
	}

	/*
	 * 欧几里得算法  -辗转算法
	 * 
	 * b>a 第1遍循环中，会a=b b=a也即交换
	 * 
	 * 当一个数为0时，最大公约数为另一个数
	 */
	static int getGcd1(int a, int b) {
		int c;
		while(b!=0) {
			c=a%b;
			a=b;
			b=c;
		}
		return a;
	}
	
	/*
	 * 简单枚举
	 */
	static int getGcd2(int a,int b) {
		int gcd=0;
		int min=Math.min(a, b);
		for(int i=1;i<=min;i++)
		{
			if(a%i==0&&b%i==0)
				gcd=i;
		}
		if(gcd==0)
			return Math.max(a, b);
		else
			return gcd;
	}
	
	
}
