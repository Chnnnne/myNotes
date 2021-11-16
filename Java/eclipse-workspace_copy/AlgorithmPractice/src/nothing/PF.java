package nothing;

import java.io.IOException;

public class PF {
	public static void main(String[] args) throws IOException {
//		System.out.println(new PF().HuiWen(new char[] {'a','b','c','a'}, 0, 4));
		int t = Reader.nextInt();
		while(t--!=0) {
			int n = Reader.nextInt();
			String str = Reader.next();
			char[] charArray = str.toCharArray();
			boolean flag=false;
			A:
			for(int i=0;i<n;i++) {
				for(int j=i+1;j<n;j++) {
					if(HuiWen(charArray,i,j)) {
						flag=true;
						System.out.println("Yes");
						break A;
					}
				}
			}
			if(!flag) System.out.println("No");
		}

	}//main

	private static boolean HuiWen(char[] charArray, int i, int j) {
		int l=0,r=charArray.length-1;
		while(l==i||l==j) l++;
		while(r==i||r==j) r--;
		while(l<r) {
			if(charArray[l]!=charArray[r]) return false;
			l++;
			r--;
			while(l==i||l==j) l++;
			while(r==i||r==j) r--;
		}
		return true;
	}
	
}
