package lanqiao.year2018_9th;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class P08_全球变暖 {
	public static void main(String[] args) {
		ArrayList<HashSet<point>> list = new ArrayList<HashSet<point>>();
		int N;
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		char [][] mat=new char[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			String str=sc.next();
			for (int j = 1; j <= N; j++) {
				mat[i][j]=str.charAt(j-1);
			}
		}
		for (int i = 2; i <= N-1; i++) 
		{
			for (int j = 2; j <= N-1; j++) 
			{
				if(mat[i][j]=='.') continue;
				point thiPoint = new point(i,j);
			}
		}
		
	}//main
}


class point{
	int x,y;

	public point(int x,int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public point() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		point other = (point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
