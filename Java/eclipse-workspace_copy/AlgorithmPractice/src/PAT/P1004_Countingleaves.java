package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class P1004_Countingleaves {
	static int MAXN=10;//2^7 7层就有100多个节点
	static HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer,ArrayList<Integer>>(); 
	static int maxDepth=-1;
	static int nums[]=new int[MAXN+1];	
	
	public static void main(String[] args) throws IOException {
		int N = Reader.nextInt();//node数
		int M = Reader.nextInt();//非叶结点数 
		if(M==0) {
			System.out.println(N);
		}
		else {
			
			int node,k,child;
			while(M--!=0) {
				node = Reader.nextInt();//节点
				ArrayList al=hm.containsKey(node)?hm.get(node):new ArrayList<Integer>();
				k = Reader.nextInt();//子节点数
				for (int i = 0; i < k; i++) {
					child=Reader.nextInt();
					al.add(child);
				}
				hm.put(node, al);
			}
			dfs(1, 0);
//		System.out.println(maxDepth);
			System.out.print(nums[0]);
			for (int i = 1; i <= maxDepth; i++) {
				System.out.print(" "+nums[i]);
			}
			System.out.println();
		}
	}//main
	//解空间树就是一个实在的树
	//访问新状态， 也即第node节点 在第cur层
	static void dfs(int node,int cur) {
		maxDepth=Math.max(maxDepth, cur);
		ArrayList<Integer> al = hm.get(node);
		if(al==null) {
			nums[cur]++;
		}else {
			for (Integer integer : al) {
				dfs(integer, cur+1);
			}
		}
	}
	
}
