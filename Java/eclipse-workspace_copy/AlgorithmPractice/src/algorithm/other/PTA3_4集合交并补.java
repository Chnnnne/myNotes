package algorithm.other;

import java.util.HashSet;
import java.util.Scanner;

public class PTA3_4集合交并补 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		HashSet<Integer> firstSet = new HashSet<Integer>();
		HashSet<Integer> SecondSet = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			firstSet.add(sc.nextInt());
		}
		HashSet<Integer> tempSet = new HashSet<Integer>(firstSet);
		for (int i = 0; i < m; i++) {
			SecondSet.add(sc.nextInt());
		}
		firstSet.addAll(SecondSet);//并
		tempSet.retainAll(SecondSet);//交
		System.out.print(tempSet.size());
		if(tempSet.size()!=0) {
			for( Integer i : tempSet) {
				System.out.print(" "+i);
			}
		}
		System.out.println();
		System.out.print(firstSet.size());
		if(firstSet.size()!=0) {
			for( Integer i : firstSet) {
				System.out.print(" "+i);
			}
		}
	}//main
}
