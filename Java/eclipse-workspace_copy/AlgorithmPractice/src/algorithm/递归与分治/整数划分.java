package algorithm.递归与分治;

public class 整数划分 {
	public static void main(String[] args) {
		System.out.println(q(6, 6));
	}//main
	
	//返回整数n划分成最大加数不大于m的 情况数
	public static int q(int n,int m) {
		if(n==1||m==1) return 1;
		if(n<m) return q(n, n);
		if(n==m) return q(n, n-1)+1;
		return q(n, m-1)+q(n-m, m);
	}
}
