package algorithm.贪心;

import java.util.Arrays;
import java.util.Scanner;



class activity{
	int s,f;

	public activity() {
		super();
	}

	@Override
	public String toString() {
		return "activity [s=" + s + ", f=" + f + "]";
	}
	
	
	
}


public class 活动安排问题 {
	static int Infinity=(int)Math.pow(2, 31)-1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		activity [] arr=new activity[n+1]; 
		for (int i = 1; i <= n; i++) {
			arr[i]=new activity();
			arr[i].s=sc.nextInt();
			arr[i].f=sc.nextInt();
		}
		Arrays.sort(arr,1,n+1,(o1,o2)->o1.f-o2.f);
		int count=0,last=-Infinity;
		for(int i=1; i<= n;i++) {
			if(arr[i].s>=last) {
				count++;
				last=arr[i].f;
			}
		}
		System.out.println(count);

	}//main
}
