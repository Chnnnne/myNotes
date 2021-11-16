package lanqiao.year2020_11th;

import java.io.IOException;



public class P_G {
	public static void main(String[] args) throws IOException {
		int n = Reader.nextInt();
		int huiwen = 0,abab=0;
		boolean stopFlag1=true;
		boolean stopFlag2=true;
		for(int i=n+1;i<100000000;i++) {
			if(stopFlag1&&HuiWen(i)) {
				huiwen=i; 
				stopFlag1=false;
			}
			if(stopFlag2&&ABAB(i)) {
				abab=i;
				stopFlag2=false;
			}
			if(!stopFlag1&&!stopFlag2)
				break;
		}
		System.out.println(huiwen);
		System.out.println(abab);

	}//main
	
	static boolean HuiWen(int a) {
		
		String str=a+"";
		char[] charArray = str.toCharArray();
		int left=0,right=charArray.length-1;
		while(left<right) {
			if(charArray[left]==charArray[right])
			{
				left++;
				right--;
			}else {
				break;
			}
		}
		
		if(left<right)
			return false;
		else
			return true;
	}
	static boolean ABAB(int a) {
		if(!HuiWen(a))
			return false;
		String str=a+"";
		char[] charArray = str.toCharArray();
		int len =charArray.length;
		char A=charArray[0];
		char B=charArray[1];
		if(charArray[2]!=A) return false;
		if(charArray[3]!=B) return false;
		if(charArray[4]!=B) return false;
		if(charArray[5]!=A) return false;
		if(charArray[6]!=B) return false;
		if(charArray[7]!=A) return false;
		return true;
		
	}
}
