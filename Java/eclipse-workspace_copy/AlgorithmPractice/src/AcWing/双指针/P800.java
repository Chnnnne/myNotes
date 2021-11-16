package AcWing.双指针;

import java.io.IOException;

public class P800 {
	public static void main(String[] args) throws IOException {
		int n = Reader.nextInt();
		int m = Reader.nextInt();
		int x = Reader.nextInt();
		int A[] = new int[n];
		int B[] = new int[m];
		for(int i=0;i<n;i++) {
			A[i]= Reader.nextInt();
		}
		for(int i=0;i<m;i++) {
			B[i]= Reader.nextInt();
		}
		int i=0,j=m-1;
		while(i<n) {
			while(A[i]+B[j]>x) {
				j--;
			}
			if(A[i]+B[j]==x)
				break;
			i++;
		}
		System.out.println(i+" "+j);

	}//main
}
