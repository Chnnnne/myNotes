package algorithm.递归与分治;

import java.util.Scanner;

public class 矩阵快速幂 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,x;//n*n矩阵  x次幂
		n=sc.nextInt();
		x=sc.nextInt();
		
		mat aMat = new mat(n,n);
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				aMat.m[i][j]=sc.nextLong();
		
		mat resultMat=mat.pow_mat(aMat, x);
		 
		for (int i = 1; i <= resultMat.row; i++) {
			for(int j=1; j <= resultMat.col ; j++)
				System.out.print(resultMat.m[i][j]+" ");
			System.out.println();
		}
	}//main
}


class mat{
	public static final int maxn = 5;
	public static final long MOD = (long) (1e9+7);
	
	int row,col;
	long m[][]=new long[maxn+1][maxn+1];//index from 1
	
	
	public mat() {
		super();
		this.row = 0;
		this.col = 0;
	}
	public mat(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	public void init_unit() {
		if (this.row!=this.col) {
			System.out.println("this is not actually a unit mat, "
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
	
	public static mat multiply(mat a,mat b) {
		if(a.col!=b.row) {
			System.out.println("It doesn't follow the rules of multiplication ");
			return null;
		}
		mat res = new mat(a.row,b.col);
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
	
	public	static mat pow_mat(mat a,long b) {
		if(a.col!=a.row) {
			System.out.println("it's not a unit mat,so it cant do pow");
			return null;
		}
		mat res=new mat(a.row,a.row);
		res.init_unit();
		while(b!=0) {
			if((b&1)!=0)
				res=mat.multiply(res, a);
			a=mat.multiply(a, a);
			b=b>>1;
		}
		return res;
	}
	
	
	
}
