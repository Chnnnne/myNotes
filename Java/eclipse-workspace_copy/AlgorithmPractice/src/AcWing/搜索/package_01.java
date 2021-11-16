package AcWing.搜索;

import java.util.Scanner;

public class package_01 {
	//给定n个物品的重量和价值。求一个书包里能装的最大价值数。
	static final int MAXN=20;
	static int Weight=0;
	static int n=0;
	static int w[]=new int[MAXN];
	static int v[]=new int[MAXN];
	
	static int prize=0;
	static int MaxPrize=0;
	static boolean choose[]=new boolean[MAXN];
	static boolean MaxChoose[]=new boolean[MAXN];
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Weight=sc.nextInt();
		for(int i=0;i<n;i++) {
			w[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			v[i]=sc.nextInt();
		}
		
		dfs(0);
		System.out.println(MaxPrize);
	}//main
	static void dfs(int cur) {
		//目标状态
		if(cur>=n) {
			if(prize>MaxPrize) {
				MaxPrize=prize;
				System.arraycopy(choose, 0, MaxChoose, 0, n);
			}
			return;
		}
		
		//不选
		dfs(cur+1);
		
		//选
		if(Weight>=w[cur]) {
			choose[cur]=true;
			Weight-=w[cur];
			prize+=v[cur];
			dfs(cur+1);
			choose[cur]=false;
			Weight+=w[cur];
			prize-=v[cur];
		}
		
	}
}
