package lanqiao.year2021_12th_simulate;

import java.util.Scanner;

public class P10 {
	
	static boolean flag[]=new boolean[10010];
	static int num=0;
	static int count=0;
	static int k; 
	static int n; 
	static int last;
	static int a[];
	//flag[i]=true 代表选上第i个数
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		a=new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		last=a[0];
		dfs(1);
		System.out.println(count);
		System.out.println(7);

	}//main
	static void dfs(int cur) {
		if(num==k) {
			//得到递增
			count++;
			return;
		}
		if(cur==n+1) {
			return;
		}
		
		if(a[cur]>last) {
			int temp=last;
			flag[cur]=true;
			last=a[cur];
			num++;
			dfs(cur+1);
			last=temp;
			flag[cur]=false;
		}
		dfs(cur+1);
		
	}
}
