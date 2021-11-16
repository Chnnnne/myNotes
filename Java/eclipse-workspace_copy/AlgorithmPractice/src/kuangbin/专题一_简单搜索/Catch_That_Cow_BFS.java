package kuangbin.专题一_简单搜索;

import java.util.LinkedList;
import java.util.Scanner;


class place{
	int val=0;
	int step=0;
	public place(int val, int step) {
		super();
		this.val = val;
		this.step = step;
	}
}

public class Catch_That_Cow_BFS {
	
	
	
	static int N;
	static int K;
	static boolean visited[]= new boolean[100010];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		if(N>=K)
		{
			System.out.println(N-K);
			return;
		}
		LinkedList<place> queue = new LinkedList<place>();
		visited[N]=true;
		queue.offer(new place(N,0));
		while(!queue.isEmpty()) {
			place poll = queue.poll();
			if(poll.val==K) {
				System.out.println(poll.step);
				break;
			}
			
			int x=poll.val;
			int step=poll.step;
			if(x-1>0&&!visited[x-1]) {
				visited[x-1]=true;
				queue.offer(new place(x-1, step+1));
			}
			if(x+1<=100000&&!visited[x+1]) {
				visited[x+1]=true;
				queue.offer(new place(x+1, step+1));
			}
			if(2*x<=100000&&!visited[2*x]) {
				visited[x*2]=true;
				queue.offer(new place(2*x, step+1));
			}
			
		}
		
	}//main
}
