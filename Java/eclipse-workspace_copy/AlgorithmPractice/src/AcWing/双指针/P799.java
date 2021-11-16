package AcWing.双指针;

import java.io.IOException;
import java.util.HashSet;

public class P799 {
	public static void main(String[] args) throws IOException {
		int n = Reader.nextInt();
		int a[]=new int[n];
		for (int i = 0; i < n; i++) {
			a[i]=Reader.nextInt();
		}
		int left=0,right=0;
		HashSet<Integer> hs = new HashSet<Integer>();
		int flag=-1;
		int res=0;
		while(right<n) {
			if(hs.contains(a[right])) {
				flag=a[right];
			}
			else {
				hs.add(a[right]);
			}
			while(left<right&&flag!=-1) {
				if(a[left]==flag)
				{
					flag=-1;
				}
				else {
					hs.remove(a[left]);
				}
				left++;
			}
			//flag=-1 窗口满足条件了
			res=Math.max(res, right-left+1);
			
			
			right++;
		}
		System.out.println(res);
	}//main
}
