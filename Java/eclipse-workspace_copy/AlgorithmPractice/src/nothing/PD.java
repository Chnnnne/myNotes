package nothing;

import java.io.IOException;


public class PD {
	public static void main(String[] args) throws IOException {
		int t = Reader.nextInt();
		while(t--!=0) {
			int n = Reader.nextInt();
			int x = Reader.nextInt();
			int y = Reader.nextInt();
			while(true) {
				int lx=findlevel(x,n);
				int ly=findlevel(y,n);
				if(lx==ly) {
					if(x==y) {
						System.out.println(x);
						break;
					}
					x=findparent(x,n);
					y=findparent(y,n);
				}
				else if(lx>ly) {
					x=findparent(x,n);
				}
				else {
					y=findparent(y,n);
				}
			}
		}

	}//main

	private static int findparent(int x, int n) {
		if(n==1) return x-1;
		int level=findlevel(x, n);
		int start=(int) ((1-Math.pow(n, level-1))/(1-n)+1);
		int laststart=(int) ((1-Math.pow(n, level-2))/(1-n)+1);
		return laststart+((x-start)/n);
	}

	private static int findlevel(int x, int n) {
		if(n==1) return x;
		return (int) Math.ceil( Math.log(x*(n-1)+1)/Math.log(n) );
	}
}
