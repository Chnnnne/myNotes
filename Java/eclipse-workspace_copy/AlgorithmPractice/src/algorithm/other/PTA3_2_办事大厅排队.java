package algorithm.other;

import java.util.LinkedList;
import java.util.Scanner;

public class PTA3_2_办事大厅排队 {
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		while((N--)!=0) {
			String str=sc.nextLine();
			if(str.contains("in")) {
				String[] split = str.split(" ");
				ll.offer(split[1]);
			}else if (str.equals("out")) {
				ll.poll();
			}else {
				if(ll.peek()!=null)
					System.out.println(ll.peek());
				else
					System.out.println("NULL");
			}
		}
	}//main
}
