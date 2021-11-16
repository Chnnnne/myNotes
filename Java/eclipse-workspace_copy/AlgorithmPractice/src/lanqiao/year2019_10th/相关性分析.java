package lanqiao.year2019_10th;

import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class 相关性分析 {

	public static void main(String[] args) {
		ArrayList<Integer> alice = new ArrayList<Integer>();
		ArrayList<Integer> bob = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.nextLine();// 吞回车，让下一个nextline读入文章
		String str = sc.nextLine();
		int index = -1;
		while (true) {
			// 找到了Alice之后
			index = str.indexOf("Alice", index + 1);
			if (index == -1)
				break;
			// 还要接着判断前后是否是字母
			if (index == 0) {
				if (Check(str.charAt(index + 5))) {
					alice.add(index);
				}
				continue;
			} else if (index + 4 == str.length() - 1) {
				if (Check(str.charAt(index - 1))) {
					alice.add(index);
				}
				continue;
			} else if (Check(str.charAt(index - 1)) && Check(str.charAt(index + 5))) {
				alice.add(index);
				continue;
			}
		}

		index = -1;
		while (true) {
			// 找到了Bob之后
			index = str.indexOf("Bob", index + 1);
			if (index == -1)
				break;
			// 还要接着判断前后是否是字母
			if (index == 0) {
				if (Check(str.charAt(index + 3))) {
					bob.add(index);
				}
				continue;
			} else if (index + 2 == str.length() - 1) {
				if (Check(str.charAt(index - 1))) {
					bob.add(index);
				}
				continue;
			} else if (Check(str.charAt(index - 1)) && Check(str.charAt(index + 3))) {
				bob.add(index);
				continue;
			}
		}
		System.out.println(alice);
		System.out.println(bob);
		
		int res = 0;
		//Alice 前面有多少Bob？
		//i 枚举遍历 Alice数组，滑窗根据每个i 滑动到指定位置然后计算res
		// l r 是 Boblist的区间下标
		
		//正常情况下:很好，得到的区间满足题意[l,r]为正确区间
		//而非正常情况下:比如r边界找不到，l边界找不到，此时一定会出现 r-l+1=0 真巧
		for(int i = 0, l = 0, r = -1 ; i <= alice.size()-1; i++) {
			int j = alice.get(i);
			int minindx = j-k;
			while(r < bob.size()-1 && bob.get(r+1) < j) r++;	//得到窗口的右边界
			while(l <= r && bob.get(l) < minindx ) l++;	//得到窗口的左边界
			System.out.println(r-l+1);
			res+=r-l+1;
		}
		//Bob前面，有多少Alice
		for(int i = 0, l = 0, r = -1 ; i <= bob.size()-1; i++) {
			int j = bob.get(i);
			int minindx = j-k;
			while( r < alice.size()-1 && alice.get(r+1) < j ) r++;
			while( l <= r &&alice.get(l) < minindx ) l++;	
			System.out.println(r-l+1);
			res+=r-l+1;
		}
		System.out.println(res);

	}

	// c不是字母的话返回true
	private static boolean Check(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
			return false;
		return true;
	}// main
}
