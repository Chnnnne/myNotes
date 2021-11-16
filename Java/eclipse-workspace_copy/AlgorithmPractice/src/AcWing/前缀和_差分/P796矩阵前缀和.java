package AcWing.前缀和_差分;

import java.io.IOException;

public class P796矩阵前缀和 {
	public static void main(String[] args) throws IOException {
		int n = Reader.nextInt();
		int m = Reader.nextInt();
		int q = Reader.nextInt();
		int a[][]=new int[n+1][m+1];
		int presum[][]=new int[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				a[i][j]=Reader.nextInt();
			}
		}
		
		//求矩阵前缀和
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				presum[i][j]=presum[i-1][j]+presum[i][j-1]+a[i][j]-presum[i-1][j-1];
			}
		}
		
		//求子矩阵和
		while(q--!=0) {
			int x1 = Reader.nextInt();
			int y1 = Reader.nextInt();
			int x2 = Reader.nextInt();
			int y2 = Reader.nextInt();
			System.out.println(
			presum[x2][y2]-presum[x2][y1-1]-presum[x1-1][y2]+presum[x1-1][y1-1]		
					);
			
		}
		
	}//main
}
