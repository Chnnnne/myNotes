package algorithm.贪心;

import java.util.PriorityQueue;
import java.util.Scanner;

public class FenceRepair {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			pq.offer(sc.nextInt());
		}
//		while(pq.peek()!=null) {
//			Integer poll = pq.poll();
//			System.out.println(poll);
//		}
		long sum=0;
		int temp;
		while(!pq.isEmpty()) {
			if(pq.size()==1) {
//				sum+=pq.poll();
				break;
			}
			temp=pq.poll()+pq.poll();
			sum+=temp;
			pq.offer(temp);
		}
		System.out.println(sum);

	}//main
}
