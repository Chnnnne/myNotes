package AcWing.前缀和_差分;

import java.io.IOException;

public class P797差分 {
	public static void main(String[] args) throws IOException {
		int N = Reader.nextInt();//数组数
		int M = Reader.nextInt();//操作数
		int a[]=new int[N+10];//原数组
		int b[]=new int[N+10];//差分数组
		
		for (int i = 1; i <= N; i++) a[i]=Reader.nextInt();
		
		for(int i=1;i<=N;i++)	insert(i,i,a[i],b);
		
		while(M--!=0) {
			int l=Reader.nextInt();
			int r=Reader.nextInt();
			int c=Reader.nextInt();
			insert(l, r, c, b);
		}
		for(int i=1;i<=N;i++) a[i]=a[i-1]+b[i];
		for(int i=1;i<=N;i++) System.out.print(a[i]+" ");;
		
	}//main
	
	static void insert(int l,int r,int c,int b[]) {
		b[l]+=c;
		b[r+1]-=c;
	}
}

//		//求差分数组
//		for(int i=1;i<=N;i++) {
//			b[i]=a[i]-a[i-1];
//		}
//		for (int i = 0; i < M; i++) {
//			int l = Reader.nextInt();
//			int r = Reader.nextInt();
//			int c = Reader.nextInt();
//			b[l]+=c;
//			b[r+1]-=c;//此步可能越界，因此B数组要多开
//		}
//		a[1]=a[0]+b[1];
//		System.out.print(b[1]);
//		for(int i=2;i<=N;i++) {
//			a[i]=a[i-1]+b[i];
//			System.out.print(" "+a[i]);
//		}