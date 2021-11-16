package AcWing.搜索;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;



class state{
	String str=null;
	int step=0;
	public state(String str, int step) {
		super();
		this.str = str;
		this.step = step;
	}
}

public class 八数码 {

	static int dir[][]= {
			{0,1},
			{1,0},
			{0,-1},
			{-1,0},
	};
	
	
	static HashSet<String> hs = new HashSet<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		String start = nextLine.replace(" ", "");
		
		LinkedList<state> queue = new LinkedList<state>();
		state startState = new state(start, 0);
		//bfs
		hs.add(start);
		queue.offer(new state(start, 0));
		
		while(!queue.isEmpty()) {
			state poll = queue.poll();
			String str = poll.str;
			int step = poll.step;
			
			if(str.equals("12345678x")) {
				System.out.println(step);
				return;
			}
			
			//获取子状态String
			int index = str.indexOf('x');
			int x=index/3;//x的一维位置->二维
			int y=index%3;
			for(int i=0;i<4;i++) {
				int newx=x+dir[i][0];//新位置的二维坐标
				int newy=y+dir[i][1];
				
				if(isLegal(newx,newy)) {
					int newIndex=newx*3+newy;//新位置的一维坐标
					
					char[] charArray = str.toCharArray();//得到新状态的字符串
					char temp=charArray[newIndex];
					charArray[newIndex]=charArray[index];
					charArray[index]=temp;
					String newstr=new String(charArray);//得到新状态的字符串
					state newState=new state(newstr, step+1);//得到新状态!!!!!
					if(!hs.contains(newstr)) {
						hs.add(newstr);
						queue.offer(newState);
					}
				}
			}
			
		}
		System.out.println(-1);
	}//main
	private static boolean isLegal(int newx, int newy) {
		if(newx<0||newx>=3||newy<0||newy>=3)
			return false;
		return true;
	}
}
