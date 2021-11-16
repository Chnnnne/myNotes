package lanqiao.year2018_9th;

public class P05_画图形 {
	static int n=5;
	static int maxlength=(int)Math.pow(3, 5);
	static char [][] c=new char[maxlength+1][maxlength+1];
	public static void main(String[] args) {
		fill(2, 1, 1);
		int length=(int)Math.pow(3, 2);
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= length; j++) {
				System.out.print(c[i][j]);
			}
			System.out.println();
		}
	}//main
	//以(x,y)为左上角，画一个度为n的图形
	public static void fill(int n,int x,int y) {
		if(n==0) {
			c[x][y]='o';
		}
		else {
			int len=(int) Math.pow(3, n-1);
			fill(n-1, x+len, y);
			fill(n-1, x, y+len);
			fill(n-1, x+len, y+len);
			fill(n-1, x+2*len, y+len);
			fill(n-1, x+len, y+2*len);
		}
	}

}
