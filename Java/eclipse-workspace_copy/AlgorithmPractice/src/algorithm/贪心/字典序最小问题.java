package algorithm.贪心;

import java.util.Iterator;
import java.util.Scanner;

public class 字典序最小问题 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char []arr=new char[N];
		for (int i = 0; i < N; i++) {
			arr[i]=sc.next().charAt(0);
		}
		int left=0,right=N-1;
		int l,r;
		StringBuilder strbil=new StringBuilder();
		while(left <= right) {
			l=left;
			r=right;
			while(arr[l]==arr[r]&&l < r) {
				l++;
				r--;
			}
			if(l>=r) {
				//任选一个
				strbil.append(arr[left++]);
				continue;
			}
			if(arr[l]>arr[r])
				strbil.append(arr[right--]);
			else
				strbil.append(arr[left++]);
			
		}
		for(int i=0;i<strbil.length();i++) {
			System.out.print(strbil.charAt(i));
			if((i+1)%80==0) System.out.println();
		}

	}//main
}
