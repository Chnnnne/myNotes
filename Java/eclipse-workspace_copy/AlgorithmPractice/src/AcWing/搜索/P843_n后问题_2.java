package AcWing.搜索;

import java.util.Arrays;
import java.util.Scanner;

public class P843_n后问题_2 {
	static final int MAXN=20;
	static int n;
	static int flag[]=new int[MAXN];
	static boolean col[]=new boolean[MAXN]; 
	static boolean mdg[]=new boolean[2*MAXN]; 
	static boolean udg[]=new boolean[2*MAXN]; 
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dfs(1);
		
		
	}//main
	
	
	//访问第flag的第cur个位置
	static void dfs(int cur) {
		if(cur>n) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(flag[i]==j) System.out.print("Q");
					else System.out.print(".");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=n;i++) {
			if(!col[i]&&!mdg[i-cur+MAXN]&&!udg[i+cur]) {
				flag[cur]=i;
				col[i]=true;
				mdg[i-cur+MAXN]=true;
				udg[i+cur]=true;
				dfs(cur+1);
				flag[cur]=0;
				col[i]=false;
				mdg[i-cur+MAXN]=false;
				udg[i+cur]=false;
			}
		}
	}
}
