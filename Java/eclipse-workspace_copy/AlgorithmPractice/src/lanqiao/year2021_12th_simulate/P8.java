package lanqiao.year2021_12th_simulate;

import java.io.IOException;

public class P8 {
	public static void main(String[] args) throws IOException {
		int n = Reader.nextInt();
		int m = Reader.nextInt();
		int a[][]=new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			for(int j =1;j <= m; j++) {
				a[i][j]=Reader.nextInt();
				a[i][j]=a[i][j-1]+a[i-1][j]+a[i][j]-a[i-1][j-1];
			}
		}
		int WM=a[n][m];
		int min=9999999;
		int r=-1,c=-1;//子矩阵的前r 行， c列
		for (int i = 1; i <= n; i++) {
			for(int j =1;j <= m; j++) {
				if(Math.abs(2*a[i][j]-WM)<min) {
					r=i;
					c=j;
					min=Math.abs(2*a[i][j]-WM);
				}else if(Math.abs(2*a[i][j]-WM)==min){
					if(i*j<r*c) {
						r=i;
						c=j;
					}else if (i*j==r*c&&i<r) {
						r=i;
						c=j;
					}
					
				}
			}
		}
		System.out.println(r+" "+c);
		
		
		

	}//main
}
