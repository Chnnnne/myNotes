package AcWing.图论;

import java.beans.Visibility;
import java.util.Arrays;
import java.util.Scanner;

public class 树的重心 {
	
	static final int MAXN=100010;
	static int n;
	static int h[]=new int[MAXN],e[]=new int[2*MAXN],
			ne[]=new int[2*MAXN],idx=0;
	static boolean visited[]=new boolean[MAXN];
	static int ans=MAXN;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Arrays.fill(h, -1);
		for (int i = 0; i < n-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			Add(a, b);
			Add(b, a);
		}
		dfs(1);
		System.out.println(ans);

	}//main
	
	//递归函数的作用：返回以i为根节点的树的所有节点
	private static int dfs(int i) {
		visited[i]=true;
		int sum=1;//以i为根节点的树的所有节点数
		int res=0;//连通块点的最大值
		for(int j=h[i];j!=-1;j=ne[j]) {
			if(!visited[e[j]]) {
				int temp=dfs(e[j]);
				sum+=temp;
				res=Math.max(res, temp);
			}
		}
		res=Math.max(res, n-sum);
		ans=Math.min(ans, res);
		return sum;
	}

	static void Add(int a,int b) {
		e[idx]=b;
		ne[idx]=h[a];
		h[a]=idx++;
	}
}
