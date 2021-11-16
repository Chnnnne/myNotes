package nothing;

import java.io.IOException;
import java.util.Arrays;

public class PJ {
	public static void main(String[] args) throws IOException {
		int n = Reader.nextInt();
		int k = Reader.nextInt();
		int a[]=new int[n];
		int b[]=new int[n];
		for (int i = 0; i < n; i++) {
			a[i]=Reader.nextInt();
		}
		System.arraycopy(a, 0, b, 0, n);
		Arrays.sort(a);
		int seq=1;
		int index=-1;
		for(int i=0;i<n;i++) {
			if(a[i]==k) {
				index=i;
				break;
			}
		}
		if(index==-1) {
			for (int i = 0; i < n-1; i++) {
				System.out.print(b[i]+" ");
			}
			System.out.print(b[n-1]);
		}
		else {
			if(index!=n-1) {
				while(a[index+1]>=a[index]) {
					//断了
					if(a[index+1]>a[index]+1) break;
					//相同无影响
					if(a[index+1]==a[index]) {index++;
					if(index==n-1) break;
					else continue;}
					
					seq++;
					index++;
					if(index==n-1) break;
				}
			}
			
			
			for (int i = 0; i < n-1; i++) {
				System.out.print(((b[i]-seq<0)?0:(b[i]-seq))+" ");
			}
			System.out.print(((b[n-1]-seq<0)?0:(b[n-1]-seq)));
		}
		
	}//main
}
