package AcWing.搜索2;

import java.util.Scanner;


public class n皇后_2 {
	public static final int MAXN = 20;
	static int n=0;
	static int flag[]=new int[MAXN];
	static boolean []col=new boolean[MAXN];
	static boolean []mdg=new boolean[2*MAXN];
	static boolean []udg=new boolean[2*MAXN];
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		init();
		dfs(1);
		
	}//main
	
	private static void init() {
//		Arrays.f
	}

	//解空间状态是 flag[i]数组 flag[i]=j 代表带i行第j列为皇后
	static void dfs(int cur) {
		//目标状态
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
		
		
		//合法状态
		for(int i=1;i<=n;i++) {
			if(!col[i]&&!mdg[i-cur+MAXN]&&!udg[i+cur]) {
				flag[cur]=i;col[i]=true;mdg[i-cur+MAXN]=true;udg[i+cur]=true;
				dfs(cur+1);
				flag[cur]=0;col[i]=false;mdg[i-cur+MAXN]=false;udg[i+cur]=false;
			}
		}
		
	}
	
}
