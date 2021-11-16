package lanqiao.year2019_10th;

import java.util.Scanner;

public class P01_三升 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char [][]charArr=new char[100][100];
		for(int i=1;i<=30;i++) {
			String str = sc.next();
			for(int j=1;j<=50;j++) {
					charArr[i][j]=str.charAt(j-1);
			}
		}
		int count=0;
		int dir[][]={{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
		//八个方向，每个方向前进两个格
		for(int i=1;i<=30;i++) {
			for(int j=1;j<=50;j++) {
				char lastone=charArr[i][j];
				
				
				for(int k=0;k<8;k++) {//下面开始每个方向的遍历
					int indexi=i,indexj=j;
					for(int l=1;l<=2;l++) {
						indexi+=dir[k][0];
						indexj+=dir[k][1];
						if(indexi>30||indexi<1||indexj<1||indexj>50) {
							//此方向越界了！,开始下一个方向
							break;
						}
						else {
							if(charArr[indexi][indexj]>lastone) {
								lastone=charArr[indexi][indexj];
								if(l==2)
									count++;
							}
							else break;
						}
					}
				}
			}
		}
		System.out.println(count);
		
		
	}//main
}
