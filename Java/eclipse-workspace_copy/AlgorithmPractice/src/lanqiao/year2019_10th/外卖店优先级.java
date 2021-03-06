package lanqiao.year2019_10th;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 外卖店优先级 {
	public static final int MAXN = 10010;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		int level[] = new int[MAXN];
		// 第key时间，有外卖的店家id-list
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
		while (m-- != 0) {
			int time = sc.nextInt();
			int id = sc.nextInt();
			if (!hm.containsKey(time)) {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(id);
				hm.put(time, al);
			} else {
				ArrayList<Integer> al = hm.get(time);
				al.add(id);
				hm.put(time, al);
			}
		}
		
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		for (int i = 1; i <= t; i++) {//每一时刻
			ArrayList<Integer> al = hm.get(1);
			if (al == null) {
				continue;
			} else {
				for(int j = 1; j <= n;j++) {//每个外卖店
					if(al.contains(j)) {
						level[j]+=2;
						if(level[j]>=5) hs.add(j);
					}else {
						if(level[j]>0) {
							level[j]--;
							if(level[j]<=3) hs.remove(j);
						}
					}
				}
			}
		}
		System.out.println(hs.size());
	}// main
}
