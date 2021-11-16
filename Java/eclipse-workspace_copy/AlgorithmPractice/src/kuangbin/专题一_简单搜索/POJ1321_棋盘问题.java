package kuangbin.专题一_简单搜索;

import java.util.ArrayList;
import java.util.Scanner;

class point{
	int x,y;

	public point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class POJ1321_棋盘问题 {
	
	
	public static final int MAXN = 10;
	static int n=0,k=0,kk=0,ans=0;
	static char g[][]=new char[MAXN][MAXN];
	static ArrayList<point> points=new ArrayList<>();
	
	static boolean [] row=new boolean[MAXN];
	static boolean [] col=new boolean[MAXN];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();
			k = sc.nextInt();
			if(n==-1&& k==-1)
				return;
			ans=0;
			kk=0;
			points.clear();
			for (int i = 1; i <= n; i++) {
				String str=sc.next();
				for(int j = 1; j <= n; j++) {
					if(str.charAt(j-1)=='#') {
						points.add(new point(i,j));
					}
					g[i][j]=str.charAt(j-1);
				}
			}
			
			dfs(1);
			System.out.println(ans);
			
		}
		

	}//main

	private static void dfs(int cur) {
		if(cur>points.size()) {
			if(kk==k) {
				ans++;
			}
			return;
		}
		
		
		//第cur个空位置，可以填上棋子，也可以不填
		//不填
		dfs(cur+1);
		
		//填
		int x=points.get(cur-1).x;
		int y=points.get(cur-1).y;
		if(!row[x]&&!col[y]) {
			row[x]=true; col[y]=true;kk++;
			dfs(cur+1);
			row[x]=false; col[y]=false;kk--;
		}
	}
}
