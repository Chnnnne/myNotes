package algorithm.数据结构.图论;

import java.util.Arrays;
import java.util.Scanner;

public class 图的存储_yxc {

	public static final int MAXN = 20;
	static int n,m;
	static int h[]=new int[MAXN];
	static int e[]=new int[MAXN];
	static int w[]=new int[MAXN];
	static int ne[]=new int[MAXN];
	static int index=0;
	public static void main(String[] args) {
		Arrays.fill(h, -1);
		Arrays.fill(ne, -1);
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		for (int i = 0; i < m; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			int w=sc.nextInt();
			Add(x,y,w);
		}
		for(int i=0;i<n;i++) {
			System.out.print("以顶点i为弧尾的边：");
			for(int j=h[i];j!=-1;j=ne[j]) {
				System.out.print(e[j]+" ");
			}
			System.out.println();
		}

	}//main
	
	
	//index：边号
	//h[i] 顶点i的的一条边号
	//e[index] index边的弧头
	//ne[index] index边的下一条边
	//w[index]  index边的权值
	private static void Add(int u, int v, int weight) {
		e[index]=v;		//创建index边
		w[index]=weight;//创建index边
		ne[index]=h[u];	//确定index边的下一条边，把边加入到链表
		h[u]=index;		//把边加入到链表
		index++;
	}
}
