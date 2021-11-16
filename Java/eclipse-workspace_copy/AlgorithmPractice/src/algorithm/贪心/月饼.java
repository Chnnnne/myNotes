package algorithm.贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class MoonCake {
	int kucun;
	int zongjia;
	double pp;
	public MoonCake() {
		super();
	}
	public MoonCake(int kucun, int zongjia, double pp) {
		super();
		this.kucun = kucun;
		this.zongjia = zongjia;
		this.pp = pp;
	}
	@Override
	public String toString() {
		return "MoonCake [kucun=" + kucun + ", zongjia=" + zongjia + ", pp=" + pp + "]";
	}
	
	
}



public class 月饼 {
	
	public static void main(String[] args) {
		//做这道题遇到的 一些语法错误
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//月饼的种类
		int D = sc.nextInt();//市场需求
		double sell=0;
		MoonCake [] arr=new MoonCake[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i]=new MoonCake();
			arr[i].kucun=sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			arr[i].zongjia=sc.nextInt();
			arr[i].pp=(double)arr[i].zongjia/arr[i].kucun;
		}
		Arrays.sort(arr,1,N+1,(o1,o2)->(int)Math.signum(o2.pp-o1.pp));//按照pp降序
		
		for(int i=1 ;i<=N;i++) {
			if(D>=arr[i].kucun) {//剩余需求大于该商品的库存，那么还要接着买其他商品
				sell+=arr[i].zongjia;
				D-=arr[i].kucun;
			}
			else{//剩余需求只能买一部分商品了
				sell+=D*arr[i].pp;
				break;
			}
		}
		System.out.printf("%.2f",sell);
		
		
		

	}//main
}
