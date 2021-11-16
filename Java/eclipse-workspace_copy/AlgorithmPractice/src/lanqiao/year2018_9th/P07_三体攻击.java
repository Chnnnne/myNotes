package lanqiao.year2018_9th;

import java.util.Scanner;


public class P07_三体攻击 {
	public static void main(String[] args) {
		int A,B,C,m;//战舰共A层B行C列
		int d[][][]=new int [205][205][205];//d[i][j][k]代表(i,j,k)飞船的生命值
		Scanner sc = new Scanner(System.in);
		A=sc.nextInt();B=sc.nextInt();C=sc.nextInt();m=sc.nextInt();
		for (int i = 1; i <= A; i++) {
			for (int j = 1; j <= B; j++) {
				for (int k = 1; k <= C; k++) {
					d[i][j][k]=sc.nextInt();
				}
			}
		}
		
		//三体人的m次攻击
		boolean state=true;
		for (int w = 0; w < m; w++) {
			int  lat,rat,lbt,rbt,lct,rct,ht;
			lat=sc.nextInt();
			rat=sc.nextInt();
			lbt=sc.nextInt();
			rbt=sc.nextInt();
			lct=sc.nextInt();
			rct=sc.nextInt();
			ht=sc.nextInt();
			for(int i=lat;i<=rat&&state;i++) {
				for(int j=lbt;j<=rbt&&state;j++) {
					for(int k=lct;k<=rct&&state;k++) {
						if(i<1||j<1||k<1||i>A||j>B||k>C)
							continue;
						else {
							d[i][j][k]-=ht;
							if (d[i][j][k]<0) {
								System.out.println(w+1);
								state=false;
								return;
							}
						}
					}
				}
			}
		}
		sc.close();
		
		
	}//main
}
