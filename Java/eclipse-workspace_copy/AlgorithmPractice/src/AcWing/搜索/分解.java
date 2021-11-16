package AcWing.搜索;

import java.util.Scanner;

public class 分解 {
	static final int MAXN = 30;
	
	//输出n的分解，后面的大于等于前面的
	static int choose[]=new int[MAXN];
	static int last=1;//上一个数
	static int remain=0;//剩余的和
	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		remain=6;
		dfs(1);
	}//main
	private static void dfs(int i) {
		if(remain==0) {
			for(int j=1;j<i;j++)
				System.out.print(choose[j]+" ");
			System.out.println();
				return;
		}
		if(i>m) return;
		
		for(int j=last;j<=remain;j++) {
			int temp=last;
			choose[i]=j;
			last=j;
			remain-=j;
			dfs(i+1);
			choose[i]=0;
			last=temp;
			remain+=j;
		}
	}
}
