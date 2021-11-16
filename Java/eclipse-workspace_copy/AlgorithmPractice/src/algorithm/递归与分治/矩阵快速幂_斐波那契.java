package algorithm.递归与分治;

import java.util.Scanner;

public class 矩阵快速幂_斐波那契 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long k;
		while((k=sc.nextLong())!=-1) {
			if(k==0)
				System.out.println("0");
			else if (k==1||k==2) {
				System.out.println("1");
			}else {
				matrix a = new matrix(1,3);
				matrix b = new matrix(3,3);
				b.m[1][1]=1;b.m[1][2]=1;b.m[1][3]=0;
				b.m[2][1]=1;b.m[2][2]=0;b.m[2][3]=1;
				b.m[3][1]=0;b.m[3][2]=0;b.m[3][3]=0;
				
				a.m[1][1]=1;a.m[1][2]=1;a.m[1][3]=0;
				
				b=matrix.pow_mat(b, k-2);
				
				a=matrix.multiply(a, b);
				System.out.println((a.m[1][1])%10000);
			}
		}
	}//main
}


class matrix{
	public static final int maxn = 5;
	public static final long MOD = 10000;
	
	int row,col;
	long m[][]=new long[maxn+1][maxn+1];//index from 1
	
	
	public matrix() {
		super();
		this.row = 0;
		this.col = 0;
	}
	public matrix(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	public void init_unit() {
		if (this.row!=this.col) {
			System.out.println("this is not actually a unit matrix, "
					+ "so you can't init it. Plz reset the row and col");
		}
		for (int i = 0; i <= this.row; i++) {
			for (int j = 0; j <= this.row; j++) {
				if(i==j) this.m[i][j]=1;
				else
					this.m[i][j]=0;
			}
		}
	}
	
	public static matrix multiply(matrix a,matrix b) {
		if(a.col!=b.row) {
			System.out.println("It doesn't follow the rules of multiplication ");
			return null;
		}
		matrix res = new matrix(a.row,b.col);
		long temp=0;
		for (int i = 1; i <= res.row; i++) {
			for(int j= 1; j <= res.col; j++) {
				temp=0;
				for(int k=1;k<=a.col;k++)
					temp+=(a.m[i][k]*b.m[k][j])%MOD;
				res.m[i][j]=temp;
			}
		}
		return res;
	}
	
	public	static matrix pow_mat(matrix a,long b) {
		if(a.col!=a.row) {
			System.out.println("it's not a unit matrix,so it cant do pow");
			return null;
		}
		matrix res=new matrix(a.row,a.row);
		res.init_unit();
		while(b!=0) {
			if((b&1)!=0)
				res=matrix.multiply(res, a);
			a=matrix.multiply(a, a);
			b=b>>1;
		}
		return res;
	}
	
	
	
}
