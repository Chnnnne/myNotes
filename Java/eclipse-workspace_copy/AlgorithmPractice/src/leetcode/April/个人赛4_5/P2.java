package leetcode.April.个人赛4_5;

public class P2 {

	public static void main(String[] args) {
		int num =10;
		for(int i=0;i<num;i++) {
			for(int j=0;j<num;j++) {
				System.out.print(new P2().orchestraLayout(num, i, j)+ " ");
			}
			System.out.println();
		}

	}// main

	public int orchestraLayout(int num, int xPos, int yPos) {
		int updown = num - 1;
		int leftright = num;
		int nowI = 0;
		int nowJ = -1;
		int count = 0;
		while (true) {
			// 右
			count += leftright;
			nowJ += leftright;
			if(nowI==xPos&&yPos<=nowJ) return(count-(nowJ-yPos))%9==0?9:(count-(nowJ-yPos))%9;
			leftright--;
			// 下
			count+= updown;
			nowI+= updown;
			if(nowJ==yPos&&xPos<=nowI) return(count-(nowI-xPos))%9==0?9:(count-(nowI-xPos))%9;
			updown--;
			// 左
			count+=leftright;
			nowJ-=leftright;
			if(nowI==xPos&&yPos>=nowJ) return(count-(yPos-nowJ))%9==0?9:(count-(yPos-nowJ))%9;
			leftright--;
			// 上
			count+=updown;
			nowI-= updown;
			if(nowJ==yPos&&xPos>=nowI) return(count-(xPos-nowI))%9==0?9:(count-(xPos-nowI))%9;
			updown--;
		}
	}
}
