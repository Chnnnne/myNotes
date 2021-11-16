package algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 挖地雷 {
	public static final int MAXN = 22;//地窖最大值
	
	static int N=0;		//地窖数
	static boolean Graph[][]=new boolean[MAXN+1][MAXN+1];//地窖图
	static int nums[]=new int[MAXN+1];//地窖中的地雷数
	
//	解空间
	static int visit[]=new int[MAXN+1]; //visit[i]=value  代表第i个访问的是value地窖
	//static int visited[]=new int[MAXN+1];//visited[i]=true 第i个地窖被选上了
	static int Maxvisit[]=new int[MAXN+1]; 
	
	static int sum=0;				//已经挖的地雷总数
	static int Maxsum=0;			//挖的最大地雷总数

	static int totalStep=0;
	
	
	public static void main(String[] args) throws IOException {
		N=Reader.nextInt();
		for (int i = 1; i <= N; i++) {
			nums[i]=Reader.nextInt();
		}
		for(int i=1 ; i<=N-1;i++) {
			for(int j=i+1;j<=N;j++) {
				Graph[i][j]=Reader.nextInt()==1? true:false;
			}
		}

		for (int i = 1; i <= N; i++) {
			dfs(1,i);
		}
//		System.out.println("总共走了"+totalStep+"步");
		for (int i = 1; i < totalStep; i++) {
			System.out.print(Maxvisit[i]+" ");
		}
		System.out.println(Maxvisit[totalStep]);
		System.out.println(Maxsum);
		
		
	}//main
	
	//dfs的工作是访问新状态的新增参量：即在第cur步，走第x地窖
	//visit (X,X,X,X,X)  visit[i]=value  第i步走 value地窖
	public static void dfs(int cur,int x) {
		//不合法情况
		//判断是否可走
		boolean flag=false;
		visit[cur]=x;
		for(int i=1;i<=N;i++) {
			if(isLegal(cur+1,i)) {
				flag=true;
				break;
			}
		}
		//目标情况:无路可走
		if(flag==false) {
			visit[cur]=x;
			sum+=nums[x];
			if(sum>Maxsum)
			{
				Maxsum=sum;
				totalStep=cur;
				System.arraycopy(visit, 1, Maxvisit, 1, cur);
			}
			visit[cur]=0;
			sum-=nums[x];
			return;
		}
		
		//合法情况
		visit[cur]=x;
		sum+=nums[x];
		for(int i=1;i<=N;i++) {
			if(isLegal(cur+1,i))
				dfs(cur+1, i);
		}
		visit[cur]=0;
		sum-=nums[x];
	}
	//判断在第step步，走i地窖是否可行
	//地窖没被走过&&地窖是连通的
	static boolean isLegal(int step,int i) {
		//是否连接
		if(!Graph[visit[step-1]][i])
			return false;
		for(int j=1;j<=step-1;j++) {
			if(visit[j]==i)
				return false;
		}
		return true;
	}
}


