package AcWing.前缀和_差分;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P798_差分矩阵 {
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = Reader.nextInt();
		int m = Reader.nextInt();
		int q = Reader.nextInt();
		int a[][]=new int[n+5][m+5];
		int b[][]=new int[n+5][m+5];
		//求差分数组
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				insert(i, j, i, j, Reader.nextInt(), b);
			}
		}
		//给区间加上值
		while(q--!=0) {
			int x1 = Reader.nextInt();
			int y1 = Reader.nextInt();
			int x2 = Reader.nextInt();
			int y2 = Reader.nextInt();
			int c = Reader.nextInt();
			insert(x1, y1, x2, y2, c, b);
		}
		
		//求原矩阵a,也即b矩阵的前缀和矩阵
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				b[i][j]=b[i][j-1]+b[i-1][j]+b[i][j]-b[i-1][j-1];
			}
		}
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				out.print(b[i][j]+" ");
			}
			out.println();
		}
		out.close();
		
		
		
	}//main
	//给原数组a (x1,y1,x2,y2)区间加上c
	static void insert(int x1,int y1,int x2,int y2,int c,int b[][]) {
		b[x1][y1]+=c;
		b[x1][y2+1]-=c;
		b[x2+1][y1]-=c;
		b[x2+1][y2+1]+=c;
	}
	
}
