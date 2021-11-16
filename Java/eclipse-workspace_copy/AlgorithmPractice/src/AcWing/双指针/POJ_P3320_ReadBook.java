package AcWing.双指针;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class POJ_P3320_ReadBook {
	public static void main(String[] args) throws IOException {
		int P = Reader.nextInt();
		int a[]=new int[P];
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < P; i++) {
			a[i]=Reader.nextInt();
			hs.add(a[i]);
		}
		
		int allKind = hs.size();
		int l=0,r=0;
		HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();//记录窗口内每个字符出现的次数
		int curkind=0;
		int res=P;
		while(l<P) {
			
			while(r<P&&curkind<allKind) {
				if(hm.containsKey(a[r])) {
					hm.put(a[r], hm.get(a[r])+1);
				}else {
					hm.put(a[r], 1);
					curkind++;
				}
				r++;
			}
			if(curkind<allKind) break;
			
			res=Math.min(res, r-l);
			
			if (hm.get(a[l])==1) {
				curkind--;
				hm.remove(a[l]);
			}
			else {
				hm.put(a[l], hm.get(a[l])-1);
			}
			l++;
		}
		System.out.println(res);

	}//main
}
