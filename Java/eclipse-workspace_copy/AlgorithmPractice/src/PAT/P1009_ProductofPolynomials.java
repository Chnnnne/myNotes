package PAT;

import java.io.IOException;

public class P1009_ProductofPolynomials {
	static double nums[]=new double[1003];//nums[i]=value 代表指数为i的系数为value
	static double ans[]=new double[2003];//nums[i]=value 代表指数为i的系数为value
	public static void main(String[] args) throws IOException {
		int zhi;
		double xi;
		int K1,K2,count=0;
		K1=Reader.nextInt();
		while(K1--!=0) {
			zhi=Reader.nextInt();
			xi=Reader.nextDouble();
			nums[zhi]=xi;
		}
		K2=Reader.nextInt();
		while(K2--!=0) {
			zhi=Reader.nextInt();
			xi=Reader.nextDouble();
			for(int i=0;i<=1000;i++) {
				if(nums[i]!=0) {
					ans[zhi+i]+=nums[i]*xi;
				}
			}
		}
		for(int i=0;i<=2000;i++)
		{
			if(ans[i]!=0)
				count++;
		}
		System.out.print(count);
		for(int i=2000;i>=0;i--)
		{
			if(ans[i]!=0)
				System.out.printf(" %d %.1f",i,ans[i]);
		}

	}//main
	
	
}
