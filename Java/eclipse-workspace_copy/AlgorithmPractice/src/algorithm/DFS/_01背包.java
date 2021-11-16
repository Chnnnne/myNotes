package algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//此题为寻找最优解，因此到达目标状态后要回溯，直到遍历所有解，
//也因此需要设置一个变量和最优变量来记录

//解空间是 (X,X,X,X,X,X,X) 
public class _01背包 {
	
	public static final int MAXN = 100;//物品的最大值
	
	static int Weight=0;//背包的承重
	static int StfNum=0;//物品的总数量
	static int StfWit[]=new int[MAXN+1];//每个物品的重量
	static int StfPrz[]=new int[MAXN+1];//每个物品的价值
	
	static int totalPrize=0;
	static int choose[]=new int[MAXN+1];
	
	static int MaxtotalPrize=0;
	static int Maxchoose[]=new int[MAXN+1];
	
	//访问新状态的第cur个新增参量
	public static void dfs(int cur) {
		//不合法状态
		//目标状态
		if(cur>StfNum) {
			if(totalPrize>MaxtotalPrize)
			{
				MaxtotalPrize=totalPrize;
				System.arraycopy(choose, 1, Maxchoose, 1, StfNum);
			}
			return;
		}
		//合法状态
		if(Weight>=StfWit[cur])
		{
			choose[cur]=1;//选该物品
			totalPrize+=StfPrz[cur];
			Weight-=StfWit[cur];
			dfs(cur+1);
			choose[cur]=0;
			totalPrize-=StfPrz[cur];
			Weight+=StfWit[cur];
			
			dfs(cur+1);//不选
			
		}
		else {//不能选
			dfs(cur+1);//不选
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		Weight = Reader.nextInt();
		StfNum = Reader.nextInt();
		
		for (int i = 1; i <= StfNum; i++) {
			StfWit[i]=Reader.nextInt();
		}
		for (int i = 1; i <= StfNum; i++) {
			StfPrz[i]=Reader.nextInt();
		}
		
		dfs(1);
		System.out.println(MaxtotalPrize);
		for (int i = 1; i <= StfNum; i++) {
			System.out.print(Maxchoose[i]+" ");
		}
	}//main
}


